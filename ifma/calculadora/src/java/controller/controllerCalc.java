package controller;

import dao.AlunoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Aluno;
import model.Autenticacao;
import model.Calc;
import model.Func;


@ManagedBean
@RequestScoped
public class controllerCalc {

    private Calc calc1;
    private Autenticacao aut;
    private Aluno cl;
    private Func funk;
    private Aluno aluno;
    
    public controllerCalc() {
        calc1 = new Calc();
        aut = new Autenticacao();
        cl = new Aluno();
        funk = new Func();
    }

    public Func getFunk() {
        return funk;
    }

    public void setFunk(Func funk) {
        this.funk = funk;
    }

    public Aluno getCl() {
        return cl;
    }

    public void setCl(Aluno cl) {
        this.cl = cl;
    }

    public Calc getCalc1() {
        return calc1;
    }

    public void setCalc1(Calc calc1) {
        this.calc1 = calc1;
    }

    public Autenticacao getAut() {
        return aut;
    }

    public void setAut(Autenticacao aut) {
        this.aut = aut;
    }
    
    public void soma(){
        
       double a,b,res;
        a = this.calc1.getNum1();
        b = this.calc1.getNum2();  
          
         res = a + b;
         
       this.calc1.setResult(res);
         
    }
    public void sub(){
        
       double a,b,res;
        a = this.calc1.getNum1();
        b = this.calc1.getNum2();  
          
         res = a - b;
         
       this.calc1.setResult(res);
         
    }
    public void multi(){
        
       double a,b,res;
        a = this.calc1.getNum1();
        b = this.calc1.getNum2();
          
         res = a * b;
         
       this.calc1.setResult(res);
         
    }
    public void divi(){
        
       double a,b,res;
        a = this.calc1.getNum1();
        b = this.calc1.getNum2();  
          
         res = a / b;
         
       this.calc1.setResult(res);
         
    }
    public String logar(){
        
        if(aut.getUsuario().equals("MA") && aut.getSenha().equals("123"))
        {
            return "telaprincipal.jsf";
        }else{
            return "login.jsf";
        }
    }
    
    public String limpar(){
        funk.setNome("");
        funk.setEndereco("");
        funk.setEmail("");
        funk.setCargo("");
        funk.setRg("");
        funk.setFone("");
        funk.setCpf("");
        funk.setCelular1("");
        
        aut.setUsuario("");
        aut.setSenha("");
        
        cl.setNome("");
        cl.setEndereco("");
        cl.setEmail("");
        cl.setRg("");
        cl.setFone("");
        cl.setCpf("");
        cl.setCelular1("");
        
        calc1.setNum1(0);
        calc1.setNum2(0);
        calc1.setResult(0);
        
        return null;
    }
    public void salvar(){
        AlunoDAO alu = new AlunoDAO();
        alu.inserir(aluno);
    }
}
