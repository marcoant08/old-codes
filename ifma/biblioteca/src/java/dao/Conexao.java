
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private String USER="root";
    private String SENHA="123456";
    private Connection Conn; 
    
public Conexao(){
    try{
        Class.forName(driver);
        Conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
    }catch (Exception e){
        e.printStackTrace();
    }
}
    public Connection getConn(){
        return Conn;
    }
    
    public void fecharConexao(){
        try{
            Conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    
}
