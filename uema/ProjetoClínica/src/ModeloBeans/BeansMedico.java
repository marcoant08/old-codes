// Modelo responsável pela classe declarada, criar os atributos, encapsular, criar os gets e sets
package ModeloBeans;

public class BeansMedico {

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    private int codigo;
    private String nome;
    private String especialização;
    private int crm;
    private String pesquisa;
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialização() {
        return especialização;
    }

    public void setEspecialização(String especialização) {
        this.especialização = especialização;
    }
    
    public int getCrm() {
        return crm;
    }
  
    public void setCrm(int crm) {
        this.crm = crm;
    }
    
    
    
}
