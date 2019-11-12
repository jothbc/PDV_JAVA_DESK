/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Combo_Bean;
import br.Oprincipio.Bean.Produto_Bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Produto_DAO {

    Connection con = null;

    public Produto_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public int getMaxID() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT MAX(id) FROM produto");
            rs = stmt.executeQuery();
            rs.first();
            return rs.getInt("MAX(id)");
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return 0;
    }

    public boolean insertInto(Produto_Bean p) {
        String sql = "INSERT INTO produto (id,codigo,descricao,custo,margem,venda,estoque,estoque_min) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getCodigo());
            stmt.setString(3, p.getDescricao());
            stmt.setDouble(4, p.getCusto());
            stmt.setDouble(5, p.getMargem());
            stmt.setDouble(6, p.getVenda());
            stmt.setDouble(7, p.getEstoque());
            stmt.setDouble(8, p.getEstoque_min());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("PRIMARY")) {
                JOptionPane.showMessageDialog(null, "Não é possivel dois produtos utilizarem o mesmo código!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean update(Produto_Bean p) {
        String sql = "UPDATE produto SET codigo = ?, descricao = ?, custo = ?, margem = ?, venda = ?, estoque = ?, estoque_min = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getCusto());
            stmt.setDouble(4, p.getMargem());
            stmt.setDouble(5, p.getVenda());
            stmt.setDouble(6, p.getEstoque());
            stmt.setDouble(7, p.getEstoque_min());
            stmt.setInt(8, p.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("PRIMARY")) {
                JOptionPane.showMessageDialog(null, "Não é possivel dois produtos utilizarem o mesmo código!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Produto_Bean> findAll() {
        List<Produto_Bean> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto_Bean p = new Produto_Bean();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setCusto(rs.getDouble("custo"));
                p.setMargem(rs.getDouble("margem"));
                p.setVenda(rs.getDouble("venda"));
                p.setEstoque(rs.getDouble("estoque"));
                p.setEstoque_min(rs.getDouble("estoque_min"));
                produtos.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public Produto_Bean getProduto_COD(String cod) {
        String sql = "SELECT * FROM produto WHERE codigo = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cod);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto_Bean p = new Produto_Bean();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setCusto(rs.getDouble("custo"));
                p.setMargem(rs.getDouble("margem"));
                p.setVenda(rs.getDouble("venda"));
                p.setEstoque(rs.getDouble("estoque"));
                p.setEstoque_min(rs.getDouble("estoque_min"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public Produto_Bean getProduto_ID(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto_Bean p = new Produto_Bean();
                p.setId(rs.getInt("id"));
                p.setCodigo(rs.getString("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setCusto(rs.getDouble("custo"));
                p.setMargem(rs.getDouble("margem"));
                p.setVenda(rs.getDouble("venda"));
                p.setEstoque(rs.getDouble("estoque"));
                p.setEstoque_min(rs.getDouble("estoque_min"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
    public boolean entradaItem(String cd, double qtd){
        String sql = "UPDATE produto SET estoque = estoque + ? WHERE codigo = ?";
        PreparedStatement stmt =null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, qtd);
            stmt.setString(2, cd);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    /*
    DAO RELACIONADOS AO COMBO  
     */
    public boolean insertInto(Combo_Bean c) {
        String sql = "INSERT INTO produto (id,codigo,descricao,margem,venda) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getCd());
            stmt.setString(3, c.getDescricao());
            stmt.setDouble(4, c.getMargem());
            stmt.setDouble(5, c.getValor());
            stmt.execute();
            sql = "INSERT INTO combo (codigo, produto,quantidade) VALUES (?,?,?)";
            stmt = con.prepareStatement(sql);
            for (Produto_Bean p : c.getProdutos()) {
                stmt.setString(1, c.getCd());
                stmt.setString(2, p.getCodigo());
                stmt.setDouble(3, p.getQuantidade());
                stmt.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("PRIMARY")) {
                JOptionPane.showMessageDialog(null, "Não é possivel dois produtos utilizarem o mesmo código!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return false;
        }
    }

    public boolean update(Combo_Bean c) {
        String sql = "UPDATE produto SET codigo = ?, margem = ?,descricao = ?, venda = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getCd());
            stmt.setDouble(2, c.getMargem());
            stmt.setString(3, c.getDescricao());
            stmt.setDouble(4, c.getValor());
            stmt.setInt(5, c.getId());
            stmt.executeUpdate();
            removeCombo(c.getCd());
            sql = "INSERT INTO combo (codigo, produto, quantidade) VALUES (?,?,?)";
            stmt = con.prepareStatement(sql);
            for (Produto_Bean p : c.getProdutos()) {
                stmt.setString(1, c.getCd());
                stmt.setString(2, p.getCodigo());
                stmt.setDouble(3, p.getQuantidade());
                stmt.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("PRIMARY")) {
                JOptionPane.showMessageDialog(null, "Não é possivel dois produtos utilizarem o mesmo código!");
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public void removeCombo(String cd) {
        String sql = "DELETE FROM combo WHERE codigo = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cd);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean delete(int id, String cd) {
        String sql = "DELETE FROM produto WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            removeCombo(cd);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean thisIsCombo(String cd) {
        String sql = "SELECT * FROM combo WHERE codigo =" + cd;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            return rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public Combo_Bean getCombo(String cd, String descricao, int id, double valor, double margem) {
        String sql = "SELECT * FROM combo WHERE codigo =" + cd;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Combo_Bean combo = new Combo_Bean();
        combo.setCd(cd);
        combo.setDescricao(descricao);
        combo.setId(id);
        combo.setValor(valor);
        combo.setMargem(margem);
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto_Bean p = new Produto_DAO().getProduto_COD(rs.getString("produto"));
                p.setQuantidade(rs.getDouble("quantidade"));
                combo.addProduto(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Produto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return combo;
    }

    public List<Combo_Bean> getAllCombos() {
        List<Produto_Bean> produtos = new Produto_DAO().findAll();
        List<Combo_Bean> combos = new ArrayList<>();
        for (Produto_Bean p : produtos) {
            if (new Produto_DAO().thisIsCombo(p.getCodigo())) {
                combos.add(new Produto_DAO().getCombo(p.getCodigo(), p.getDescricao(), p.getId(), p.getVenda(), p.getMargem()));
            }
        }
        return combos;
    }
    
    public boolean entradaCombo(String cd,double qtd){
        List<Combo_Bean> combos = new Produto_DAO().getAllCombos();
        Combo_Bean combo = new Combo_Bean();
        for (Combo_Bean c:combos){
            if (c.getCd().equals(cd)){
                combo = c;
                break;
            }
        }
        for (Produto_Bean p:combo.getProdutos()){
            String cd_ = p.getCodigo();
            double qtd_ = p.getQuantidade()*qtd;
            if (!new Produto_DAO().entradaItem(cd_, qtd_)){
                return false;
            }
        }
        return true;
    }
}
