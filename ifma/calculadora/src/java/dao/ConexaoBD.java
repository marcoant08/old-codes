

package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBD {
    private static final String driver="org.gjt.mm.mysql.Driver";
     private static final String url="jdbc:mysql://localhost:3306/biblioteca";
      private static final String usuario="root";
       private static final String senha="123456";
       private Connection conn; 
       private Statement stmt; 
       private PreparedStatement pstmt;
       private ResultSet rs;
       
       public void conexaoOpen() throws SQLException{ 
           try{
          Class.forName(driver);
          conn = (Connection) DriverManager.getConnection(url, usuario, senha);
          System.out.println("Conectado com sucesso");
           }catch(Exception e ){
               e.printStackTrace();
           }
               /*catch (ClassNotFoundException ex) {
                   Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE,null,ex);
                     System.out.println("CONEXÃO FALHOU: 1");
                       
                       }*/
       }
    
       public Connection getConn(){
        return conn;
           
       }
       
       /*public void inserir() throws SQLException{
           
           try{
               
            conexaoOpen();
            stmt = conn.createStatement();
            
            String sql = "insert into Aluno(endereco,bairro,cidade,sexo,cpf,celular1) values('Pedro leitão','Auto bonito','Duque Bacelar','Masculino','2234664758','098 982331476') ";
            
            stmt.executeUpdate(sql);
            
            System.out.println("inserido com sucesso");
           }catch(SQLException ex){
            ex.printStackTrace();
           }
       }*/
       
       }
