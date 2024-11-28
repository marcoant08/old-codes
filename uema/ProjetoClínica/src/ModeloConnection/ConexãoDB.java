package ModeloConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class ConexãoDB {
    
    public Statement stm; //responsável pelas pesquisas
    public ResultSet rs; //responsável por guardar as pesquisas
//    private String driver = "org.postgresql.Driver";
//    private String caminho = "jdbc:postgresql://localhost:5432/ProjetoClinica";
//    private String usuario = "postgres";
//    private String senha = "major";
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/clinica";
    private String usuario = "root";
    private String senha = "123456";
    public Connection conn; 
    
//    public void conexao(){ // método responsável por realizar a conexão com o banco de dados
//        
//        try {
//            System.setProperty("jdbc.Drivers", driver);
//            con=DriverManager.getConnection(caminho, usuario, senha);
//            //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao se conectar ao Banco de Dados:\n"+ex.getMessage());
//        }
//           
//    }
//    
//    public void executaSql(String sql){
//        try {
//            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
//            rs = stm.executeQuery(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ExecutaSql:\n"+ex.getMessage());
//        }
//        
//    }
        
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
    
    public void desconect(){
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "Banco de Dados desconectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao encerrar conexão com o Banco de Dados:\n"+ex.getMessage());
        }
    }
}
