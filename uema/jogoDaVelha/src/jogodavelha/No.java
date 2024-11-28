/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.ArrayList;

/**
 *
 * @author MarcoAntônio, Wellison, Italo
 */
public class No {
    int[][] no;// = new int[3][3];
    ArrayList<No> filhos;
    int valor;
    int vez;
    
    public No(int[][] mat){
        setNo(mat);
    }
    
    public No(){
        
    }

    public int[][] getNo() {
        return no;
    }

    public void setNo(int[][] no) {
        this.no = no;
    }

    public int getVez() {
        return vez;
    }

    public void setVez(int vez) {
        this.vez = vez;
    }
    
    public ArrayList<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<No> filhos) {
        this.filhos = filhos;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    /*public No criarNo(No nodo, int valor){
        //No nodo = new No();
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                
//            }
//        }
        
        nodo.filhos.add(nodo);
        return nodo;
    }*/
    
    public boolean verifEmpate(int[][] mat){
        boolean emp = false;
        if(verifComplete(mat)){
           if(!verifVenc(mat)) emp = true;
        }
        return emp;
    }
    
    public boolean verifVenc(int[][] mat){
        boolean temvenc = false;
        if((mat[0][0] == 1 && mat[0][1] == 1 && mat[0][2] == 1) ||
           (mat[1][0] == 1 && mat[1][1] == 1 && mat[1][2] == 1) ||
           (mat[2][0] == 1 && mat[2][1] == 1 && mat[2][2] == 1) ||
           (mat[0][0] == 1 && mat[1][0] == 1 && mat[2][0] == 1) ||
           (mat[0][1] == 1 && mat[1][1] == 1 && mat[2][1] == 1) ||
           (mat[0][2] == 1 && mat[1][2] == 1 && mat[2][2] == 1) ||
           (mat[0][0] == 1 && mat[1][1] == 1 && mat[2][2] == 1) ||
           (mat[0][2] == 1 && mat[1][1] == 1 && mat[2][0] == 1)){
            //this.venc = 1;
            temvenc = true;
        }
        if((mat[0][0] == -1 && mat[0][1] == -1 && mat[0][2] == -1) ||
           (mat[1][0] == -1 && mat[1][1] == -1 && mat[1][2] == -1) ||
           (mat[2][0] == -1 && mat[2][1] == -1 && mat[2][2] == -1) ||
           (mat[0][0] == -1 && mat[1][0] == -1 && mat[2][0] == -1) ||
           (mat[0][1] == -1 && mat[1][1] == -1 && mat[2][1] == -1) ||
           (mat[0][2] == -1 && mat[1][2] == -1 && mat[2][2] == -1) ||
           (mat[0][0] == -1 && mat[1][1] == -1 && mat[2][2] == -1) ||
           (mat[0][2] == -1 && mat[1][1] == -1 && mat[2][0] == -1)){
            //this.venc = -1;
            temvenc = true;
        }
        return temvenc;
    }
    
    public boolean verifComplete(int[][] mat){
        if(mat[0][0] != 0 && mat[0][1] != 0 && mat[0][2] != 0 &&
           mat[1][0] != 0 && mat[1][1] != 0 && mat[1][2] != 0 &&
           mat[2][0] != 0 && mat[2][1] != 0 && mat[2][2] != 0){
           return true;
        }
        return false;
    }
    
}
