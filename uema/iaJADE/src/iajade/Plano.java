/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iajade;

import jade.core.Agent;

/**
 *
 * @author MarcoAntônio
 */
public class Plano extends Agent {
    public Semaforo smf1, smf2;
    public Sensor sen1, sen2;
    public int tverde, tvermelho;
    
    @Override
    public void setup(){
        
    }
    
    public void determinarTempos(Double fluxo){
        if(fluxo>=10){
            this.tverde = 50;
            this.tvermelho = 30;
        }
        if(fluxo>=5 && fluxo<10){
            this.tverde = 40;
            this.tvermelho = 35;
        }
        if(fluxo<5){
            this.tverde = 35;
            this.tvermelho = 35;
        }
    }
    
    public int[] enviarTempoCores(){
        int[] temposcores = new int[2];//
        
        return temposcores;
    }
}
