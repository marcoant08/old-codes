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
public class Semaforo extends Agent {
    public int cor;// 1 = vermelho | 2 = verde

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    
    @Override
    public void setup(){
        
    }
    
    public void usarMelhorPlano(){
        //
        //
        //
        //
    }
}
