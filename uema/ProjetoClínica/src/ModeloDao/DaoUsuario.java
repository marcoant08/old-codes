
package ModeloDao;

import ModeloBeans.BeansMedico;
import ModeloBeans.BeansUsuario;
import ModeloConnection.ConexãoDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoUsuario {
    
    ConexãoDB conex = new ConexãoDB();
    BeansUsuario mod = new BeansUsuario();
    
    public void Editar(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("update usuarios set usu_nome=?, usu_senha=?, usu_tipo=? where usu_cod=?");
            pst.setString(1, mod.getUsuNome());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.setInt(4, mod.getUsuCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do usuário!\nErro:!"+ex);
        }
        
        conex.desconect();
    }
    
    public void Excluir(BeansUsuario mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from usuarios where usu_cod=?");
            pst.setInt(1, mod.getUsuCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso:!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário\nErro:!"+ex);
        }
        
        
        conex.desconect();
    }
    
    public void Salvar(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("insert into usuarios(usu_nome, usu_senha, usu_tipo) values(?,?,?)");
            pst.setString(1,mod.getUsuNome());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário!\nErro"+ex);
        }
        
        conex.desconect();
    }
    
    public BeansUsuario buscaUsuario(BeansUsuario mod){
        conex.conexao();
        conex.executaSQL("select *from usuarios where usu_nome like'%"+mod.getUsuPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setUsuCod(conex.rs.getInt("usu_cod"));
            mod.setUsuNome(conex.rs.getString("usu_nome"));
            mod.setUsuTipo(conex.rs.getString("usu_tipo"));
            mod.setUsuSenha(conex.rs.getString("usu_senha"));
               
                 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
        }
        
        conex.desconect();
        return mod;
    }
    
}
