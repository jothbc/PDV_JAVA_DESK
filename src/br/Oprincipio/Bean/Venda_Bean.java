/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

import java.util.List;

/**
 *
 * @author User
 */
public class Venda_Bean {

    private int seq;
    private int movimento;
    private Cliente_Bean cliente;
    private List<Produto_Bean> produtos;

    private double total;
    private double troco;
    private double dinheiro;
    private double POS_credito;
    private double POS_debito;
    private double crediario;
    private POS_Bean pos;

    private double desconto;
    private String data;
    private boolean pago;
    private String data_pago;

    /**
     * @return the seq
     */
    public int getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * @return the movimento
     */
    public int getMovimento() {
        return movimento;
    }

    /**
     * @param movimento the movimento to set
     */
    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    /**
     * @return the cliente
     */
    public Cliente_Bean getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente_Bean cliente) {
        this.cliente = cliente;
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

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the troco
     */
    public double getTroco() {
        return troco;
    }

    /**
     * @param troco the troco to set
     */
    public void setTroco(double troco) {
        this.troco = troco;
    }

    /**
     * @return the dinheiro
     */
    public double getDinheiro() {
        return dinheiro;
    }

    /**
     * @param dinheiro the dinheiro to set
     */
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    /**
     * @return the POS_credito
     */
    public double getPOS_credito() {
        return POS_credito;
    }

    /**
     * @param POS_credito the POS_credito to set
     */
    public void setPOS_credito(double POS_credito) {
        this.POS_credito = POS_credito;
    }

    /**
     * @return the POS_debito
     */
    public double getPOS_debito() {
        return POS_debito;
    }

    /**
     * @param POS_debito the POS_debito to set
     */
    public void setPOS_debito(double POS_debito) {
        this.POS_debito = POS_debito;
    }

    /**
     * @return the crediario
     */
    public double getCrediario() {
        return crediario;
    }

    /**
     * @param crediario the crediario to set
     */
    public void setCrediario(double crediario) {
        this.crediario = crediario;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean isPago() {
        return pago;
    }

    /**
     * @return the pos
     */
    public POS_Bean getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(POS_Bean pos) {
        this.pos = pos;
    }

    /**
     * @return the data_pago
     */
    public String getData_pago() {
        return data_pago;
    }

    /**
     * @param data_pago the data_pago to set
     */
    public void setData_pago(String data_pago) {
        this.data_pago = data_pago;
    }

}
