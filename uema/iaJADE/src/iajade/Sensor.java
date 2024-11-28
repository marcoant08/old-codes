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
public class Sensor extends Agent {
    //public Double fluxo;//numero de carros por intervalo de tempo
    public int contador;
    public int tempo = 30;

//    public Double getFluxo() {
//        return fluxo;
//    }
//
//    public void setFluxo(Double fluxo) {
//        this.fluxo = fluxo;
//    }
    
    @Override
    public void setup(){
        
    }
    
    public int determinarFluxo() throws InterruptedException{//numero de carros por intervalo de tempo
        int fluxo = 0;
        
        for(int i=0; i<this.tempo; i++){
            fluxo = this.contador;
            Thread.sleep(1000);
        }
        
        return fluxo;
    }
    
//    public void contar(int numcarros){
//        this.contador = numcarros;
//    }
}
