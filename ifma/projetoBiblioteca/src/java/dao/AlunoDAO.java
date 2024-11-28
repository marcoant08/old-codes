package dao;

/**
 *
 * @author MarcoAntônio
 */

import model.Aluno;
import model.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;

    public AlunoDAO() throws SQLException {
        conexao = new Conexao();
        stmt = (Statement) conexao.getConn().createStatement();
    }

    public boolean inserir(Aluno aluno) {
        conexao = new Conexao();
        try {   
            System.out.println();
            stmt.execute("INSERT INTO aluno (Nome,Endereco,CPF,Telefone) VALUES ('" + aluno.getNome()+ "','" + aluno.getEndereco()+ "','" +aluno.getCPF()+ "','" + aluno.getTelefone()+ "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean alterar(Aluno aluno) {
        conexao = new Conexao();
        try {
            stmt.execute("UPDATE aluno SET Nome = '" + aluno.getNome()+ "',Endereco = '" + aluno.getEndereco()+ "',"
                    + "CPF = '" + aluno.getCPF()+ "', Telefone = '" + aluno.getTelefone() + "'"
                    + " WHERE Codigo = '" + aluno.getCodigo()+ "' ");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        
        return sucesso;
    }

    public boolean remover(Aluno aluno) {
        conexao = new Conexao();
        try {
            stmt.execute("DELETE FROM aluno WHERE Codigo = '" + aluno.getCodigo()+ "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        
        return sucesso;
    }

    public List<Aluno> listar() {
        conexao = new Conexao();
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM aluno ORDER BY Nome");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigo(rs.getInt("codigo"));
                aluno.setNome(rs.getString("Nome"));
                aluno.setEndereco(rs.getString("Endereco"));
                aluno.setCPF(rs.getString("CPF"));
                aluno.setTelefone(rs.getString("Telefone"));
                alunos.add(aluno);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return alunos;
    }
    
}
