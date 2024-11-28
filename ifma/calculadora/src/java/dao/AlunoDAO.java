package dao;

import java.sql.SQLException;
import java.sql.Statement;
import model.Aluno;

/**
 *
 * @author IFMA - Coelho Neto
 */
public class AlunoDAO {
    private ConexaoBD conexao;
    private Statement stmt;
    private boolean sucesso = false;

   
   
    
    
    public AlunoDAO(){
        
        conexao = new ConexaoBD();
        try{
            stmt = (Statement) conexao.getConn().createStatement();
        }
           
        catch (SQLException ex){
        ex.printStackTrace();
         }
        
        
    }
public boolean inserir(Aluno alu){
    try{
        stmt.execute("INSERT INTO aluno(nome ) values( '"+ alu.getNome()+"') ");
        
        sucesso = true;
        
    }
    catch (Exception e){
        e.printStackTrace();
        
    }
    finally{
       // conexao.fecharConexao();
    }
        return sucesso;
       
}

}    