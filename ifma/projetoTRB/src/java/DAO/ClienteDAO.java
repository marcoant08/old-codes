/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import Model.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;

    public ClienteDAO() throws SQLException {
        conexao = new Conexao();
        stmt = (Statement) conexao.getConn().createStatement();
    }

    public boolean inserir(Cliente cliente) {
        conexao = new Conexao();
        try {   
            System.out.println();
            stmt.execute("INSERT INTO aluno (MATRICULA, NOME, ENDERECO, CIDADE, UF, TELEFONE, CELULAR, EMAIL, cpf, SEXO) VALUES ('" + cliente.getMATRICULA()+ "','" + cliente.getNOME()+ "','" + cliente.getENDERECO()+ "','" + cliente.getCIDADE()+ "','" + cliente.getUF()+ "','" + cliente.getTELEFONE()+ "','" + cliente.getCELULAR()+ "','" + cliente.getEMAIL()+ "','" + cliente.getCpf()+ "','" + cliente.getSEXO()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean alterar(Cliente cliente) {
        conexao = new Conexao();
        try {
            stmt.execute("UPDATE cliente SET nome = '" + cliente.getNOME()+ "', telefone = '" + cliente.getTELEFONE()+ "' WHERE codigo = '" + cliente.getCodigo() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean remover(Cliente cliente) {
        conexao = new Conexao();
        try {
            stmt.execute("DELETE FROM aluno WHERE nome = '" + cliente.getNOME()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public List<Cliente> listar() {
        conexao = new Conexao();
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno ORDER BY Nome");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNOME(rs.getString("nome"));
                cliente.setTELEFONE(rs.getString("telefone"));
                cliente.setCELULAR(rs.getString("celular"));
                cliente.setCIDADE(rs.getString("cidade"));
                cliente.setEMAIL(rs.getString("email"));
                cliente.setMATRICULA(rs.getString("matricula"));
                cliente.setSEXO(rs.getString("sexo"));
                cliente.setUF(rs.getString("uf"));

                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return clientes;
    }
    
}
