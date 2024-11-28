
package iasemaforojade;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import visualizacao.Tela;

/**
 *
 * @author MarcoAntônio, Italo, Wellison
 */
public class Plano extends Agent {
    public Integer[] temposem1 = new Integer[2];
    public Integer[] temposem2 = new Integer[2];
    public String flux1 = "0", flux2 = "0";
    public String f1 = "1", f2 = "1";
    public Integer preferencia;
    public int cont=0, ciclosmf=0, auxciclosmf = 0;
    public boolean a = false, b = false, hafluxos = false, first = true, attLabels = false;
    public Tela tela;

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public Integer[] getTemposem1() {
        return temposem1;
    }

    public void setTemposem1(Integer[] temposem1) {
        this.temposem1 = temposem1;
    }

    public Integer[] getTemposem2() {
        return temposem2;
    }

    public void setTemposem2(Integer[] temposem2) {
        this.temposem2 = temposem2;
    }

    public Integer getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Integer preferencia) {
        this.preferencia = preferencia;
    }

    public String getFlux1() {
        return flux1;
    }

    public void setFlux1(String flux1) {
        this.flux1 = flux1;
    }

    public String getFlux2() {
        return flux2;
    }

    public void setFlux2(String flux2) {
        this.flux2 = flux2;
    }

    @Override
    protected void setup(){
        tela = new Tela(this);//inicia a tela de visualização
        tela.setVisible(true);
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();//recebe mensagem de outro agente
                if(msg!=null){//verifica o conteudo da mensagem
                    if(msg.getSender().getLocalName().equals("Sensor1")){//verifica o remetente
                        f1 = msg.getContent();//grava o fluxo do remetente
                        //setFlux1(msg.getContent());
                        setA(true);
                    }else if(msg.getSender().getLocalName().equals("Sensor2")){//verifica o remetente
                        f2 = msg.getContent();//grava o fluxo do remetente
                        //setFlux2(msg.getContent());
                        setB(true);
                    }
                    
                    //só irá atualizar os fluxos depois de 3 ciclos do semáforo
                    if(isA() && isB() && auxciclosmf >= 3 || isA() && isB() && first){
                        setFlux1(f1);
                        setFlux2(f2);
                        determinarTempos(getFlux1(), getFlux2());//determina o tempo com base nos fluxos das vias
                        hafluxos = true;
                        first = false;
                        attLabels = true;
                        setA(false);
                        setB(false);
                    }
                }else block();
                if(hafluxos){
                    if (attLabels) tela.attLabels2(getFlux1(), getFlux2(), getTemposem1()[0], getTemposem2()[0], ciclosmf);
                    try {
                        atualizarSemaforos(tela);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Plano.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    public void atualizarSemaforos(Tela tela) throws InterruptedException{
        tela.attLabels1("verde");
        Thread.sleep(getTemposem1()[0]*1000-2000);
        //Thread.sleep(4000);
        
        tela.attLabels1("amarelo1");
        Thread.sleep(2000);
        
        tela.attLabels1("vermelho");
        Thread.sleep(getTemposem1()[1]*1000-2000);
        //Thread.sleep(4000);
        
        tela.attLabels1("amarelo2");
        Thread.sleep(2000);
        
        ciclosmf++;
        auxciclosmf++;
    }
    
    //essa função diz quanto tempo cada semáforo terá para abrir ou fechar
    public void determinarTempos(String f1, String f2){
        Integer fluxo1 = Integer.parseInt(f1);
        Integer fluxo2 = Integer.parseInt(f2);
        Integer fluxo;
        Integer[] tempos1 = {35, 35};//tempos {verde, vermelho}
        Integer[] tempos2 = {35, 35};//tempos {verde, vermelho}
        //tela.attLabels1("red");
        
        if(fluxo1>=fluxo2){
            setPreferencia(1);
            fluxo = fluxo1;
        }else{
            setPreferencia(2);
            fluxo = fluxo2;
        }
        
        compararTempos(tempos1, tempos2, fluxo);
        setTemposem1(tempos1);
        setTemposem2(tempos2);
        cont++;
        System.out.println("Verificação: "+cont);
        System.out.println("Fluxo1: "+fluxo1+"; Fluxo2: "+fluxo2);
        System.out.println("Semaforo1: tempo verde - "+tempos1[0]);
        System.out.println("Semaforo2: tempo verde - "+tempos2[0]);
        
        enviarTemposCores(tempos1[0], tempos2[0]);
    }
    
    //essa atribui tempos de semaforo com base nos fluxos
    public void compararTempos(Integer[] tempos1, Integer[] tempos2, Integer fluxo){
        
        if(getPreferencia() == 1){
            if(fluxo>=25){
                tempos1[0] = 50;
                tempos1[1] = 25;
            }else if(fluxo<25 && fluxo>=20){
                tempos1[0] = 45;
                tempos1[1] = 25;
            }else if(fluxo<20 && fluxo>=15){
                tempos1[0] = 40;
                tempos1[1] = 25;
            }else if(fluxo<15 && fluxo>=10){
                tempos1[0] = 35;
                tempos1[1] = 25;
            }else if(fluxo<10 && fluxo>=5){
                tempos1[0] = 35;
                tempos1[1] = 30;
            }else if(fluxo<5){
                tempos1[0] = 35;
                tempos1[1] = 35;
            }
            tempos2[0] = tempos1[1];
            tempos2[1] = tempos1[0];
            setTemposem1(tempos1);
            setTemposem1(tempos2);
        }else{
            if(fluxo>=25){
                tempos2[0] = 50;
                tempos2[1] = 25;
            }else if(fluxo<25 && fluxo>=20){
                tempos2[0] = 45;
                tempos2[1] = 25;
            }else if(fluxo<20 && fluxo>=15){
                tempos2[0] = 40;
                tempos2[1] = 25;
            }else if(fluxo<15 && fluxo>=10){
                tempos2[0] = 35;
                tempos2[1] = 25;
            }else if(fluxo<10 && fluxo>=5){
                tempos2[0] = 35;
                tempos2[1] = 30;
            }else if(fluxo<5){
                tempos2[0] = 35;
                tempos2[1] = 35;
            }
            tempos1[0] = tempos2[1];
            tempos1[1] = tempos2[0];
            setTemposem1(tempos1);
            setTemposem1(tempos2);
        }
        
    }
    
    public void enviarTemposCores(Integer tSemaforo1, Integer tSemaforo2){//enviará os tempos aos semaforos
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage msg1 = new ACLMessage(ACLMessage.INFORM);
                ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
                msg1.setContent("1"+tSemaforo1.toString());
                msg2.setContent("2"+tSemaforo2.toString());
                msg1.addReceiver(new AID("Semaforo1", AID.ISLOCALNAME));
                msg2.addReceiver(new AID("Semaforo2", AID.ISLOCALNAME));
                send(msg1);
                send(msg2);
            }
        });
    }
    
}
