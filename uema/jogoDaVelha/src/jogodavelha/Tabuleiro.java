/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;


/**
 *
 * @author MarcoAntônio, Wellison, Italo
 */
public class Tabuleiro {
    public String[][] auxiliar = new String[3][3];
    public int[][] tabuleiro = new int[3][3];
    
    public Tabuleiro(){
        zerartab();
        printtab();
    }
    
    public void zerartab(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.tabuleiro[i][j] = 0;
            }
        }
    }
    
    public void preencherAux(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(tabuleiro[i][j] == 0){
                    this.auxiliar[i][j] = "   ";
                }else if(tabuleiro[i][j] == 1){
                    this.auxiliar[i][j] = " X ";
                }else if(tabuleiro[i][j] == -1){
                    this.auxiliar[i][j] = " O ";
                }
            }
        }
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    public void printtab(){
        preencherAux();
        System.out.println();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(j>1){
                    System.out.print(auxiliar[i][j]);
                }else{
                    System.out.print(auxiliar[i][j]+"|");
                }
            }
            if(i>1){
                System.out.println("\n");
            }else{
                System.out.println("\n-----------");
            }
        }
    }
    
}
