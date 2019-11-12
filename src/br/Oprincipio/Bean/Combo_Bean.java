/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Combo_Bean {

    private int id;
    private String cd;
    private String descricao;
    private double margem;
    private double valor;
    private List<Produto_Bean> produtos;
    private double qtd;

    public Combo_Bean() {
        produtos = new ArrayList<>();
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
     * @return the cd
     */
    public String getCd() {
        return cd;
    }

    /**
     * @param cd the cd to set
     */
    public void setCd(String cd) {
        this.cd = cd;
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
        this.descricao = descricao;
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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the produtos
     */
    public List<Produto_Bean> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto_Bean> produtos) {
        this.produtos = produtos;
    }
    
    public void addProduto(Produto_Bean produto){
        this.produtos.add(produto);
    }

    
    
    public String toString(){
        String prod = "";
        for (Produto_Bean p:this.getProdutos()){
            prod+="Descrição = "+p.getDescricao()+"\nQTD = "+p.getQuantidade()+"\n";
        }
        return this.getDescricao()+"\nItens Pertencentes a 1(um) Combo: \n"+prod;
    }
}
