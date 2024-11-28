/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcoAntônio
 */
public class Conexao {
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/lojanalb";
    private String usuario = "root";
    private String senha = "123456";
    public Connection conn;
    
    public void conexa1(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de conexão!\nErro: "+ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Erro no ExecutaSQL!\nErro: "+ex.getMessage());
        }
    }
    
    public void desconecta(){
        try {
            conn.close();
            System.out.println("Desconectado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexão!\nErro: "+ex.getMessage());
        }
    }
}
