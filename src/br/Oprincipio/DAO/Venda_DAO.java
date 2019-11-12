/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Cliente_Bean;
import br.Oprincipio.Bean.Venda_Bean;
import br.Oprincipio.Bean.Combo_Bean;
import br.Oprincipio.Bean.Crediario;
import br.Oprincipio.Bean.Parcela;
import br.Oprincipio.Bean.Produto_Bean;
import funcoes.CDate;
import funcoes.Conv;
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
public class Venda_DAO {

    Connection con = null;

    public Venda_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public int getMovimentoLivre() {
        String sql = "SELECT MAX(movimento) FROM venda_pdv";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.first()) {
                return rs.getInt("MAX(movimento)") + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return 0;
    }

    public boolean movCred(int mov) {
        String sql = "SELECT crediario FROM pagamento_pdv WHERE movimento = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mov);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getDouble("crediario") != 0) {
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public boolean insertInto(Venda_Bean v) {
        PreparedStatement stmt = null;
        try {
            for (Produto_Bean p : v.getProdutos()) {
                stmt = con.prepareStatement("INSERT INTO venda_pdv(movimento,id_cliente,p_codigo,p_descricao,p_venda,p_qtd) VALUES (?,?,?,?,?,?)");
                stmt.setInt(1, v.getMovimento());
                stmt.setInt(2, v.getCliente().getId());
                stmt.setString(3, p.getCodigo());
                stmt.setString(4, p.getDescricao());
                stmt.setDouble(5, Conv.CDblDuasCasas(p.getVenda()));
                stmt.setDouble(6, Conv.CDblDuasCasas(p.getQuantidade()));
                stmt.execute();
            }
            stmt = con.prepareStatement("INSERT INTO pagamento_pdv (movimento,total,troco,dinheiro,credito,debito,crediario,desconto,data,pago) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, v.getMovimento());
            stmt.setDouble(2, Conv.CDblDuasCasas(v.getTotal()));
            stmt.setDouble(3, Conv.CDblDuasCasas(v.getTroco()));
            stmt.setDouble(4, Conv.CDblDuasCasas(v.getDinheiro()));
            stmt.setDouble(5, Conv.CDblDuasCasas(v.getPOS_credito()));
            stmt.setDouble(6, Conv.CDblDuasCasas(v.getPOS_debito()));
            stmt.setDouble(7, Conv.CDblDuasCasas(v.getCrediario()));
            stmt.setDouble(8, Conv.CDblDuasCasas(v.getDesconto()));
            stmt.setString(9, CDate.DataPTBRtoDataMySQL(v.getData()));
            stmt.setBoolean(10, v.isPago());
            stmt.execute();
            stmt = con.prepareStatement("INSERT INTO pagamento_pos (movimento,parcela_data,valor_total,valor_parcela) VALUES (?,?,?,?)");
            stmt.setInt(1, v.getMovimento());
            stmt.setDouble(3, v.getPos().getTotal());
            for (Parcela pa : v.getPos().getParcela()) {
                stmt.setString(2, CDate.DataPTBRtoDataMySQL(pa.getData()));
                stmt.setDouble(4, pa.getValor());
                stmt.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean baixarEstoque(Venda_Bean v) {
        String sql = "UPDATE produto SET estoque = estoque - ? WHERE codigo = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            for (Produto_Bean p : v.getProdutos()) {
                if (new Produto_DAO().thisIsCombo(p.getCodigo())) {
                    Combo_Bean c = new Produto_DAO().getCombo(p.getCodigo(), p.getDescricao(), p.getId(), p.getVenda(), p.getMargem());
                    for (Produto_Bean i : c.getProdutos()) {
                        stmt.setDouble(1, Conv.CDblDuasCasas(i.getQuantidade() * p.getQuantidade()));
                        stmt.setString(2, i.getCodigo());
                        stmt.executeUpdate();
                    }
                } else {
                    stmt.setDouble(1, Conv.CDblDuasCasas(p.getQuantidade()));
                    stmt.setString(2, p.getCodigo());
                    stmt.executeUpdate();
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    /**
     *
     * @param ClienteID
     * @param descontarParcial
     * @return
     */
    public List<Venda_Bean> findAll_VendasPorCliente(int ClienteID,boolean descontarParcial) {
        List<Venda_Bean> vendas = new ArrayList<>();
        String sql = "Select * from venda_pdv WHERE id_cliente = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ClienteID);
            rs = stmt.executeQuery();
            int mov = 0;
            while (rs.next()) {
                if (rs.isFirst()) {
                    mov = rs.getInt("movimento");
                    vendas.add(getVendaPrivate(mov,descontarParcial));
                } else {
                    if (rs.getInt("movimento") != mov) {
                        mov = rs.getInt("movimento");
                        vendas.add(getVendaPrivate(mov,descontarParcial));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return vendas;
    }

    @Deprecated
    public List<Venda_Bean> findAll_VendasPorData(String inicio, String fim) {
        List<Venda_Bean> vendas = new ArrayList<>();
        String sql = "Select * from vw_venda WHERE data >= ? and data <= ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, inicio);
            stmt.setString(2, fim);
            rs = stmt.executeQuery();
            rs.first();
            if (!rs.first()) {
                return null;
            }
            int mov = rs.getInt("movimento");
            List<Produto_Bean> prod = new ArrayList<>();
            Venda_Bean v = new Venda_Bean();
            Cliente_Bean cliente = new Cliente_Bean();
            v.setMovimento(mov);
            //rs.beforeFirst();
            while (rs.next()) {
                //System.out.println("WHILE: " + rs.getInt("seq"));
                if (mov == rs.getInt("movimento")) {
                    Produto_Bean p = new Produto_Bean();
                    p.setCodigo(rs.getString("prod_cd"));
                    p.setDescricao(rs.getString("prod_desc"));
                    p.setVenda(rs.getDouble("prod_valor"));
                    p.setQuantidade(rs.getDouble("prod_qtd"));
                    p.setCancelado(rs.getBoolean("cancelado"));
                    prod.add(p);
                    cliente.setId(rs.getInt("cliente_id"));
                    cliente.setNome(rs.getString("cliente_nome"));
                    v.setTotal(rs.getDouble("total"));
                    v.setTroco(rs.getDouble("troco"));
                    v.setDinheiro(rs.getDouble("dinheiro"));
                    v.setPOS_credito(rs.getDouble("credito"));
                    v.setPOS_debito(rs.getDouble("debito"));
                    v.setCrediario(rs.getDouble("crediario"));
                    v.setDesconto(rs.getDouble("desconto"));
                    v.setData(CDate.DataMySQLtoDataStringPT(rs.getString("data")));
                    v.setPago(rs.getBoolean("pago"));
                    if (rs.getString("data_pago") != null) {
                        v.setData_pago(CDate.DataMySQLtoDataStringPT(rs.getString("data_pago")));
                    }
                    v.setCliente(cliente);
                    v.setMovimento(mov);
                } else if (mov != rs.getInt("movimento")) {
                    v.setProdutos(prod);
                    vendas.add(v);
                    prod = new ArrayList<>();
                    v = new Venda_Bean();
                    cliente = new Cliente_Bean();
                    mov = rs.getInt("movimento");
                    rs.previous();
                }
                if (rs.isLast()) {
                    v.setProdutos(prod);
                    vendas.add(v);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        vendas.forEach((v) -> {
            v.setPos(new POS_DAO().getPOS(v.getMovimento()));
        });
        return vendas;
    }

    public List<Venda_Bean> getVendasPorData(String inicio, String fim, boolean descontarParcial) {
        String sql = "SELECT * FROM pagamento_pdv where data>= ? and data <= ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda_Bean> vendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, inicio);
            stmt.setString(2, fim);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vendas.add(getVendaPrivate(rs.getInt("movimento"), descontarParcial));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return vendas;
    }

    private Venda_Bean getVendaPrivate(int mov, boolean descontarParcial) {
        Venda_Bean venda = new Venda_Bean();
        List<Produto_Bean> produtos = new ArrayList<>();
        String sql = "SELECT * FROM venda_pdv where movimento = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mov);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.isFirst()) {
                    venda.setMovimento(mov); //checked
                    Cliente_Bean c = new Cliente_Bean();
                    c.setId(rs.getInt("id_cliente"));
                    venda.setCliente(c);
                }
                Produto_Bean p = new Produto_Bean();
                p.setCodigo(rs.getString("p_codigo"));
                p.setDescricao(rs.getString("p_descricao"));
                p.setVenda(rs.getDouble("p_venda"));
                p.setQuantidade(rs.getDouble("p_qtd"));
                p.setCancelado(rs.getBoolean("cancelado"));
                produtos.add(p);
            }
            venda.setProdutos(produtos);
            sql = "SELECT * FROM pagamento_pdv where movimento = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mov);
            rs = stmt.executeQuery();
            rs.first();
            venda.setSeq(rs.getInt("seq")); //checked
            venda.setTotal(rs.getDouble("total")); //checked
            venda.setTroco(rs.getDouble("troco")); //checked
            venda.setDinheiro(rs.getDouble("dinheiro")); //checked
            venda.setPOS_credito(rs.getDouble("credito")); //checked
            venda.setPOS_debito(rs.getDouble("debito")); //checked
            if (descontarParcial) {
                venda.setCrediario(rs.getDouble("crediario") - rs.getDouble("parcial_crediario")); //checked
            } else {
                venda.setCrediario(rs.getDouble("crediario"));
            }
            venda.setDesconto(rs.getDouble("desconto")); //checked
            venda.setData(CDate.DataMySQLtoDataStringPT(rs.getString("data"))); //checked
            venda.setPago(rs.getBoolean("pago")); //checked
            if (rs.getString("data_pago") != null) {                    //SEEEEEEE FOI PASSADO NO CREDIARIO
                venda.setData_pago(CDate.DataMySQLtoDataStringPT(rs.getString("data_pago")));
            }
            sql = "SELECT * FROM cliente WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda.getCliente().getId());
            rs = stmt.executeQuery();
            rs.first();
            venda.getCliente().setNome(rs.getString("nome"));
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        venda.setPos(new POS_DAO().getPOS(venda.getMovimento()));
        return venda;
    }

    @Deprecated
    public Venda_Bean getVenda(int mov) {
        Venda_Bean venda = new Venda_Bean();
        List<Produto_Bean> produtos = new ArrayList<>();
        String sql = "SELECT * FROM vw_venda where movimento = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mov);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.isFirst()) {
                    venda.setMovimento(rs.getInt("movimento"));
                    venda.setTotal(rs.getDouble("total"));
                    venda.setTroco(rs.getDouble("troco"));
                    venda.setDinheiro(rs.getDouble("dinheiro"));
                    venda.setPOS_credito(rs.getDouble("credito"));
                    venda.setPOS_debito(rs.getDouble("debito"));
                    venda.setCrediario(rs.getDouble("crediario"));
                    venda.setPago(rs.getBoolean("pago"));
                    venda.setData(CDate.DataMySQLtoDataStringPT(rs.getString("data")));
                    if (rs.getString("data_pago") != null) {
                        venda.setData_pago(CDate.DataMySQLtoDataStringPT(rs.getString("data_pago")));
                    }
                    venda.setDesconto(rs.getDouble("desconto"));
                    Cliente_Bean c = new Cliente_Bean();
                    c.setNome(rs.getString("cliente_nome"));
                    c.setId(rs.getInt("cliente_id"));
                    venda.setCliente(c);
                }
                Produto_Bean p = new Produto_Bean();
                p.setCodigo(rs.getString("prod_cd"));
                p.setDescricao(rs.getString("prod_desc"));
                p.setVenda(rs.getDouble("prod_valor"));
                p.setQuantidade(rs.getDouble("prod_qtd"));
                p.setCancelado(rs.getBoolean("cancelado"));
                produtos.add(p);
            }
            venda.setProdutos(produtos);
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        venda.setPos(new POS_DAO().getPOS(venda.getMovimento()));
        return venda;
    }

    public List<Venda_Bean> histVendaProduto(String cd) {
        String sql = "SELECT movimento, prod_qtd, cliente_nome, data,total FROM vw_venda where prod_cd = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda_Bean> vendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cd);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda_Bean v = new Venda_Bean();
                v.setMovimento(rs.getInt("movimento"));
                //##########################################//
                List<Produto_Bean> p = new ArrayList<>();
                Produto_Bean pp = new Produto_Bean();
                pp.setQuantidade(rs.getDouble("prod_qtd"));
                p.add(pp);
                v.setProdutos(p);
                //##########################################//
                Cliente_Bean c = new Cliente_Bean();
                c.setNome(rs.getString("cliente_nome"));
                v.setCliente(c);
                //##########################################//
                v.setData(CDate.DataMySQLtoDataStringPT(rs.getString("data")));
                v.setTotal(rs.getDouble("total"));
                vendas.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return vendas;
    }

    /*
    * Datas devem ja estar em formato SQL
     */
    public List<Venda_Bean> histVendaProdutoPorData(String cd, String inicio, String fim) {
        String sql = "SELECT movimento, prod_qtd, cliente_nome, data,total FROM vw_venda where prod_cd = ? and data >= ? and data <= ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda_Bean> vendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cd);
            stmt.setString(2, inicio);
            stmt.setString(3, fim);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda_Bean v = new Venda_Bean();
                v.setMovimento(rs.getInt("movimento"));
                //##########################################//
                List<Produto_Bean> p = new ArrayList<>();
                Produto_Bean pp = new Produto_Bean();
                pp.setQuantidade(rs.getDouble("prod_qtd"));
                p.add(pp);
                v.setProdutos(p);
                //##########################################//
                Cliente_Bean c = new Cliente_Bean();
                c.setNome(rs.getString("cliente_nome"));
                v.setCliente(c);
                //##########################################//
                v.setData(CDate.DataMySQLtoDataStringPT(rs.getString("data")));
                v.setTotal(rs.getDouble("total"));
                vendas.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return vendas;
    }

    public boolean pagarCrediario(int mov, double valorPagando) {
        String sql = "UPDATE pagamento_pdv SET pago = 1,data_pago = ?,parcial_crediario = parcial_crediario + ? WHERE movimento = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CDate.DataPTBRtoDataMySQL(CDate.DataPTBRAtual()));
            stmt.setDouble(2, valorPagando);
            stmt.setInt(3, mov);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean injetarCrediarioParcial(int seq, double valor) {
        String sql = "UPDATE pagamento_pdv SET parcial_crediario = parcial_crediario + ? WHERE seq = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setInt(2, seq);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Venda_Bean> getVendasData(String dataSQL) {
        List<Venda_Bean> vendas = new ArrayList();
        int max = getMovimentoLivre();
        for (int i = 0; i < max; i++) {
            Venda_Bean v = new Venda_DAO().getVenda(i);
            if (v != null && dataSQL.equals(v.getData())) {
                vendas.add(v);
            }
        }
        return vendas;
    }

    public boolean cancelarItem(Venda_Bean v, String cd, double qtd) {
        String sql = "UPDATE venda_pdv SET cancelado = 1 WHERE movimento = ? and p_codigo = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, v.getMovimento());
            stmt.setString(2, cd);
            stmt.executeUpdate();
            sql = "UPDATE produto SET estoque = estoque + ?";
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, qtd);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Parcela> getParcelas_Periodo(String inicio, String fim) {
        List<Parcela> parcelas = new ArrayList<>();
        String sql = "SELECT * FROM pagamento_pos WHERE parcela_data >= ? and parcela_data <= ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, inicio);
            stmt.setString(2, fim);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Parcela p = new Parcela(CDate.DataMySQLtoDataStringPT(rs.getString("parcela_data")), rs.getDouble("valor_parcela"));
                p.setMov(rs.getInt("movimento"));
                parcelas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return parcelas;
    }

    public List<Crediario> findAll_CrediarioData(String inicio, String fim) {
        List<Crediario> crediario = new ArrayList<>();
        String sql = "SELECT * FROM vw_movimento WHERE data_pago >= ? and data_pago <= ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, inicio);
            stmt.setString(2, fim);
            rs = stmt.executeQuery();
            int movimento = -1;
            while (rs.next()) {
                if (rs.isFirst()) {
                    movimento = rs.getInt("movimento");
                    Crediario c = new Crediario(rs.getInt("movimento"), CDate.DataMySQLtoDataStringPT(rs.getString("data_pago")), Conv.CDblDuasCasas(rs.getDouble("crediario")));
                    crediario.add(c);
                } else if (rs.getInt("movimento") != movimento) {
                    Crediario c = new Crediario(rs.getInt("movimento"), CDate.DataMySQLtoDataStringPT(rs.getString("data_pago")), Conv.CDblDuasCasas(rs.getDouble("crediario")));
                    crediario.add(c);
                    movimento = rs.getInt("movimento");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venda_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return crediario;
    }
}
