
package dao;

import java.sql.SQLException;
import java.sql.Statement;
import model.Aluno;
/**
 *
 * @author Pedro Alexandre
 */
public class AlunoDAO {
    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;
    
    public AlunoDAO(){
        conexao = new Conexao();
        try{
            stmt=(Statement) conexao.getConn().createStatement();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public boolean inserir(Aluno alu){
        conexao= new Conexao();
        try{
            stmt.executeQuery("INSERT INTO aluno(Nome, Telefone) VALUES('"+ alu.getNome()+",'"+alu.getTelefone()+")");
        sucesso = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            conexao.fecharConexao();
        }
         return sucesso;
    }
   
}
