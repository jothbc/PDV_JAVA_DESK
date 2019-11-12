/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

/**
 *
 * @author User
 */
public class Produto_Bean {

    private int id;
    private String codigo;
    private String descricao;
    private double custo;
    private double margem;
    private double venda;
    private double estoque;
    private double estoque_min;
    private double quantidade;
    private boolean cancelado;
    public Produto_Bean() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) throws Exception {
        if (codigo.equals("") || codigo == null) {
            throw new Exception("O Produto necessita de um código!");
        }
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        if (descricao.equals("")) {
            this.descricao = null;
        } else {
            this.descricao = descricao;
        }
    }

    /**
     * @return the custo
     */
    public double getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }

    /**
     * @return the margem
     */
    public double getMargem() {
        return margem;
    }

    /**
     * @param margem the margem to set
     */
    public void setMargem(double margem) {
        this.margem = margem;
    }

    /**
     * @return the venda
     */
    public double getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(double venda) {
        this.venda = venda;
    }

    /**
     * @return the estoque
     */
    public double getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the estoque_min
     */
    public double getEstoque_min() {
        return estoque_min;
    }

    /**
     * @param estoque_min the estoque_min to set
     */
    public void setEstoque_min(double estoque_min) {
        this.estoque_min = estoque_min;
    }

    public double getQuantidade() {
        return quantidade;
    }

    

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the cancelado
     */
    public boolean isCancelado() {
        return cancelado;
    }

    /**
     * @param cancelado the cancelado to set
     */
    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    

}
