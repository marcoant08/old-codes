/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacao;

import iasemaforojade.Plano;
import iasemaforojade.Sensor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author MarcoAntônio, Italo, Well
 */
public class Tela extends javax.swing.JFrame implements ActionListener {

    public ImageIcon mapa, vermelho1, verde1, amarelo1, vermelho2, verde2, amarelo2, carro2, carro1, relogio;//imagens
    public int seg = 0, tmp = 0;//auxilia na contagem de tempo
    public int totalcarros1 = 0;//conta o total de carros que passou pela via 1
    public int totalcarros2 = 0;//conta o total de carros que passou pela via 2
    public Timer timer;//timer para executar o programa ciclicamente
    public int flux1 = 99999, flux2 = 99999, taxa1 = 0, taxa2 = 0;//fluxo de carros e tempo medio para o proximo carro ser chamado
    public Random rd = new Random();
    //public int totalvia1 = 0, totalvia2 = 0;
    public String corVia2 = "amarelo", corVia1 = "amarelo";//cor do semaforo das vias 1 e 2
    public int aux1v2 = 0, aux2v2 = 15, aux1v1 = 0, aux2v1 = 15,//irão auxiliar em qual faixa o carro fica
            fila1via1 = 0, fila2via1 = 0, fila1via2 = 0, fila2via2 = 0;//fila de carros parados no sinal vermelho
    public boolean isRun = false;//programa em execução
    public boolean vendoEstatisticas = false;//as estatisticas estão sendo mostradas
    public boolean jaescolheuf1v2=false,jaescolheuf2v2=false,jaescolheuf1v1=false,jaescolheuf2v1=false;
    
    //as variaveis "c" e "ci" auxiliam na escolha do proximo carro a ser chamado
    private int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, c10=0, c11=0, c12=0, c13=0, c14=0, c15=0,
            c16=0, c17=0, c18=0, c19=0, c20=0, c21=0, c22=0, c23=0, c24=0, c25=0, c26=0, c27=0, c28=0, c29=0,c30=0;
    private int ci1=0, ci2=0, ci3=0, ci4=0, ci5=0, ci6=0, ci7=0, ci8=0, ci9=0, ci10=0, ci11=0, ci12=0, ci13=0,
            ci14=0, ci15=0, ci16=0, ci17=0, ci18=0, ci19=0, ci20=0, ci21=0, ci22=0, ci23=0, ci24=0, ci25=0, ci26=0, ci27=0, ci28=0, ci29=0,ci30=0;
    
    //posições dos carros da via 1
    public int[][] posCarros1 =    {{405, -80},{405, -80},{405, -80},{405, -80},{405, -80},
                                    {405, -80},{405, -80},{405, -80},{405, -80},{405, -80},
                                    {405, -80},{405, -80},{405, -80},{405, -80},{405, -80},
                                    {367, -80},{367, -80},{367, -80},{367, -80},{367, -80},
                                    {367, -80},{367, -80},{367, -80},{367, -80},{367, -80},
                                    {367, -80},{367, -80},{367, -80},{367, -80},{367, -80}};
    
    //posições dos carros da via 1
    public int[][] posCarros2 =    {{865, 310},{865, 310},{865, 310},{865, 310},{865, 310},
                                    {865, 310},{865, 310},{865, 310},{865, 310},{865, 310},
                                    {865, 310},{865, 310},{865, 310},{865, 310},{865, 310},
                                    {865, 275},{865, 275},{865, 275},{865, 275},{865, 275},
                                    {865, 275},{865, 275},{865, 275},{865, 275},{865, 275},
                                    {865, 275},{865, 275},{865, 275},{865, 275},{865, 275}};
    /**
     * Creates new form Tela
     */
    public Tela(Plano p) {
        initComponents();
        //setSize(800, 570);
        setSize(800, 600);//inicia a tela com tamanho predefinido
        jLabel1.setSize(800, 570);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        time.setBackground(Color.white);
        vermelho1 = new ImageIcon("src\\imagens\\vermelho1.png");
        amarelo1 = new ImageIcon("src\\imagens\\amarelo1.png");
        verde1 = new ImageIcon("src\\imagens\\verde1.png");
        vermelho2 = new ImageIcon("src\\imagens\\vermelho2.png");
        amarelo2 = new ImageIcon("src\\imagens\\amarelo2.png");
        verde2 = new ImageIcon("src\\imagens\\verde2.png");
        carro1 = new ImageIcon("src\\imagens\\carro1.png");
        carro2 = new ImageIcon("src\\imagens\\carro2.png");
        relogio = new ImageIcon("src\\imagens\\relogio.png");
        tv1.setVisible(false);
        tv2.setVisible(false);
        mediavia1.setVisible(false);
        mediavia2.setVisible(false);
        fluxo1.setVisible(false);
        fluxo2.setVisible(false);
        ciclosemaforo.setVisible(false);
        lbtotal1.setVisible(false);
        lbtotal2.setVisible(false);
        //gerarFluxo();
        criarCarros1();//cria carros da via 1
        criarCarros2();//cria carros da via 2
        timer = new Timer(10, this);//executa um ciclo a cada 10 milisegundos
        timer.start();//inicia o ciclo
        try {
            Thread.sleep(10000);//atraso de 10s para que tudo já esteja iniciado antes de iniciar a execução
        } catch (InterruptedException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.isRun = true; 
    }
    
    public void attLabels1(String cor){//atualiza os labels dos semaforos e temporizador
        if(cor.equals("vermelho")){
            this.seg = 0;
            sem1i.setIcon(vermelho1);
            sem1ii.setIcon(vermelho1);
            sem2i.setIcon(verde2);
            sem2ii.setIcon(verde2);
            this.corVia2 = "verde";
            this.corVia1 = "vermelho";
        }else if(cor.equals("amarelo1")){
            sem1i.setIcon(amarelo1);
            sem1ii.setIcon(amarelo1);
            this.corVia1 = "amarelo";
        }else if(cor.equals("amarelo2")){
            sem2i.setIcon(amarelo2);
            sem2ii.setIcon(amarelo2);
            this.corVia2 = "amarelo";
        }else{
            this.seg = 0;
            sem1i.setIcon(verde1);
            sem1ii.setIcon(verde1);
            sem2i.setIcon(vermelho2);
            sem2ii.setIcon(vermelho2);
            this.corVia2 = "vermelho";
            this.corVia1 = "verde";
        }
    }
    
    public void attLabels2(String f1, String f2, Integer t1, Integer t2, int cs){//atualiza labels de fluxo
        this.flux1 = Integer.parseInt(f1);
        this.flux2 = Integer.parseInt(f2);
        DecimalFormat decimal = new DecimalFormat("0.0");
        criarCarros2();
        fluxo1.setText("Fluxo da via 1: "+f1+" Carros/Minuto");
        fluxo2.setText("Fluxo da via 2: "+f2+" Carros/Minuto");
        mediavia1.setText("em média, está passando 1 carro a cada "+decimal.format(60/flux1)+" segundos na via 1.");
        mediavia2.setText("em média, está passando 1 carro a cada "+decimal.format(60/flux2)+" segundos na via 2.");
        tv1.setText("A via 1 ficará aberta por "+t1+"s.");
        tv2.setText("A via 2 ficará aberta por "+t2+"s.");
        ciclosemaforo.setText("Os semáforos já concluíram "+cs+" ciclos.");
        iniciando.setText("");
        //System.out.println("Atualizou a porra. ciclo: "+ciclosemaforo);
    }
    
    public void criarCarros1(){//cria carros da via 1 em labels
        cvi1.setIcon(carro1); cvi1.setSize(25, 55);
        cvi1.setLocation(posCarros1[0][0], posCarros1[0][1]);
        cvi2.setIcon(carro1); cvi2.setSize(25, 55);
        cvi2.setLocation(posCarros1[1][0], posCarros1[1][1]);
        cvi3.setIcon(carro1); cvi3.setSize(25, 55);
        cvi3.setLocation(posCarros1[2][0], posCarros1[2][1]);
        cvi4.setIcon(carro1); cvi4.setSize(25, 55);
        cvi4.setLocation(posCarros1[3][0], posCarros1[3][1]);
        cvi5.setIcon(carro1); cvi5.setSize(25, 55);
        cvi5.setLocation(posCarros1[4][0], posCarros1[4][1]);
        cvi6.setIcon(carro1); cvi6.setSize(25, 55);
        cvi6.setLocation(posCarros1[5][0], posCarros1[5][1]);
        cvi7.setIcon(carro1); cvi7.setSize(25, 55);
        cvi7.setLocation(posCarros1[6][0], posCarros1[6][1]);
        cvi8.setIcon(carro1); cvi8.setSize(25, 55);
        cvi8.setLocation(posCarros1[7][0], posCarros1[7][1]);
        cvi9.setIcon(carro1); cvi9.setSize(25, 55);
        cvi9.setLocation(posCarros1[8][0], posCarros1[8][1]);
        cvi10.setIcon(carro1); cvi10.setSize(25, 55);
        cvi10.setLocation(posCarros1[9][0], posCarros1[9][1]);
        cvi11.setIcon(carro1); cvi11.setSize(25, 55);
        cvi11.setLocation(posCarros1[10][0], posCarros1[10][1]);
        cvi12.setIcon(carro1); cvi12.setSize(25, 55);
        cvi12.setLocation(posCarros1[11][0], posCarros1[11][1]);
        cvi13.setIcon(carro1); cvi13.setSize(25, 55);
        cvi13.setLocation(posCarros1[12][0], posCarros1[12][1]);
        cvi14.setIcon(carro1); cvi14.setSize(25, 55);
        cvi14.setLocation(posCarros1[13][0], posCarros1[13][1]);
        cvi15.setIcon(carro1); cvi15.setSize(25, 55);
        cvi15.setLocation(posCarros1[14][0], posCarros1[14][1]);
        cvi16.setIcon(carro1); cvi16.setSize(25, 55);
        cvi16.setLocation(posCarros1[15][0], posCarros1[15][1]);
        cvi17.setIcon(carro1); cvi17.setSize(25, 55);
        cvi17.setLocation(posCarros1[16][0], posCarros1[16][1]);
        cvi18.setIcon(carro1); cvi18.setSize(25, 55);
        cvi18.setLocation(posCarros1[17][0], posCarros1[17][1]);
        cvi19.setIcon(carro1); cvi19.setSize(25, 55);
        cvi19.setLocation(posCarros1[18][0], posCarros1[18][1]);
        cvi20.setIcon(carro1); cvi20.setSize(25, 55);
        cvi20.setLocation(posCarros1[19][0], posCarros1[19][1]);
        cvi21.setIcon(carro1); cvi21.setSize(25, 55);
        cvi21.setLocation(posCarros1[20][0], posCarros1[20][1]);
        cvi22.setIcon(carro1); cvi22.setSize(25, 55);
        cvi22.setLocation(posCarros1[21][0], posCarros1[21][1]);
        cvi23.setIcon(carro1); cvi23.setSize(25, 55);
        cvi23.setLocation(posCarros1[22][0], posCarros1[22][1]);
        cvi24.setIcon(carro1); cvi24.setSize(25, 55);
        cvi24.setLocation(posCarros1[23][0], posCarros1[23][1]);
        cvi25.setIcon(carro1); cvi25.setSize(25, 55);
        cvi25.setLocation(posCarros1[24][0], posCarros1[24][1]);
        cvi26.setIcon(carro1); cvi26.setSize(25, 55);
        cvi26.setLocation(posCarros1[25][0], posCarros1[25][1]);
        cvi27.setIcon(carro1); cvi27.setSize(25, 55);
        cvi27.setLocation(posCarros1[26][0], posCarros1[26][1]);
        cvi28.setIcon(carro1); cvi28.setSize(25, 55);
        cvi28.setLocation(posCarros1[27][0], posCarros1[27][1]);
        cvi29.setIcon(carro1); cvi29.setSize(25, 55);
        cvi29.setLocation(posCarros1[20][0], posCarros1[28][1]);
        cvi30.setIcon(carro1); cvi30.setSize(25, 55);
        cvi30.setLocation(posCarros1[29][0], posCarros1[29][1]);
    }
    
    public void criarCarros2(){//cria carros da via 1 em labels
        cv1.setIcon(carro2); cv1.setSize(55, 25);
        cv1.setLocation(posCarros2[0][0], posCarros2[0][1]);
        cv2.setIcon(carro2); cv2.setSize(55, 25);
        cv2.setLocation(posCarros2[1][0], posCarros2[1][1]);
        cv3.setIcon(carro2); cv3.setSize(55, 25);
        cv3.setLocation(posCarros2[2][0], posCarros2[2][1]);
        cv4.setIcon(carro2); cv4.setSize(55, 25);
        cv4.setLocation(posCarros2[3][0], posCarros2[3][1]);
        cv5.setIcon(carro2); cv5.setSize(55, 25);
        cv5.setLocation(posCarros2[4][0], posCarros2[4][1]);
        cv6.setIcon(carro2); cv6.setSize(55, 25);
        cv6.setLocation(posCarros2[5][0], posCarros2[5][1]);
        cv7.setIcon(carro2); cv7.setSize(55, 25);
        cv7.setLocation(posCarros2[6][0], posCarros2[6][1]);
        cv8.setIcon(carro2); cv8.setSize(55, 25);
        cv8.setLocation(posCarros2[7][0], posCarros2[7][1]);
        cv9.setIcon(carro2); cv9.setSize(55, 25);
        cv9.setLocation(posCarros2[8][0], posCarros2[8][1]);
        cv10.setIcon(carro2); cv10.setSize(55, 25);
        cv10.setLocation(posCarros2[9][0], posCarros2[9][1]);
        cv11.setIcon(carro2); cv11.setSize(55, 25);
        cv11.setLocation(posCarros2[10][0], posCarros2[10][1]);
        cv12.setIcon(carro2); cv12.setSize(55, 25);
        cv12.setLocation(posCarros2[11][0], posCarros2[11][1]);
        cv13.setIcon(carro2); cv13.setSize(55, 25);
        cv13.setLocation(posCarros2[12][0], posCarros2[12][1]);
        cv14.setIcon(carro2); cv14.setSize(55, 25);
        cv14.setLocation(posCarros2[13][0], posCarros2[13][1]);
        cv15.setIcon(carro2); cv15.setSize(55, 25);
        cv15.setLocation(posCarros2[14][0], posCarros2[14][1]);
        cv16.setIcon(carro2); cv16.setSize(55, 25);
        cv16.setLocation(posCarros2[15][0], posCarros2[15][1]);
        cv17.setIcon(carro2); cv17.setSize(55, 25);
        cv17.setLocation(posCarros2[16][0], posCarros2[16][1]);
        cv18.setIcon(carro2); cv18.setSize(55, 25);
        cv18.setLocation(posCarros2[17][0], posCarros2[17][1]);
        cv19.setIcon(carro2); cv19.setSize(55, 25);
        cv19.setLocation(posCarros2[18][0], posCarros2[18][1]);
        cv20.setIcon(carro2); cv20.setSize(55, 25);
        cv20.setLocation(posCarros2[19][0], posCarros2[19][1]);
        cv21.setIcon(carro2); cv21.setSize(55, 25);
        cv21.setLocation(posCarros2[20][0], posCarros2[20][1]);
        cv22.setIcon(carro2); cv22.setSize(55, 25);
        cv22.setLocation(posCarros2[21][0], posCarros2[21][1]);
        cv23.setIcon(carro2); cv23.setSize(55, 25);
        cv23.setLocation(posCarros2[22][0], posCarros2[22][1]);
        cv24.setIcon(carro2); cv24.setSize(55, 25);
        cv24.setLocation(posCarros2[23][0], posCarros2[23][1]);
        cv25.setIcon(carro2); cv25.setSize(55, 25);
        cv25.setLocation(posCarros2[24][0], posCarros2[24][1]);
        cv26.setIcon(carro2); cv26.setSize(55, 25);
        cv26.setLocation(posCarros2[25][0], posCarros2[25][1]);
        cv27.setIcon(carro2); cv27.setSize(55, 25);
        cv27.setLocation(posCarros2[26][0], posCarros2[26][1]);
        cv28.setIcon(carro2); cv28.setSize(55, 25);
        cv28.setLocation(posCarros2[27][0], posCarros2[27][1]);
        cv29.setIcon(carro2); cv29.setSize(55, 25);
        cv29.setLocation(posCarros2[20][0], posCarros2[28][1]);
        cv30.setIcon(carro2); cv30.setSize(55, 25);
        cv30.setLocation(posCarros2[29][0], posCarros2[29][1]);
    }
    
    public void reiniciarPosicoes1(){//reinicia as posições dos carros da via 1
        int[][] aux =    {{405, -80},{405, -80},{405, -80},{405, -80},{405, -80},
                          {405, -80},{405, -80},{405, -80},{405, -80},{405, -80},
                          {405, -80},{405, -80},{405, -80},{405, -80},{405, -80},
                          {367, -80},{367, -80},{367, -80},{367, -80},{367, -80},
                          {367, -80},{367, -80},{367, -80},{367, -80},{367, -80},
                          {367, -80},{367, -80},{367, -80},{367, -80},{367, -80}};
        this.posCarros1 = aux;
    }
    
    public void reiniciarPosicoes2(){//reinicia as posições dos carros da via 1
        int[][] aux =    {{865, 310},{865, 310},{865, 310},{865, 310},{865, 310},
                        {865, 310},{865, 310},{865, 310},{865, 310},{865, 310},
                        {865, 310},{865, 310},{865, 310},{865, 310},{865, 310},
                        {865, 275},{865, 275},{865, 275},{865, 275},{865, 275},
                        {865, 275},{865, 275},{865, 275},{865, 275},{865, 275},
                        {865, 275},{865, 275},{865, 275},{865, 275},{865, 275}};
        this.posCarros2 = aux;
    }
    
//    public void gerarFluxo(){
//        flux1 = rd.nextInt(31);
//        flux2 = rd.nextInt(31);
//        System.out.println("Fluxo1: "+flux1+" - Fluxo2: "+flux2);
//    }
    
    @Override
    public void actionPerformed(ActionEvent e) {//este método é o ciclo
        time.setText(seg/100+"s");//mostra o tempo de semáforo na tela
        seg++;
        
//        if(tmp > 500000) gerarFluxo();//a cada 500 segundos irá gerar um novo fluxo
//        if(tmp>500000) tmp = 0;
        //flux2 = 30;
        //System.out.println("Taxa: "+taxa2/100+" - Flux: "+60/flux2+" - aux1: "+aux1v2+" - Aux2:"+aux2v2);
        //60/fluxo é a fórmula que retorna o tempo de diferença entre os carros baseado no fluxo 
        if(flux1!=0) if(taxa1/100 >= 60/flux1 && isRun){//escolhe um carro da via 1 para andar a cada intervalo de tempo
            escolherCarro1();//chama o proximo carro que irá aparecer na via 1
            taxa1 = 0;//zera o tempo em que o proximo carro deverá ser chamado
            lbtotal1.setText(totalcarros1+" carros já passaram pela via 1.");
        }
        if(flux2!=0) if(taxa2/100 >= 60/flux2 && isRun){//escolhe um carro da via 2 para andar a cada intervalo de tempo
            escolherCarro2();//chama o proximo carro que irá aparecer na via 2
            taxa2 = 0;//zera o tempo em que o proximo carro deverá ser chamado
            lbtotal2.setText(totalcarros2+" carros já passaram pela via 2.");
        }
        taxa1++;//incrementa o tempo da via 1
        taxa2++;//incrementa o tempo da via 2
        if(posCarros1[14][1] > 615 && posCarros1[29][1] > 615){//recomeça o ciclo dos carros da via 1
            aux1v1 = 0;
            aux2v1 = 15;
            reiniciarPosicoes1();//reinicia as posições dos carros da via 1
            criarCarros1();//recria as labels dos carros com as posições renovadas
            ci1=0; ci2=0; ci3=0; ci4=0; ci5=0; ci6=0; ci7=0; ci8=0; ci9=0; ci10=0; ci11=0; ci12=0; ci13=0; ci14=0; ci15=0;
            ci16=0; ci17=0; ci18=0; ci19=0; ci20=0; ci21=0; ci22=0; ci23=0; ci24=0; ci25=0; ci26=0; ci27=0; ci28=0; ci29=0; ci30=0;
        }
        if(posCarros2[14][0] < -65 && posCarros2[29][0] < -65){//recomeça o ciclo dos carros da via 2
            aux1v2 = 0;
            aux2v2 = 15;
            reiniciarPosicoes2();//reinicia as posições dos carros da via 2
            criarCarros2();//recria as labels dos carros com as posições renovadas
            c1=0; c2=0; c3=0; c4=0; c5=0; c6=0; c7=0; c8=0; c9=0; c10=0; c11=0; c12=0; c13=0; c14=0; c15=0;
            c16=0; c17=0; c18=0; c19=0; c20=0; c21=0; c22=0; c23=0; c24=0; c25=0; c26=0; c27=0; c28=0; c29=0; c30=0;
        }
        
        //define de forma booleana a forma que o carro da via 1 irá andar
        if(corVia1.equals("vermelho")||corVia1.equals("amarelo")){ mexerCarro1(false);}
        else{
            this.fila1via1 = 0;//zera a fila de carros da faixa direita da via 1
            this.fila2via1 = 0;//zera a fila de carros da faixa esquerda da via 1
            mexerCarro1(true);
        }
        
        //define de forma booleana a forma que o carro da via 2 irá andar
        if(corVia2.equals("vermelho")||corVia2.equals("amarelo")){ mexerCarro2(false);}
        else{
            this.fila1via2 = 0;//zera a fila de carros da faixa de cima da via 2
            this.fila2via2 = 0;//zera a fila de carros da faixa de cima da via 2
            mexerCarro2(true);
        }
        
        repaint();//atualiza a tela
    }
    
    public void mexerCarro1(boolean livre){//controla a movimentação do carro da via 1
        //a variavel "livre" diz se o carro poderá passar do semáforo ou não
        boolean incFila = false;//auxilia no incremento da fila
        if(!livre){
            if(posCarros1[0][1]>115 && ci1 == 1){
                cvi1.setLocation(posCarros1[0][0], posCarros1[0][1]); posCarros1[0][1]++;
            }else{
                if(posCarros1[0][1]<115-(fila1via1*65) && ci1 == 1){cvi1.setLocation(posCarros1[0][0], posCarros1[0][1]); posCarros1[0][1]++; incFila = true;}
                if(posCarros1[0][1] == 115-(fila1via1*65) && incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[1][1]>115 && ci2 == 1){
                {cvi2.setLocation(posCarros1[1][0], posCarros1[1][1]); posCarros1[1][1]++;}
            }else{
                if(posCarros1[1][1]<115-(fila1via1*65) && ci2 == 1){cvi2.setLocation(posCarros1[1][0], posCarros1[1][1]); posCarros1[1][1]++; incFila = true;}
                if(posCarros1[1][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[2][1]>115 && ci3 == 1){
                {cvi3.setLocation(posCarros1[2][0], posCarros1[2][1]); posCarros1[2][1]++;}
            }else{
                if(posCarros1[2][1]<115-(fila1via1*65) && ci3 == 1){cvi3.setLocation(posCarros1[2][0], posCarros1[2][1]); posCarros1[2][1]++; incFila = true;}
                if(posCarros1[2][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[3][1]>115 && ci4 == 1){
                {cvi4.setLocation(posCarros1[3][0], posCarros1[3][1]); posCarros1[3][1]++;}
            }else{
                if(posCarros1[3][1]<115-(fila1via1*65) && ci4 == 1){cvi4.setLocation(posCarros1[3][0], posCarros1[3][1]); posCarros1[3][1]++; incFila = true;}
                if(posCarros1[3][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[4][1]>115 && ci5 == 1){
                {cvi5.setLocation(posCarros1[4][0], posCarros1[4][1]); posCarros1[4][1]++;}
            }else{
                if(posCarros1[4][1]<115-(fila1via1*65) && ci5 == 1){cvi5.setLocation(posCarros1[4][0], posCarros1[4][1]); posCarros1[4][1]++; incFila = true;}
                if(posCarros1[4][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[5][1]>115 && ci6 == 1){
                {cvi6.setLocation(posCarros1[5][0], posCarros1[5][1]); posCarros1[5][1]++;}
            }else{
                if(posCarros1[5][1]<115-(fila1via1*65) && ci6 == 1){cvi6.setLocation(posCarros1[5][0], posCarros1[5][1]); posCarros1[5][1]++; incFila = true;}
                if(posCarros1[5][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[6][1]>115 && ci7 == 1){
                {cvi7.setLocation(posCarros1[6][0], posCarros1[6][1]); posCarros1[6][1]++;}
            }else{
                if(posCarros1[6][1]<115-(fila1via1*65) && ci7 == 1){cvi7.setLocation(posCarros1[6][0], posCarros1[6][1]); posCarros1[6][1]++; incFila = true;}
                if(posCarros1[6][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[7][1]>115 && ci8 == 1){
                {cvi8.setLocation(posCarros1[7][0], posCarros1[7][1]); posCarros1[7][1]++;}
            }else{
                if(posCarros1[7][1]<115-(fila1via1*65) && ci8 == 1){cvi8.setLocation(posCarros1[7][0], posCarros1[7][1]); posCarros1[7][1]++; incFila = true;}
                if(posCarros1[7][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[8][1]>115 && ci9 == 1){
                {cvi9.setLocation(posCarros1[8][0], posCarros1[8][1]); posCarros1[8][1]++;}
            }else{
                if(posCarros1[8][1]<115-(fila1via1*65) && ci9 == 1){cvi9.setLocation(posCarros1[8][0], posCarros1[8][1]); posCarros1[8][1]++; incFila = true;}
                if(posCarros1[8][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[9][1]>115 && ci10 == 1){
                {cvi10.setLocation(posCarros1[9][0], posCarros1[9][1]); posCarros1[9][1]++;}
            }else{
                if(posCarros1[9][1]<115-(fila1via1*65) && ci10 == 1){cvi10.setLocation(posCarros1[9][0], posCarros1[9][1]); posCarros1[9][1]++; incFila = true;}
                if(posCarros1[9][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[10][1]>115 && ci11 == 1){
                {cvi11.setLocation(posCarros1[10][0], posCarros1[10][1]); posCarros1[10][1]++;}
            }else{
                if(posCarros1[10][1]<115-(fila1via1*65) && ci11 == 1){cvi11.setLocation(posCarros1[10][0], posCarros1[10][1]); posCarros1[10][1]++; incFila = true;}
                if(posCarros1[10][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[11][1]>115 && ci12 == 1){
                {cvi12.setLocation(posCarros1[11][0], posCarros1[11][1]); posCarros1[11][1]++;}
            }else{
                if(posCarros1[11][1]<115-(fila1via1*65) && ci12 == 1){cvi12.setLocation(posCarros1[11][0], posCarros1[11][1]); posCarros1[11][1]++; incFila = true;}
                if(posCarros1[11][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[12][1]>115 && ci13 == 1){
                {cvi13.setLocation(posCarros1[12][0], posCarros1[12][1]); posCarros1[12][1]++;}
            }else{
                if(posCarros1[12][1]<115-(fila1via1*65) && ci13 == 1){cvi13.setLocation(posCarros1[12][0], posCarros1[12][1]); posCarros1[12][1]++; incFila = true;}
                if(posCarros1[12][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[13][1]>115 && ci14 == 1){
                {cvi14.setLocation(posCarros1[13][0], posCarros1[13][1]); posCarros1[13][1]++;}
            }else{
                if(posCarros1[13][1]<115-(fila1via1*65) && ci14 == 1){cvi14.setLocation(posCarros1[13][0], posCarros1[13][1]); posCarros1[13][1]++; incFila = true;}
                if(posCarros1[13][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[14][1]>115 && ci15 == 1){
                {cvi15.setLocation(posCarros1[14][0], posCarros1[14][1]); posCarros1[14][1]++;}
            }else{
                if(posCarros1[14][1]<115-(fila1via1*65) && ci15 == 1){cvi15.setLocation(posCarros1[14][0], posCarros1[14][1]); posCarros1[14][1]++; incFila = true;}
                if(posCarros1[14][1] == 115-(fila1via1*65)&& incFila){fila1via1++; incFila = false;}
            }
            if(posCarros1[15][1]>115 && ci16 == 1){
                {cvi16.setLocation(posCarros1[15][0], posCarros1[15][1]); posCarros1[15][1]++;}
            }else{
                if(posCarros1[15][1]<115-(fila2via1*65) && ci16 == 1){cvi16.setLocation(posCarros1[15][0], posCarros1[15][1]); posCarros1[15][1]++; incFila = true;}
                if(posCarros1[15][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[16][1]>115 && ci17 == 1){
                {cvi17.setLocation(posCarros1[16][0], posCarros1[16][1]); posCarros1[16][1]++;}
            }else{
                if(posCarros1[16][1]<115-(fila2via1*65) && ci17 == 1){cvi17.setLocation(posCarros1[16][0], posCarros1[16][1]); posCarros1[16][1]++; incFila = true;}
                if(posCarros1[16][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[17][1]>115 && ci18 == 1){
                {cvi18.setLocation(posCarros1[17][0], posCarros1[17][1]); posCarros1[17][1]++;}
            }else{
                if(posCarros1[17][1]<115-(fila2via1*65) && ci18 == 1){cvi18.setLocation(posCarros1[17][0], posCarros1[17][1]); posCarros1[17][1]++; incFila = true;}
                if(posCarros1[17][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[18][1]>115 && ci19 == 1){
                {cvi19.setLocation(posCarros1[18][0], posCarros1[18][1]); posCarros1[18][1]++;}
            }else{
                if(posCarros1[18][1]<115-(fila2via1*65) && ci19 == 1){cvi19.setLocation(posCarros1[18][0], posCarros1[18][1]); posCarros1[18][1]++; incFila = true;}
                if(posCarros1[18][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[19][1]>115 && ci20 == 1){
                {cvi20.setLocation(posCarros1[18][0], posCarros1[18][1]); posCarros1[19][1]++;}
            }else{
                if(posCarros1[19][1]<115-(fila2via1*65) && ci20 == 1){cvi20.setLocation(posCarros1[19][0], posCarros1[19][1]); posCarros1[19][1]++; incFila = true;}
                if(posCarros1[19][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[20][1]>115 && ci21 == 1){
                {cvi21.setLocation(posCarros1[20][0], posCarros1[20][1]); posCarros1[20][1]++;}
            }else{
                if(posCarros1[20][1]<115-(fila2via1*65) && ci21 == 1){cvi21.setLocation(posCarros1[20][0], posCarros1[20][1]); posCarros1[20][1]++; incFila = true;}
                if(posCarros1[20][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[21][1]>115 && ci22 == 1){
                {cvi22.setLocation(posCarros1[21][0], posCarros1[21][1]); posCarros1[21][1]++;}
            }else{
                if(posCarros1[21][1]<115-(fila2via1*65) && ci22 == 1){cvi22.setLocation(posCarros1[21][0], posCarros1[21][1]); posCarros1[21][1]++; incFila = true;}
                if(posCarros1[21][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[22][1]>115 && ci23 == 1){
                {cvi23.setLocation(posCarros1[22][0], posCarros1[22][1]); posCarros1[22][1]++;}
            }else{
                if(posCarros1[22][1]<115-(fila2via1*65) && ci23 == 1){cvi23.setLocation(posCarros1[22][0], posCarros1[22][1]); posCarros1[22][1]++; incFila = true;}
                if(posCarros1[22][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[23][1]>115 && ci24 == 1){
                {cvi24.setLocation(posCarros1[25][0], posCarros1[23][1]); posCarros1[23][1]++;}
            }else{
                if(posCarros1[23][1]<115-(fila2via1*65) && ci24 == 1){cvi24.setLocation(posCarros1[23][0], posCarros1[23][1]); posCarros1[23][1]++; incFila = true;}
                if(posCarros1[23][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[24][1]>115 && ci25 == 1){
                {cvi25.setLocation(posCarros1[24][0], posCarros1[24][1]); posCarros1[24][1]++;}
            }else{
                if(posCarros1[24][1]<115-(fila2via1*65) && ci25 == 1){cvi25.setLocation(posCarros1[24][0], posCarros1[24][1]); posCarros1[24][1]++; incFila = true;}
                if(posCarros1[24][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[25][1]>115 && ci26 == 1){
                {cvi26.setLocation(posCarros1[25][0], posCarros1[25][1]); posCarros1[25][1]++;}
            }else{
                if(posCarros1[25][1]<115-(fila2via1*65) && ci26 == 1){cvi26.setLocation(posCarros1[25][0], posCarros1[25][1]); posCarros1[25][1]++; incFila = true;}
                if(posCarros1[25][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[26][1]>115 && ci27 == 1){
                {cvi27.setLocation(posCarros1[26][0], posCarros1[17][1]); posCarros1[26][1]++;}
            }else{
                if(posCarros1[26][1]<115-(fila2via1*65) && ci27 == 1){cvi27.setLocation(posCarros1[26][0], posCarros1[26][1]); posCarros1[26][1]++; incFila = true;}
                if(posCarros1[26][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[27][1]>115 && ci28 == 1){
                {cvi28.setLocation(posCarros1[27][0], posCarros1[27][1]); posCarros1[27][1]++;}
            }else{
                if(posCarros1[27][1]<115-(fila2via1*65) && ci28 == 1){cvi28.setLocation(posCarros1[27][0], posCarros1[27][1]); posCarros1[27][1]++; incFila = true;}
                if(posCarros1[27][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[28][1]>115 && ci29 == 1){
                {cvi29.setLocation(posCarros1[28][0], posCarros1[28][1]); posCarros1[28][1]++;}
            }else{
                if(posCarros1[28][1]<115-(fila2via1*65) && ci29 == 1){cvi29.setLocation(posCarros1[28][0], posCarros1[28][1]); posCarros1[28][1]++; incFila = true;}
                if(posCarros1[28][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
            if(posCarros1[29][1]>115 && ci30 == 1){
                {cvi30.setLocation(posCarros1[29][0], posCarros1[29][1]); posCarros1[29][1]++;}
            }else{
                if(posCarros1[29][1]<115-(fila2via1*65) && ci30 == 1){cvi30.setLocation(posCarros1[29][0], posCarros1[29][1]); posCarros1[29][1]++; incFila = true;}
                if(posCarros1[29][1] == 115-(fila2via1*65)&& incFila){fila2via1++; incFila = false;}
            }
        }else{
            if(ci1 == 1){cvi1.setLocation(posCarros1[0][0], posCarros1[0][1]); posCarros1[0][1]++;}
            if(ci2 == 1){cvi2.setLocation(posCarros1[1][0], posCarros1[1][1]); posCarros1[1][1]++;}
            if(ci3 == 1){cvi3.setLocation(posCarros1[2][0], posCarros1[2][1]); posCarros1[2][1]++;}
            if(ci4 == 1){cvi4.setLocation(posCarros1[3][0], posCarros1[3][1]); posCarros1[3][1]++;}
            if(ci5 == 1){cvi5.setLocation(posCarros1[4][0], posCarros1[4][1]); posCarros1[4][1]++;}
            if(ci6 == 1){cvi6.setLocation(posCarros1[5][0], posCarros1[5][1]); posCarros1[5][1]++;}
            if(ci7 == 1){cvi7.setLocation(posCarros1[6][0], posCarros1[6][1]); posCarros1[6][1]++;}
            if(ci8 == 1){cvi8.setLocation(posCarros1[7][0], posCarros1[7][1]); posCarros1[7][1]++;}
            if(ci9 == 1){cvi9.setLocation(posCarros1[8][0], posCarros1[8][1]); posCarros1[8][1]++;}
            if(ci10 == 1){cvi10.setLocation(posCarros1[9][0], posCarros1[9][1]); posCarros1[9][1]++;}
            if(ci11 == 1){cvi11.setLocation(posCarros1[10][0], posCarros1[10][1]); posCarros1[10][1]++;}
            if(ci12 == 1){cvi12.setLocation(posCarros1[11][0], posCarros1[11][1]); posCarros1[11][1]++;}
            if(ci13 == 1){cvi13.setLocation(posCarros1[12][0], posCarros1[12][1]); posCarros1[12][1]++;}
            if(ci14 == 1){cvi14.setLocation(posCarros1[12][0], posCarros1[13][1]); posCarros1[13][1]++;}
            if(ci15 == 1){cvi15.setLocation(posCarros1[14][0], posCarros1[14][1]); posCarros1[14][1]++;}
            if(ci16 == 1){cvi16.setLocation(posCarros1[15][0], posCarros1[15][1]); posCarros1[15][1]++;}
            if(ci17 == 1){cvi17.setLocation(posCarros1[16][0], posCarros1[16][1]); posCarros1[16][1]++;}
            if(ci18 == 1){cvi18.setLocation(posCarros1[17][0], posCarros1[17][1]); posCarros1[17][1]++;}
            if(ci19 == 1){cvi19.setLocation(posCarros1[18][0], posCarros1[18][1]); posCarros1[18][1]++;}
            if(ci20 == 1){cvi20.setLocation(posCarros1[19][0], posCarros1[19][1]); posCarros1[19][1]++;}
            if(ci21 == 1){cvi21.setLocation(posCarros1[20][0], posCarros1[20][1]); posCarros1[20][1]++;}
            if(ci22 == 1){cvi22.setLocation(posCarros1[21][0], posCarros1[21][1]); posCarros1[21][1]++;}
            if(ci23 == 1){cvi23.setLocation(posCarros1[22][0], posCarros1[22][1]); posCarros1[22][1]++;}
            if(ci24 == 1){cvi24.setLocation(posCarros1[23][0], posCarros1[23][1]); posCarros1[23][1]++;}
            if(ci25 == 1){cvi25.setLocation(posCarros1[24][0], posCarros1[24][1]); posCarros1[24][1]++;}
            if(ci26 == 1){cvi26.setLocation(posCarros1[25][0], posCarros1[25][1]); posCarros1[25][1]++;}
            if(ci27 == 1){cvi27.setLocation(posCarros1[26][0], posCarros1[26][1]); posCarros1[26][1]++;}
            if(ci28 == 1){cvi28.setLocation(posCarros1[27][0], posCarros1[27][1]); posCarros1[27][1]++;}
            if(ci29 == 1){cvi29.setLocation(posCarros1[28][0], posCarros1[28][1]); posCarros1[28][1]++;}
            if(ci30 == 1){cvi30.setLocation(posCarros1[29][0], posCarros1[29][1]); posCarros1[29][1]++;}
        }
    }//controla a movimentação do carro da via 1
    
    public void mexerCarro2(boolean livre){//controla a movimentação do carro da via 2
        //a variavel "livre" diz se o carro poderá passar do semáforo ou não
        boolean incFila = false;//auxilia no incremento da fila
        if(!livre){
            if(posCarros2[0][0]<540 && c1 == 1){
                cv1.setLocation(posCarros2[0][0], posCarros2[0][1]); posCarros2[0][0]--;
            }else{
                if(posCarros2[0][0]>540+(fila1via2*65) && c1 == 1){cv1.setLocation(posCarros2[0][0], posCarros2[0][1]); posCarros2[0][0]--; incFila = true;}
                if(posCarros2[0][0] == 540+(fila1via2*65) && incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[1][0]<540 && c2 == 1){
                {cv2.setLocation(posCarros2[1][0], posCarros2[1][1]); posCarros2[1][0]--;}
            }else{
                if(posCarros2[1][0]>540+(fila1via2*65) && c2 == 1){cv2.setLocation(posCarros2[1][0], posCarros2[1][1]); posCarros2[1][0]--; incFila = true;}
                if(posCarros2[1][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[2][0]<540 && c3 == 1){
                {cv3.setLocation(posCarros2[2][0], posCarros2[2][1]); posCarros2[2][0]--;}
            }else{
                if(posCarros2[2][0]>540+(fila1via2*65) && c3 == 1){cv3.setLocation(posCarros2[2][0], posCarros2[2][1]); posCarros2[2][0]--; incFila = true;}
                if(posCarros2[2][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[3][0]<540 && c4 == 1){
                {cv4.setLocation(posCarros2[3][0], posCarros2[3][1]); posCarros2[3][0]--;}
            }else{
                if(posCarros2[3][0]>540+(fila1via2*65) && c4 == 1){cv4.setLocation(posCarros2[3][0], posCarros2[3][1]); posCarros2[3][0]--; incFila = true;}
                if(posCarros2[3][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[4][0]<540 && c5 == 1){
                {cv5.setLocation(posCarros2[4][0], posCarros2[4][1]); posCarros2[4][0]--;}
            }else{
                if(posCarros2[4][0]>540+(fila1via2*65) && c5 == 1){cv5.setLocation(posCarros2[4][0], posCarros2[4][1]); posCarros2[4][0]--; incFila = true;}
                if(posCarros2[4][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[5][0]<540 && c6 == 1){
                {cv6.setLocation(posCarros2[5][0], posCarros2[5][1]); posCarros2[5][0]--;}
            }else{
                if(posCarros2[5][0]>540+(fila1via2*65) && c6 == 1){cv6.setLocation(posCarros2[5][0], posCarros2[5][1]); posCarros2[5][0]--; incFila = true;}
                if(posCarros2[5][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[6][0]<540 && c7 == 1){
                {cv7.setLocation(posCarros2[6][0], posCarros2[6][1]); posCarros2[6][0]--;}
            }else{
                if(posCarros2[6][0]>540+(fila1via2*65) && c7 == 1){cv7.setLocation(posCarros2[6][0], posCarros2[6][1]); posCarros2[6][0]--; incFila = true;}
                if(posCarros2[6][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[7][0]<540 && c8 == 1){
                {cv8.setLocation(posCarros2[7][0], posCarros2[7][1]); posCarros2[7][0]--;}
            }else{
                if(posCarros2[7][0]>540+(fila1via2*65) && c8 == 1){cv8.setLocation(posCarros2[7][0], posCarros2[7][1]); posCarros2[7][0]--; incFila = true;}
                if(posCarros2[7][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[8][0]<540 && c9 == 1){
                {cv9.setLocation(posCarros2[8][0], posCarros2[8][1]); posCarros2[8][0]--;}
            }else{
                if(posCarros2[8][0]>540+(fila1via2*65) && c9 == 1){cv9.setLocation(posCarros2[8][0], posCarros2[8][1]); posCarros2[8][0]--; incFila = true;}
                if(posCarros2[8][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[9][0]<540 && c10 == 1){
                {cv10.setLocation(posCarros2[9][0], posCarros2[9][1]); posCarros2[9][0]--;}
            }else{
                if(posCarros2[9][0]>540+(fila1via2*65) && c10 == 1){cv10.setLocation(posCarros2[9][0], posCarros2[9][1]); posCarros2[9][0]--; incFila = true;}
                if(posCarros2[9][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[10][0]<540 && c11 == 1){
                {cv11.setLocation(posCarros2[11][0], posCarros2[10][1]); posCarros2[10][0]--;}
            }else{
                if(posCarros2[10][0]>540+(fila1via2*65) && c11 == 1){cv11.setLocation(posCarros2[10][0], posCarros2[10][1]); posCarros2[10][0]--; incFila = true;}
                if(posCarros2[10][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[11][0]<540 && c12 == 1){
                {cv12.setLocation(posCarros2[11][0], posCarros2[11][1]); posCarros2[11][0]--;}
            }else{
                if(posCarros2[11][0]>540+(fila1via2*65) && c12 == 1){cv12.setLocation(posCarros2[11][0], posCarros2[11][1]); posCarros2[11][0]--; incFila = true;}
                if(posCarros2[11][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[12][0]<540 && c13 == 1){
                {cv13.setLocation(posCarros2[12][0], posCarros2[12][1]); posCarros2[12][0]--;}
            }else{
                if(posCarros2[12][0]>540+(fila1via2*65) && c13 == 1){cv13.setLocation(posCarros2[12][0], posCarros2[12][1]); posCarros2[12][0]--; incFila = true;}
                if(posCarros2[12][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[13][0]<540 && c14 == 1){
                {cv14.setLocation(posCarros2[13][0], posCarros2[13][1]); posCarros2[13][0]--;}
            }else{
                if(posCarros2[13][0]>540+(fila1via2*65) && c14 == 1){cv14.setLocation(posCarros2[13][0], posCarros2[13][1]); posCarros2[13][0]--; incFila = true;}
                if(posCarros2[13][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[14][0]<540 && c15 == 1){
                {cv15.setLocation(posCarros2[14][0], posCarros2[14][1]); posCarros2[14][0]--;}
            }else{
                if(posCarros2[14][0]>540+(fila1via2*65) && c15 == 1){cv15.setLocation(posCarros2[14][0], posCarros2[14][1]); posCarros2[14][0]--; incFila = true;}
                if(posCarros2[14][0] == 540+(fila1via2*65)&& incFila){fila1via2++; incFila = false;}
            }
            if(posCarros2[15][0]<540 && c16 == 1){
                {cv16.setLocation(posCarros2[15][0], posCarros2[15][1]); posCarros2[15][0]--;}
            }else{
                if(posCarros2[15][0]>540+(fila2via2*65) && c16 == 1){cv16.setLocation(posCarros2[15][0], posCarros2[15][1]); posCarros2[15][0]--; incFila = true;}
                if(posCarros2[15][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[16][0]<540 && c17 == 1){
                {cv17.setLocation(posCarros2[16][0], posCarros2[16][1]); posCarros2[16][0]--;}
            }else{
                if(posCarros2[16][0]>540+(fila2via2*65) && c17 == 1){cv17.setLocation(posCarros2[16][0], posCarros2[16][1]); posCarros2[16][0]--; incFila = true;}
                if(posCarros2[16][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[17][0]<540 && c18 == 1){
                {cv18.setLocation(posCarros2[17][0], posCarros2[17][1]); posCarros2[17][0]--;}
            }else{
                if(posCarros2[17][0]>540+(fila2via2*65) && c18 == 1){cv18.setLocation(posCarros2[17][0], posCarros2[17][1]); posCarros2[17][0]--; incFila = true;}
                if(posCarros2[17][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[18][0]<540 && c19 == 1){
                {cv19.setLocation(posCarros2[18][0], posCarros2[18][1]); posCarros2[18][0]--;}
            }else{
                if(posCarros2[18][0]>540+(fila2via2*65) && c19 == 1){cv19.setLocation(posCarros2[18][0], posCarros2[18][1]); posCarros2[18][0]--; incFila = true;}
                if(posCarros2[18][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[19][0]<540 && c20 == 1){
                {cv20.setLocation(posCarros2[18][0], posCarros2[18][1]); posCarros2[18][0]--;}
            }else{
                if(posCarros2[19][0]>540+(fila2via2*65) && c20 == 1){cv20.setLocation(posCarros2[19][0], posCarros2[19][1]); posCarros2[19][0]--; incFila = true;}
                if(posCarros2[19][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[20][0]<540 && c21 == 1){
                {cv21.setLocation(posCarros2[20][0], posCarros2[20][1]); posCarros2[20][0]--;}
            }else{
                if(posCarros2[20][0]>540+(fila2via2*65) && c21 == 1){cv21.setLocation(posCarros2[20][0], posCarros2[20][1]); posCarros2[20][0]--; incFila = true;}
                if(posCarros2[20][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[21][0]<540 && c22 == 1){
                {cv22.setLocation(posCarros2[21][0], posCarros2[21][1]); posCarros2[21][0]--;}
            }else{
                if(posCarros2[21][0]>540+(fila2via2*65) && c22 == 1){cv22.setLocation(posCarros2[21][0], posCarros2[21][1]); posCarros2[21][0]--; incFila = true;}
                if(posCarros2[21][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[22][0]<540 && c23 == 1){
                {cv23.setLocation(posCarros2[22][0], posCarros2[22][1]); posCarros2[22][0]--;}
            }else{
                if(posCarros2[22][0]>540+(fila2via2*65) && c23 == 1){cv23.setLocation(posCarros2[22][0], posCarros2[22][1]); posCarros2[22][0]--; incFila = true;}
                if(posCarros2[22][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[23][0]<540 && c24 == 1){
                {cv24.setLocation(posCarros2[25][0], posCarros2[23][1]); posCarros2[23][0]--;}
            }else{
                if(posCarros2[23][0]>540+(fila2via2*65) && c24 == 1){cv24.setLocation(posCarros2[23][0], posCarros2[23][1]); posCarros2[23][0]--; incFila = true;}
                if(posCarros2[23][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[24][0]<540 && c25 == 1){
                {cv25.setLocation(posCarros2[24][0], posCarros2[24][1]); posCarros2[24][0]--;}
            }else{
                if(posCarros2[24][0]>540+(fila2via2*65) && c25 == 1){cv25.setLocation(posCarros2[24][0], posCarros2[24][1]); posCarros2[24][0]--; incFila = true;}
                if(posCarros2[24][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[25][0]<540 && c26 == 1){
                {cv26.setLocation(posCarros2[25][0], posCarros2[25][1]); posCarros2[25][0]--;}
            }else{
                if(posCarros2[25][0]>540+(fila2via2*65) && c26 == 1){cv26.setLocation(posCarros2[25][0], posCarros2[25][1]); posCarros2[25][0]--; incFila = true;}
                if(posCarros2[25][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[26][0]<540 && c27 == 1){
                {cv27.setLocation(posCarros2[26][0], posCarros2[17][1]); posCarros2[26][0]--;}
            }else{
                if(posCarros2[26][0]>540+(fila2via2*65) && c27 == 1){cv27.setLocation(posCarros2[26][0], posCarros2[26][1]); posCarros2[26][0]--; incFila = true;}
                if(posCarros2[26][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[27][0]<540 && c28 == 1){
                {cv28.setLocation(posCarros2[27][0], posCarros2[27][1]); posCarros2[27][0]--;}
            }else{
                if(posCarros2[27][0]>540+(fila2via2*65) && c28 == 1){cv28.setLocation(posCarros2[27][0], posCarros2[27][1]); posCarros2[27][0]--; incFila = true;}
                if(posCarros2[27][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[28][0]<540 && c29 == 1){
                {cv29.setLocation(posCarros2[28][0], posCarros2[28][1]); posCarros2[28][0]--;}
            }else{
                if(posCarros2[28][0]>540+(fila2via2*65) && c29 == 1){cv29.setLocation(posCarros2[28][0], posCarros2[28][1]); posCarros2[28][0]--; incFila = true;}
                if(posCarros2[28][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
            if(posCarros2[29][0]<540 && c30 == 1){
                {cv30.setLocation(posCarros2[29][0], posCarros2[29][1]); posCarros2[29][0]--;}
            }else{
                if(posCarros2[29][0]>540+(fila2via2*65) && c30 == 1){cv30.setLocation(posCarros2[29][0], posCarros2[29][1]); posCarros2[29][0]--; incFila = true;}
                if(posCarros2[29][0] == 540+(fila2via2*65)&& incFila){fila2via2++; incFila = false;}
            }
        }else{
            if(c1 == 1){cv1.setLocation(posCarros2[0][0], posCarros2[0][1]); posCarros2[0][0]--;}
            if(c2 == 1){cv2.setLocation(posCarros2[1][0], posCarros2[1][1]); posCarros2[1][0]--;}
            if(c3 == 1){cv3.setLocation(posCarros2[2][0], posCarros2[2][1]); posCarros2[2][0]--;}
            if(c4 == 1){cv4.setLocation(posCarros2[3][0], posCarros2[3][1]); posCarros2[3][0]--;}
            if(c5 == 1){cv5.setLocation(posCarros2[4][0], posCarros2[4][1]); posCarros2[4][0]--;}
            if(c6 == 1){cv6.setLocation(posCarros2[5][0], posCarros2[5][1]); posCarros2[5][0]--;}
            if(c7 == 1){cv7.setLocation(posCarros2[6][0], posCarros2[6][1]); posCarros2[6][0]--;}
            if(c8 == 1){cv8.setLocation(posCarros2[7][0], posCarros2[7][1]); posCarros2[7][0]--;}
            if(c9 == 1){cv9.setLocation(posCarros2[8][0], posCarros2[8][1]); posCarros2[8][0]--;}
            if(c10 == 1){cv10.setLocation(posCarros2[9][0], posCarros2[9][1]); posCarros2[9][0]--;}
            if(c11 == 1){cv11.setLocation(posCarros2[10][0], posCarros2[10][1]); posCarros2[10][0]--;}
            if(c12 == 1){cv12.setLocation(posCarros2[11][0], posCarros2[11][1]); posCarros2[11][0]--;}
            if(c13 == 1){cv13.setLocation(posCarros2[12][0], posCarros2[12][1]); posCarros2[12][0]--;}
            if(c14 == 1){cv14.setLocation(posCarros2[12][0], posCarros2[13][1]); posCarros2[13][0]--;}
            if(c15 == 1){cv15.setLocation(posCarros2[14][0], posCarros2[14][1]); posCarros2[14][0]--;}
            if(c16 == 1){cv16.setLocation(posCarros2[15][0], posCarros2[15][1]); posCarros2[15][0]--;}
            if(c17 == 1){cv17.setLocation(posCarros2[16][0], posCarros2[16][1]); posCarros2[16][0]--;}
            if(c18 == 1){cv18.setLocation(posCarros2[17][0], posCarros2[17][1]); posCarros2[17][0]--;}
            if(c19 == 1){cv19.setLocation(posCarros2[18][0], posCarros2[18][1]); posCarros2[18][0]--;}
            if(c20 == 1){cv20.setLocation(posCarros2[19][0], posCarros2[19][1]); posCarros2[19][0]--;}
            if(c21 == 1){cv21.setLocation(posCarros2[20][0], posCarros2[20][1]); posCarros2[20][0]--;}
            if(c22 == 1){cv22.setLocation(posCarros2[21][0], posCarros2[21][1]); posCarros2[21][0]--;}
            if(c23 == 1){cv23.setLocation(posCarros2[22][0], posCarros2[22][1]); posCarros2[22][0]--;}
            if(c24 == 1){cv24.setLocation(posCarros2[23][0], posCarros2[23][1]); posCarros2[23][0]--;}
            if(c25 == 1){cv25.setLocation(posCarros2[24][0], posCarros2[24][1]); posCarros2[24][0]--;}
            if(c26 == 1){cv26.setLocation(posCarros2[25][0], posCarros2[25][1]); posCarros2[25][0]--;}
            if(c27 == 1){cv27.setLocation(posCarros2[26][0], posCarros2[26][1]); posCarros2[26][0]--;}
            if(c28 == 1){cv28.setLocation(posCarros2[27][0], posCarros2[27][1]); posCarros2[27][0]--;}
            if(c29 == 1){cv29.setLocation(posCarros2[28][0], posCarros2[28][1]); posCarros2[28][0]--;}
            if(c30 == 1){cv30.setLocation(posCarros2[29][0], posCarros2[29][1]); posCarros2[29][0]--;}
        }
    }//controla a movimentação do carro da via 2
    
    public void escolherCarro1(){
        int op = rd.nextInt(100);//atruibui um numero aleatorio de 0 a 99
        
        //se não houver mais labels de uma faixa para escolher, será solicitado um label de outra faixa
        if(aux1v1>=15) if(op < 50) op = 75;
        if(aux2v1>=30) if(op >= 50) op = 25;
        
        if(op < 50 && fila1via1 < 3){//terá 50% de chance de escolher um carro de uma faixa
            if(aux1v1 == 0) this.ci1 = 1;
            if(aux1v1 == 1) this.ci2 = 1;
            if(aux1v1 == 2) this.ci3 = 1;
            if(aux1v1 == 3) this.ci4 = 1;
            if(aux1v1 == 4) this.ci5 = 1;
            if(aux1v1 == 5) this.ci6 = 1;
            if(aux1v1 == 6) this.ci7 = 1;
            if(aux1v1 == 7) this.ci8 = 1;
            if(aux1v1 == 8) this.ci9 = 1;
            if(aux1v1 == 9) this.ci10 = 1;
            if(aux1v1 == 10) this.ci11 = 1;
            if(aux1v1 == 11) this.ci12 = 1;
            if(aux1v1 == 12) this.ci13 = 1;
            if(aux1v1 == 13) this.ci14 = 1;
            if(aux1v1 == 14) this.ci15 = 1;
            totalcarros1++;
            aux1v1++;
        }
        if(op >= 50 && fila2via1 < 3){//terá 50% de chance de escolher um carro de outra faixa
            if(aux2v1 == 15) this.ci16 = 1;
            if(aux2v1 == 16) this.ci17 = 1;
            if(aux2v1 == 17) this.ci18 = 1;
            if(aux2v1 == 18) this.ci19 = 1;
            if(aux2v1 == 19) this.ci20 = 1;
            if(aux2v1 == 20) this.ci21 = 1;
            if(aux2v1 == 21) this.ci22 = 1;
            if(aux2v1 == 22) this.ci23 = 1;
            if(aux2v1 == 23) this.ci24 = 1;
            if(aux2v1 == 24) this.ci25 = 1;
            if(aux2v1 == 25) this.ci26 = 1;
            if(aux2v1 == 26) this.ci27 = 1;
            if(aux2v1 == 27) this.ci28 = 1;
            if(aux2v1 == 28) this.ci29 = 1;
            if(aux2v1 == 29) this.ci30 = 1;
            totalcarros1++;
            aux2v1++;
        }
    }

    public void escolherCarro2(){
        int op = rd.nextInt(100);//atruibui um numero aleatorio de 0 a 99
        
        //se não houver mais labels de uma faixa para escolher, será solicitado um label de outra faixa
        if(aux1v2>=15) if(op < 50) op = 75;
        if(aux2v2>=30) if(op >= 50) op = 25;
        
        if(op < 50 && fila1via2 < 4){
            if(aux1v2 == 0) this.c1 = 1;
            if(aux1v2 == 1) this.c2 = 1;
            if(aux1v2 == 2) this.c3 = 1;
            if(aux1v2 == 3) this.c4 = 1;
            if(aux1v2 == 4) this.c5 = 1;
            if(aux1v2 == 5) this.c6 = 1;
            if(aux1v2 == 6) this.c7 = 1;
            if(aux1v2 == 7) this.c8 = 1;
            if(aux1v2 == 8) this.c9 = 1;
            if(aux1v2 == 9) this.c10 = 1;
            if(aux1v2 == 10) this.c11 = 1;
            if(aux1v2 == 11) this.c12 = 1;
            if(aux1v2 == 12) this.c13 = 1;
            if(aux1v2 == 13) this.c14 = 1;
            if(aux1v2 == 14) this.c15 = 1;
            jaescolheuf1v2 = true;
            totalcarros2++;
            aux1v2++;
        }
        if(op >= 50 && fila2via2 < 4){
            if(aux2v2 == 15) this.c16 = 1;
            if(aux2v2 == 16) this.c17 = 1;
            if(aux2v2 == 17) this.c18 = 1;
            if(aux2v2 == 18) this.c19 = 1;
            if(aux2v2 == 19) this.c20 = 1;
            if(aux2v2 == 20) this.c21 = 1;
            if(aux2v2 == 21) this.c22 = 1;
            if(aux2v2 == 22) this.c23 = 1;
            if(aux2v2 == 23) this.c24 = 1;
            if(aux2v2 == 24) this.c25 = 1;
            if(aux2v2 == 25) this.c26 = 1;
            if(aux2v2 == 26) this.c27 = 1;
            if(aux2v2 == 27) this.c28 = 1;
            if(aux2v2 == 28) this.c29 = 1;
            if(aux2v2 == 29) this.c30 = 1;
            jaescolheuf2v2 = true;
            totalcarros2++;
            aux2v2++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fluxo1 = new javax.swing.JLabel();
        fluxo2 = new javax.swing.JLabel();
        tv1 = new javax.swing.JLabel();
        tv2 = new javax.swing.JLabel();
        via2 = new javax.swing.JLabel();
        via3 = new javax.swing.JLabel();
        sobre = new javax.swing.JButton();
        iniciando = new javax.swing.JLabel();
        sem1ii = new javax.swing.JLabel();
        sem1i = new javax.swing.JLabel();
        sem2i = new javax.swing.JLabel();
        sem2ii = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        cc = new javax.swing.JLabel();
        cv1 = new javax.swing.JLabel();
        cv2 = new javax.swing.JLabel();
        cv3 = new javax.swing.JLabel();
        cv4 = new javax.swing.JLabel();
        cv5 = new javax.swing.JLabel();
        cv6 = new javax.swing.JLabel();
        cv7 = new javax.swing.JLabel();
        cv8 = new javax.swing.JLabel();
        cv9 = new javax.swing.JLabel();
        cv10 = new javax.swing.JLabel();
        cv11 = new javax.swing.JLabel();
        cv12 = new javax.swing.JLabel();
        cv13 = new javax.swing.JLabel();
        cv14 = new javax.swing.JLabel();
        cv15 = new javax.swing.JLabel();
        cv16 = new javax.swing.JLabel();
        cv17 = new javax.swing.JLabel();
        cv18 = new javax.swing.JLabel();
        cv19 = new javax.swing.JLabel();
        cv20 = new javax.swing.JLabel();
        cv21 = new javax.swing.JLabel();
        cv22 = new javax.swing.JLabel();
        cv23 = new javax.swing.JLabel();
        cv24 = new javax.swing.JLabel();
        cv25 = new javax.swing.JLabel();
        cv26 = new javax.swing.JLabel();
        cv27 = new javax.swing.JLabel();
        cv28 = new javax.swing.JLabel();
        cv29 = new javax.swing.JLabel();
        cv30 = new javax.swing.JLabel();
        cvi1 = new javax.swing.JLabel();
        cvi2 = new javax.swing.JLabel();
        cvi3 = new javax.swing.JLabel();
        cvi4 = new javax.swing.JLabel();
        cvi5 = new javax.swing.JLabel();
        cvi6 = new javax.swing.JLabel();
        cvi7 = new javax.swing.JLabel();
        cvi8 = new javax.swing.JLabel();
        cvi9 = new javax.swing.JLabel();
        cvi10 = new javax.swing.JLabel();
        cvi11 = new javax.swing.JLabel();
        cvi12 = new javax.swing.JLabel();
        cvi13 = new javax.swing.JLabel();
        cvi14 = new javax.swing.JLabel();
        cvi15 = new javax.swing.JLabel();
        cvi16 = new javax.swing.JLabel();
        cvi17 = new javax.swing.JLabel();
        cvi18 = new javax.swing.JLabel();
        cvi19 = new javax.swing.JLabel();
        cvi20 = new javax.swing.JLabel();
        cvi21 = new javax.swing.JLabel();
        cvi22 = new javax.swing.JLabel();
        cvi23 = new javax.swing.JLabel();
        cvi24 = new javax.swing.JLabel();
        cvi25 = new javax.swing.JLabel();
        cvi26 = new javax.swing.JLabel();
        cvi27 = new javax.swing.JLabel();
        cvi28 = new javax.swing.JLabel();
        cvi29 = new javax.swing.JLabel();
        cvi30 = new javax.swing.JLabel();
        btEstatisticas = new javax.swing.JButton();
        mediavia1 = new javax.swing.JLabel();
        mediavia2 = new javax.swing.JLabel();
        ciclosemaforo = new javax.swing.JLabel();
        lbtotal1 = new javax.swing.JLabel();
        lbtotal2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Semáforo - JADE FRAMEWORK");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 650));
        getContentPane().setLayout(null);

        fluxo1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fluxo1.setForeground(new java.awt.Color(255, 255, 255));
        fluxo1.setText("Fluxo via 1: 0 Carros/Minuto");
        getContentPane().add(fluxo1);
        fluxo1.setBounds(10, 100, 180, 20);

        fluxo2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        fluxo2.setForeground(new java.awt.Color(255, 255, 255));
        fluxo2.setText("Fluxo via 2: 0 Carros/Minuto");
        getContentPane().add(fluxo2);
        fluxo2.setBounds(10, 120, 200, 15);

        tv1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tv1.setForeground(new java.awt.Color(255, 255, 255));
        tv1.setText("Tempo que a via 1 ficará aberta: 0");
        getContentPane().add(tv1);
        tv1.setBounds(10, 20, 240, 15);

        tv2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tv2.setForeground(new java.awt.Color(255, 255, 255));
        tv2.setText("Tempo que a via 2 ficará aberta: 0");
        getContentPane().add(tv2);
        tv2.setBounds(10, 40, 240, 15);

        via2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        via2.setForeground(new java.awt.Color(255, 255, 255));
        via2.setText("Via 1");
        getContentPane().add(via2);
        via2.setBounds(440, 10, 40, 20);

        via3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        via3.setForeground(new java.awt.Color(255, 255, 255));
        via3.setText("Via 2");
        getContentPane().add(via3);
        via3.setBounds(730, 340, 40, 20);

        sobre.setText("Sobre");
        sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobreActionPerformed(evt);
            }
        });
        getContentPane().add(sobre);
        sobre.setBounds(10, 530, 200, 23);

        iniciando.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        iniciando.setText("Iniciando...");
        getContentPane().add(iniciando);
        iniciando.setBounds(350, 280, 110, 30);

        sem1ii.setForeground(new java.awt.Color(255, 255, 255));
        sem1ii.setText("semaforo");
        getContentPane().add(sem1ii);
        sem1ii.setBounds(430, 120, 48, 48);

        sem1i.setForeground(new java.awt.Color(255, 255, 255));
        sem1i.setText("semaforo");
        getContentPane().add(sem1i);
        sem1i.setBounds(320, 120, 48, 48);

        sem2i.setForeground(new java.awt.Color(255, 255, 255));
        sem2i.setText("semaforo");
        getContentPane().add(sem2i);
        sem2i.setBounds(530, 230, 48, 48);

        sem2ii.setForeground(new java.awt.Color(255, 255, 255));
        sem2ii.setText("semaforo");
        getContentPane().add(sem2ii);
        sem2ii.setBounds(530, 330, 48, 48);

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setIcon(new javax.swing.ImageIcon("C:\\Users\\MarcoAntônio\\Documents\\NetBeansProjects\\iaSemaforoJADE\\src\\imagens\\relogio.png")); // NOI18N
        time.setText("10s");
        time.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(time);
        time.setBounds(640, 40, 100, 50);
        getContentPane().add(cc);
        cc.setBounds(560, 400, 50, 30);
        getContentPane().add(cv1);
        cv1.setBounds(720, 110, 55, 25);
        getContentPane().add(cv2);
        cv2.setBounds(700, 120, 55, 25);
        getContentPane().add(cv3);
        cv3.setBounds(710, 110, 55, 25);
        getContentPane().add(cv4);
        cv4.setBounds(730, 120, 55, 25);
        getContentPane().add(cv5);
        cv5.setBounds(710, 140, 55, 25);
        getContentPane().add(cv6);
        cv6.setBounds(710, 130, 55, 25);
        getContentPane().add(cv7);
        cv7.setBounds(740, 120, 55, 25);
        getContentPane().add(cv8);
        cv8.setBounds(730, 130, 55, 25);
        getContentPane().add(cv9);
        cv9.setBounds(730, 120, 55, 25);
        getContentPane().add(cv10);
        cv10.setBounds(740, 120, 55, 25);
        getContentPane().add(cv11);
        cv11.setBounds(710, 100, 55, 25);
        getContentPane().add(cv12);
        cv12.setBounds(740, 100, 55, 25);
        getContentPane().add(cv13);
        cv13.setBounds(710, 100, 55, 25);
        getContentPane().add(cv14);
        cv14.setBounds(710, 110, 55, 25);
        getContentPane().add(cv15);
        cv15.setBounds(720, 110, 55, 25);
        getContentPane().add(cv16);
        cv16.setBounds(750, 110, 55, 25);
        getContentPane().add(cv17);
        cv17.setBounds(720, 110, 55, 25);
        getContentPane().add(cv18);
        cv18.setBounds(730, 100, 55, 25);
        getContentPane().add(cv19);
        cv19.setBounds(720, 100, 55, 25);
        getContentPane().add(cv20);
        cv20.setBounds(720, 90, 55, 25);
        getContentPane().add(cv21);
        cv21.setBounds(720, 90, 55, 25);
        getContentPane().add(cv22);
        cv22.setBounds(740, 90, 55, 25);
        getContentPane().add(cv23);
        cv23.setBounds(740, 100, 55, 25);
        getContentPane().add(cv24);
        cv24.setBounds(730, 90, 55, 25);
        getContentPane().add(cv25);
        cv25.setBounds(710, 90, 55, 25);
        getContentPane().add(cv26);
        cv26.setBounds(730, 100, 55, 25);
        getContentPane().add(cv27);
        cv27.setBounds(730, 90, 55, 25);
        getContentPane().add(cv28);
        cv28.setBounds(730, 90, 55, 25);
        getContentPane().add(cv29);
        cv29.setBounds(730, 100, 55, 25);
        getContentPane().add(cv30);
        cv30.setBounds(730, 100, 55, 25);
        getContentPane().add(cvi1);
        cvi1.setBounds(60, 170, 55, 25);
        getContentPane().add(cvi2);
        cvi2.setBounds(120, 140, 55, 25);
        getContentPane().add(cvi3);
        cvi3.setBounds(70, 90, 55, 25);
        getContentPane().add(cvi4);
        cvi4.setBounds(50, 160, 55, 25);
        getContentPane().add(cvi5);
        cvi5.setBounds(30, 170, 55, 25);
        getContentPane().add(cvi6);
        cvi6.setBounds(110, 100, 55, 25);
        getContentPane().add(cvi7);
        cvi7.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi8);
        cvi8.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi9);
        cvi9.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi10);
        cvi10.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi11);
        cvi11.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi12);
        cvi12.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi13);
        cvi13.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi14);
        cvi14.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi15);
        cvi15.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi16);
        cvi16.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi17);
        cvi17.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi18);
        cvi18.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi19);
        cvi19.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi20);
        cvi20.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi21);
        cvi21.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi22);
        cvi22.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi23);
        cvi23.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi24);
        cvi24.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi25);
        cvi25.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi26);
        cvi26.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi27);
        cvi27.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi28);
        cvi28.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi29);
        cvi29.setBounds(60, 130, 55, 25);
        getContentPane().add(cvi30);
        cvi30.setBounds(60, 130, 55, 25);

        btEstatisticas.setText("Ver estatísticas");
        btEstatisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstatisticasActionPerformed(evt);
            }
        });
        getContentPane().add(btEstatisticas);
        btEstatisticas.setBounds(10, 500, 200, 23);

        mediavia1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mediavia1.setForeground(new java.awt.Color(255, 255, 255));
        mediavia1.setText("em média, está passando 0 carros a cada 0 segundos na via 1.");
        getContentPane().add(mediavia1);
        mediavia1.setBounds(10, 60, 390, 14);

        mediavia2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        mediavia2.setForeground(new java.awt.Color(255, 255, 255));
        mediavia2.setText("em média, está passando 0 carros a cada 0 segundos na via 2.");
        getContentPane().add(mediavia2);
        mediavia2.setBounds(10, 80, 390, 14);

        ciclosemaforo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ciclosemaforo.setForeground(new java.awt.Color(255, 255, 255));
        ciclosemaforo.setText("O  semáforo já concluiu 0 ciclos.");
        getContentPane().add(ciclosemaforo);
        ciclosemaforo.setBounds(10, 140, 210, 14);

        lbtotal1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbtotal1.setForeground(new java.awt.Color(255, 255, 255));
        lbtotal1.setText("0 Carros já passaram pela via 1");
        getContentPane().add(lbtotal1);
        lbtotal1.setBounds(10, 160, 230, 14);

        lbtotal2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbtotal2.setForeground(new java.awt.Color(255, 255, 255));
        lbtotal2.setText("0 Carros já passaram pela via 2");
        getContentPane().add(lbtotal2);
        lbtotal2.setBounds(10, 170, 230, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MarcoAntônio\\Documents\\NetBeansProjects\\iaSemaforoJADE\\src\\imagens\\mapa.jpg")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 570));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 570));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 570));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobreActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Semáforo com multiagentes - JADE FRAMEWORK\n"+
                "Inteligência Computacional - Professor Pedro Brandão\n\n"+
                "Desenvolvido por:\n"+
                "Marco Antônio A. Gonçalves\n"+
                "Wellison Santos\n"+
                "Ítalo Lopes\n\n"+
                "© 2018");
    }//GEN-LAST:event_sobreActionPerformed

    private void btEstatisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstatisticasActionPerformed
        // TODO add your handling code here:
        if(!vendoEstatisticas){
            ciclosemaforo.setVisible(true);
            tv1.setVisible(true);
            tv2.setVisible(true);
            mediavia1.setVisible(true);
            mediavia2.setVisible(true);
            fluxo1.setVisible(true);
            fluxo2.setVisible(true);
            lbtotal1.setVisible(true);
            lbtotal2.setVisible(true);
            btEstatisticas.setText("Ocultar estatísticas");
            vendoEstatisticas = true;
        }else{
            ciclosemaforo.setVisible(false);
            tv1.setVisible(false);
            tv2.setVisible(false);
            mediavia1.setVisible(false);
            mediavia2.setVisible(false);
            fluxo1.setVisible(false);
            fluxo2.setVisible(false);
            lbtotal1.setVisible(false);
            lbtotal2.setVisible(false);
            btEstatisticas.setText("Ver estatísticas");
            vendoEstatisticas = false;
        }
    }//GEN-LAST:event_btEstatisticasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEstatisticas;
    private javax.swing.JLabel cc;
    private javax.swing.JLabel ciclosemaforo;
    private javax.swing.JLabel cv1;
    private javax.swing.JLabel cv10;
    private javax.swing.JLabel cv11;
    private javax.swing.JLabel cv12;
    private javax.swing.JLabel cv13;
    private javax.swing.JLabel cv14;
    private javax.swing.JLabel cv15;
    private javax.swing.JLabel cv16;
    private javax.swing.JLabel cv17;
    private javax.swing.JLabel cv18;
    private javax.swing.JLabel cv19;
    private javax.swing.JLabel cv2;
    private javax.swing.JLabel cv20;
    private javax.swing.JLabel cv21;
    private javax.swing.JLabel cv22;
    private javax.swing.JLabel cv23;
    private javax.swing.JLabel cv24;
    private javax.swing.JLabel cv25;
    private javax.swing.JLabel cv26;
    private javax.swing.JLabel cv27;
    private javax.swing.JLabel cv28;
    private javax.swing.JLabel cv29;
    private javax.swing.JLabel cv3;
    private javax.swing.JLabel cv30;
    private javax.swing.JLabel cv4;
    private javax.swing.JLabel cv5;
    private javax.swing.JLabel cv6;
    private javax.swing.JLabel cv7;
    private javax.swing.JLabel cv8;
    private javax.swing.JLabel cv9;
    private javax.swing.JLabel cvi1;
    private javax.swing.JLabel cvi10;
    private javax.swing.JLabel cvi11;
    private javax.swing.JLabel cvi12;
    private javax.swing.JLabel cvi13;
    private javax.swing.JLabel cvi14;
    private javax.swing.JLabel cvi15;
    private javax.swing.JLabel cvi16;
    private javax.swing.JLabel cvi17;
    private javax.swing.JLabel cvi18;
    private javax.swing.JLabel cvi19;
    private javax.swing.JLabel cvi2;
    private javax.swing.JLabel cvi20;
    private javax.swing.JLabel cvi21;
    private javax.swing.JLabel cvi22;
    private javax.swing.JLabel cvi23;
    private javax.swing.JLabel cvi24;
    private javax.swing.JLabel cvi25;
    private javax.swing.JLabel cvi26;
    private javax.swing.JLabel cvi27;
    private javax.swing.JLabel cvi28;
    private javax.swing.JLabel cvi29;
    private javax.swing.JLabel cvi3;
    private javax.swing.JLabel cvi30;
    private javax.swing.JLabel cvi4;
    private javax.swing.JLabel cvi5;
    private javax.swing.JLabel cvi6;
    private javax.swing.JLabel cvi7;
    private javax.swing.JLabel cvi8;
    private javax.swing.JLabel cvi9;
    private javax.swing.JLabel fluxo1;
    private javax.swing.JLabel fluxo2;
    private javax.swing.JLabel iniciando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbtotal1;
    private javax.swing.JLabel lbtotal2;
    private javax.swing.JLabel mediavia1;
    private javax.swing.JLabel mediavia2;
    private javax.swing.JLabel sem1i;
    private javax.swing.JLabel sem1ii;
    private javax.swing.JLabel sem2i;
    private javax.swing.JLabel sem2ii;
    private javax.swing.JButton sobre;
    private javax.swing.JLabel time;
    private javax.swing.JLabel tv1;
    private javax.swing.JLabel tv2;
    private javax.swing.JLabel via2;
    private javax.swing.JLabel via3;
    // End of variables declaration//GEN-END:variables

}
