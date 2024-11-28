/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect;

import classes.Cliente;
import classes.Marca;
import classes.Notebook;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author MarcoAntônio
 */
public class ConectaBD {
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/mydb";
    private String usuario = "root";
    private String senha = "123456";
    public Connection conn;
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            //Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public ArrayList<Cliente> buscarCliente(){
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "Select idCliente, nome, cpf, endereco, telefone from cliente;";
        
        try {
            stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while(resultado.next()){
                Cliente c = new Cliente();
                c.setNome(resultado.getString("nome"));
                c.setCpf(resultado.getString("cpf"));
                c.setEndereco(resultado.getString("endereco"));
                c.setTelefone(resultado.getString("telefone"));
                c.setIdCliente(resultado.getInt("idCliente"));

                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public ArrayList<Notebook> buscarNotebook(){
        ArrayList<Notebook> lista = new ArrayList<>();
        String sql = "Select idNotebook, marca, preco, descricao, modelo, estoque from notebook;";
        
        try {
            stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while(resultado.next()){
                Notebook n = new Notebook();
                n.setMarca(resultado.getString("marca"));
                n.setPreco(resultado.getDouble("preco"));
                n.setDescricao(resultado.getString("descricao"));
                n.setModelo(resultado.getString("modelo"));
                n.setIdNotebook(resultado.getInt("idNotebook"));
                n.setEstoque(resultado.getInt("estoque"));
                
                lista.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public ArrayList<Marca> buscarMarca(){
        ArrayList<Marca> lista = new ArrayList<>();
        String sql = "Select codMarca, nomeMarca from marca;";
        
        try {
            stm = conn.createStatement();
            ResultSet resultado = stm.executeQuery(sql);

            while(resultado.next()){
                Marca m = new Marca();
                m.setIdMarca(resultado.getInt("codMarca"));
                m.setNomeMarca(resultado.getString("nomeMarca"));

                lista.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void desconexao(){
        try {
            conn.close();
            System.out.println("Desconectado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar!\nErro: "+ex.getMessage());
        }
    }
}
