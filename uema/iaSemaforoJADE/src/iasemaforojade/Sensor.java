
package iasemaforojade;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcoAntônio, Italo, Wellison
 */
public class Sensor extends Agent {
    public Integer flux = 0;

    public Integer getFlux() {
        return flux;
    }

    public void setFlux(Integer flux) {
        this.flux = flux;
    }

    
    
    @Override
    protected void setup() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                observarFluxos();//determina os fluxos
                enviarFluxo(getFlux());
                
                try {
                    Thread.sleep(50000);//espera 30s antes de começar um novo ciclo
                    //Thread.sleep(10000);//espera 30s antes de começar um novo ciclo
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void observarFluxos(){//determina os fluxos
        Random rd = new Random();
        int f1 = rd.nextInt(30);
        if(f1 == 0) f1 = 1;
        setFlux(f1);
    }
    
    public void enviarFluxo(Integer fluxo){
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setContent(fluxo.toString());
        msg.addReceiver(new AID("Plano", AID.ISLOCALNAME));
        send(msg);
    }
}
