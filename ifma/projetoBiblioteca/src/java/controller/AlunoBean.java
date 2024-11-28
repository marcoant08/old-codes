
package controller;

import dao.AlunoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Aluno;
import model.Login;



@ManagedBean

@SessionScoped
public class AlunoBean implements Serializable{

    private Login log;
    private AlunoDAO alunoDAO;
    private Aluno aluno;
    private DataModel<Aluno> alunos;

    public AlunoBean(){
        aluno = new Aluno();
        log = new Login();
    }

    public Login getLog() {
        return log;
    }

    public void setLog(Login log) {
        this.log = log;
    }

    public AlunoDAO getAlunoDAO() {
        return alunoDAO;
    }

    public void setAlunoDAO(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
 
    public String inserir() throws SQLException{
        String resultado = "falha";
        alunoDAO = new AlunoDAO();
        boolean retorno = alunoDAO.inserir(aluno);

        if(retorno){
            resultado = "alunos";
        }

        return resultado;
    }

    public void selecionar(){
        aluno = alunos.getRowData();
    }

    public String alterar() throws SQLException{
        String resultado = "falha";
        alunoDAO = new AlunoDAO();
        boolean retorno = alunoDAO.alterar(aluno);

        if(retorno){
            resultado = "alunos";
        }

        return resultado;
    }
    
    public String remover() throws SQLException{
        String resultado = "falha";
        alunoDAO = new AlunoDAO();
        boolean retorno = alunoDAO.alterar(aluno);

        if(retorno){
            resultado = "alunos";
        }
        
        return resultado;
    }

    public DataModel<Aluno> getAlunos() throws SQLException {
        alunoDAO = new AlunoDAO();
        List<Aluno> alunoList = alunoDAO.listar();
        alunos = new ListDataModel<Aluno>(alunoList);
        return alunos;
    }

    public String logar(){
        if(log.getUsuario().equals("mapa") && log.getSenha().equals("mapa"))
        {
            return "principal.jsf";
        }else{
            return "login.jsf";
        }
    }
    public String limpar(){
        aluno.setNome("");
        aluno.setEndereco("");
        aluno.setCPF("");
        aluno.setTelefone("");
        
        log.setUsuario("");
        log.setSenha("");
        return null;
    }
}