
package ModeloDao;

import ModeloConnection.ConexãoDB;
import ModeloBeans.BeansMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DaoMedico {
    
    ConexãoDB conex = new ConexãoDB();
    BeansMedico mod = new BeansMedico();
    
    public void Salvar(BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("insert into medicos(nome_medico, especialização_medico, crm_medico) values(?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setString(2, mod.getEspecialização());
            pst.setInt(3, mod.getCrm());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!\nErro"+ex);
        }
        
        conex.desconect();
    }
    
    public void Editar(BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.conn.prepareStatement("update medicos set nome_medico=?, especialização_medico=?, crm_medico=? where cod_medico=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialização());
            pst.setInt(3, mod.getCrm());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!\nErro:!"+ex);
        }
        
        conex.desconect();
    }
    
    public void Excluir(BeansMedico mod){
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.conn.prepareStatement("delete from medicos where cod_medico=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso:!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dos dados!\nErro:!"+ex);
        }
        
        
        conex.desconect();
    }
    
    public BeansMedico buscaMedico(BeansMedico mod){
        conex.conexao();
        conex.executaSQL("select *from medicos where nome_medico like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_medico"));
            mod.setNome(conex.rs.getString("nome_medico"));
            mod.setEspecialização(conex.rs.getString("especialização_medico"));
            mod.setCrm(conex.rs.getInt("crm_medico"));          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Médico não cadastrado!");
        }
        
        conex.desconect();
        return mod;
    }
    
}
