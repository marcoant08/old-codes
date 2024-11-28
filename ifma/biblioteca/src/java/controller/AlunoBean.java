package controller;

import dao.AlunoDAO;
import dao.Conexao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Aluno;

@ManagedBean
@RequestScoped

public class AlunoBean {
    private AlunoDAO alunoDAO;
    private Aluno alu;
    //private DataModel<Aluno> alunos;
    
    public void Novo(){
        alu=new Aluno();
    }
    public String inserir(){
        
        String resultado = "Falha";
       alunoDAO = new AlunoDAO();
       boolean retorno = alunoDAO.inserir(alu);
       if(retorno){
           resultado = "Alunos";
       }
            return resultado;
  }

    public Aluno getAlu() {
        return alu;
    }

    public void setAlu(Aluno alu) {
        this.alu = alu;
    }
}
