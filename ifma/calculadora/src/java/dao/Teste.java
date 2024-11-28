
package dao;

import java.sql.SQLException;


public class Teste {
   
    public static void main(String[] args) throws SQLException {
         ConexaoBD conn = new ConexaoBD();
         
         conn.conexaoOpen();
      //   conn.inserir();
    }
}
