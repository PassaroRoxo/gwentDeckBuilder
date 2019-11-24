/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Users.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artur
 */

public class AdminDAO extends DAO {
     public void inserir(Admin a) throws Exception {
        Connection c = obterConexao();
        
        String sql = "INSERT INTO usuario (id, nome_usuario, email, senha) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        stmt.setString(2, a.getNome_usuario());
        stmt.setString(3, a.getEmail());
        stmt.setString(4, a.getSenha());
        int resultado = stmt.executeUpdate();
        stmt.close();
        
        sql = "INSERT INTO admin (usuario_id) VALUES (?)";
        stmt = c.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        resultado = stmt.executeUpdate();
        stmt.close();
        
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível inserir este admin");
        }
    }
     
     public void atualizar(Admin a) throws Exception {
        Connection c = obterConexao();
        
        String sql = "UPDATE usuario SET nome_usuario = ?, email = ?, senha = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, a.getNome_usuario());
        stmt.setString(2, a.getEmail());
        stmt.setString(3, a.getSenha());
        stmt.setInt(4, a.getId());
        int resultado = stmt.executeUpdate();
        stmt.close();
        
        sql = "UPDATE admin SET id = ?";
        stmt = c.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        resultado = stmt.executeUpdate();
        stmt.close();
        
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível atualizar este admin");
        }
    }

    public void remover(Admin a) throws Exception {
        Connection c = obterConexao();
        
        String sql = "DELETE FROM admin WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        int resultado = stmt.executeUpdate();
        stmt.close();
        
        sql = "DELETE FROM usuario WHERE id = ?";
        stmt = c.prepareStatement(sql);
        stmt.setInt(1, a.getId());
        resultado = stmt.executeUpdate();
        stmt.close();
        
        fecharConexao(c);
        if (resultado != 1) {
            throw new Exception("Não foi possível remover este admin");
        }
    }

    public Admin obter(int id) throws Exception {
        Admin a = null;
        Connection c = obterConexao();
        String sql = "SELECT id, nome_usuario, email, senha FROM pessoa WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            a = new Admin();
            a.setId(rs.getInt("id"));
            a.setNome_usuario(rs.getString("nome_usuario"));
            a.setEmail(rs.getString("email"));
            a.setSenha(rs.getString("senha"));
            //****************************
            sql = "SELECT id, nome_usuario, email, senha FROM deck WHERE id = ?";
            stmt = c.prepareStatement(sql);
            //****************************
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        if (a == null) {
            throw new Exception("Não foi possível localizar este usuario");
        }
        return a;
    }

    public List<Admin> obterTodos() throws Exception {
        List<Admin> admins = new ArrayList<Admin>();
        Connection c = obterConexao();
        String sql = "SELECT id, nome_usuario, email, senha FROM usuario";
        PreparedStatement stmt = c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Admin a = new Admin();
            a.setId(rs.getInt("id"));
            a.setNome_usuario(rs.getString("nome_usuario"));
            a.setEmail(rs.getString("email"));
            a.setSenha(rs.getString("senha"));
            admins.add(a);
        }
        rs.close();
        stmt.close();
        fecharConexao(c);
        return admins;
    }

}
