/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MarcoAntônio, Wellison, Italo
 */
public class Jogo {
    public Tabuleiro tab = new Tabuleiro();
    public int[][] auxTab = new int[3][3];
    public Scanner entrada = new Scanner(System.in);
    public String jogador1, jogador2;
    public int opcao, linha, coluna, rodada = 1, vez = 1, venc;
    public boolean fim = false;
    public String vencedor;
    public Tabuleiro pai;
    public ArrayList<int[][]> filhos = new ArrayList<int[][]>();
    public No no;
    
    public Jogo(){
        zerarAuxTab();
        iniciarJogadores();
        jogar();
        
        //alphabeta(auxTab, -3);
    }
    
    public void zerarAuxTab(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.auxTab[i][j] = 0;
            }
        }
    }
    
    public int alphabeta(int[][] mat, int valor){
        if(!no.verifEmpate(mat) || !no.verifVenc(mat)){
            no = fazerArvore(no, mat);
            return no.valor;
        }
        return no.valor;
    }
    
    public void jogar(){
        if(jogador1 == "humano" && jogador2 == "humano"){
            humxhum();
        }else if(jogador1 == "humano" && jogador2 == "computador"){
            humxcomp();
        }else if(jogador1 == "computador" && jogador2 == "humano"){
            compxhum();
        }
    }
    
    public void humxhum(){
        System.out.println("\n--- Jogo da Velha ---");
        do{
            System.out.println("Rodada "+rodada+"!");
            solicitarjogada();
            verificarVencedor();
            alterarVez();
            rodada++;
        }while(!fim);
        if(vencedor == "N"){
            System.out.println("O jogo foi empatado!");
        }else{
            System.out.println("O vencedor foi o jogador: "+vencedor);
        }
    }
    
    public void humxcomp(){
        System.out.println("a implementar");
    }
    
    public void compxhum(){
        System.out.println("a implementar");
    }
    
    public void alterarVez(){
        if(vez == 1){
            this.vez = -1;
        }
        else if(vez == -1){
            this.vez = 1;
        }
    }
    
    public void verificarVencedor(){
        if((auxTab[0][0] == 1 && auxTab[0][1] == 1 && auxTab[0][2] == 1) ||
           (auxTab[1][0] == 1 && auxTab[1][1] == 1 && auxTab[1][2] == 1) ||
           (auxTab[2][0] == 1 && auxTab[2][1] == 1 && auxTab[2][2] == 1) ||
           (auxTab[0][0] == 1 && auxTab[1][0] == 1 && auxTab[2][0] == 1) ||
           (auxTab[0][1] == 1 && auxTab[1][1] == 1 && auxTab[2][1] == 1) ||
           (auxTab[0][2] == 1 && auxTab[1][2] == 1 && auxTab[2][2] == 1) ||
           (auxTab[0][0] == 1 && auxTab[1][1] == 1 && auxTab[2][2] == 1) ||
           (auxTab[0][2] == 1 && auxTab[1][1] == 1 && auxTab[2][0] == 1)){
           this.vencedor = "X";
           this.fim = true;
        }
        if((auxTab[0][0] == -1 && auxTab[0][1] == -1 && auxTab[0][2] == -1) ||
           (auxTab[1][0] == -1 && auxTab[1][1] == -1 && auxTab[1][2] == -1) ||
           (auxTab[2][0] == -1 && auxTab[2][1] == -1 && auxTab[2][2] == -1) ||
           (auxTab[0][0] == -1 && auxTab[1][0] == -1 && auxTab[2][0] == -1) ||
           (auxTab[0][1] == -1 && auxTab[1][1] == -1 && auxTab[2][1] == -1) ||
           (auxTab[0][2] == -1 && auxTab[1][2] == -1 && auxTab[2][2] == -1) ||
           (auxTab[0][0] == -1 && auxTab[1][1] == -1 && auxTab[2][2] == -1) ||
           (auxTab[0][2] == -1 && auxTab[1][1] == -1 && auxTab[2][0] == -1)){
           this.vencedor = "O";
           this.fim = true;
        }
        if(auxTab[0][0] != 0 && auxTab[0][1] != 0 && auxTab[0][2] != 0 &&
           auxTab[1][0] != 0 && auxTab[1][1] != 0 && auxTab[1][2] != 0 &&
           auxTab[2][0] != 0 && auxTab[2][1] != 0 && auxTab[2][2] != 0){
           this.vencedor = "N";
           this.fim = true;
        }
    }
    
    public void iniciarJogadores(){
        System.out.println("Escolha o tipo de jogo:");
        System.out.println("1. Humano x Humano");
        System.out.println("2. Humano x Computador");
        System.out.println("3. Computador x Humano");
        do{
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            if(opcao<1 && opcao>3){
                System.out.println("Opção inválida! tente novamente.");
            }
        }while(opcao<1 && opcao>3);
        if(opcao == 1){
            this.jogador1 = "humano";
            this.jogador2 = "humano";
        }else if(opcao == 2){
            this.jogador1 = "humano";
            this.jogador2 = "computador";
        }else if(opcao == 3){
            this.jogador1 = "computador";
            this.jogador2 = "humano";
        }
        
        System.out.println("Player 1 (X): "+jogador1+";\nPlayer 2 (O): "+jogador2+";");
    }
    
    public void solicitarjogada (){
        System.out.println("Digite as coordenadas de onde deseja jogar!");
        do{
            System.out.print("linha: ");
            this.linha = entrada.nextInt() - 1;
            if(linha<0 || linha>2){
                System.out.println("Escolha inválida! tente novamente.");
            }
        }while(linha<0 || linha>2);
        do{
            System.out.print("coluna: ");
            this.coluna = entrada.nextInt() - 1;
            if(coluna<0 || coluna>2){
                System.out.println("Escolha inválida! tente novamente.");
            }
        }while(coluna<0 || coluna>2);
        
        boolean disponibilidade = verificarDisponibilidade(linha, coluna);
        if(disponibilidade){
            realizarjogada(linha,coluna);
        }else{
            System.out.println("Local indisponível! tente novamente.");
            solicitarjogada();
        }
    }
    
    public boolean verificarDisponibilidade(int l, int c){
        boolean result;
        if(auxTab[l][c] == 0){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
    
    public void realizarjogada(int l, int c){
        this.auxTab[l][c] = vez;
        tab.setTabuleiro(auxTab);
        tab.printtab();
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }
    
   public No fazerArvore(No nodo, int[][] mat){
       no = new No();
       if(!no.verifVenc(mat) && !no.verifVenc(mat)){
           for(int i=0; i<3; i++){
               for(int j=0; j<3; j++){
                   nodo.getNo()[i][j] = mat[i][j];
                   nodo.filhos.add(no);
               }
           }
       }
       return no;
   }
}
