/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MarcoAntônio
 */
public class Tabela extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;

    // Abaixo, método responsável por setar a quantidade de linhas e colunas
    public Tabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);        
    }
    
    // abaixo método para retornar as linhas
    public ArrayList getLinhas(){
        return linhas;
    }
    
    // método para Setar(Fazer) as linhas, preenchar as linhas 
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }
    
    
     public String[] getColunas(){
        return colunas;
    }
     
     // Responsável por preencher os nomes das colunas
     public void setColunas(String[] nomes){
        colunas = nomes;
     }
     
     // Método para realizar a contagem do número de colunas
     public int getColumnCount(){
         return colunas.length;   // retorna o a qtde de colunas
     }
     
     // conta a quantidade de linhas
     public int getRowCount(){
         return linhas.size();  // conta tamaho da array, qto elementos tem na Array
     }
     
     // responsável por pegar o valor da colunas
     public String getColumnName(int numCol){
         return colunas[numCol];
     }
     
     // Pega colunas(numCol) e linhas(numLin) para montar a tabela
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[])getLinhas().get(numLin); 
         return linha[numCol];
     }
}
