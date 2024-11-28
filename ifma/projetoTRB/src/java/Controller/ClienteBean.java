package Controller;


import DAO.ClienteDAO;
import Model.Cliente;
import Model.login;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



@ManagedBean

@SessionScoped
public class ClienteBean implements Serializable{

    private login log;
    private ClienteDAO clienteDAO;
    private Cliente cliente = new Cliente();
    private DataModel<Cliente> clientes;

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void novo(){
        cliente = new Cliente();
    }

    public String inserir() throws SQLException{
        String resultado = "falha";
        clienteDAO = new ClienteDAO();
        boolean retorno = clienteDAO.inserir(cliente);

        if(retorno){
            resultado = "clientes";
        }

        return resultado;
    }

    public void selecionar(){
        cliente = clientes.getRowData();
    }

    public String alterar() throws SQLException{
        String resultado = "falha";
        clienteDAO = new ClienteDAO();
        boolean retorno = clienteDAO.alterar(cliente);

        if(retorno){
            resultado = "clientes";
        }

        return resultado;
    }

    public String remover() throws SQLException{
        String resultado = "falha";
        clienteDAO = new ClienteDAO();
        boolean retorno = clienteDAO.remover(cliente);

        if(retorno){
            resultado = "clientes";
        }

        return resultado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DataModel<Cliente> getClientes() throws SQLException {
        clienteDAO = new ClienteDAO();
        List<Cliente> clienteList = clienteDAO.listar();
        clientes = new ListDataModel<Cliente>(clienteList);
        return clientes;
    }

    public void setClientes(DataModel<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String login(){
        if(log.getUsuario().equals("Valdemar")&&(log.getSenha().equals("machado"))){
            return "Principal.jsf";
        }else{
            return "Login.jsf";
        }
    }

    public login getLog() {
        return log;
    }

    public void setLog(login log) {
        this.log = log;
    }
    
}