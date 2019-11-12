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
public class Caixa_Bean {
    private int seq;
    private Usuario_Bean usuario;
    private double fundo;
    private double dinheiro;
    private double credito;
    private double debito;
    private double crediario;
    private double sangria;
    private double suprimento;

    private int movimento_inicial;
    private int movimento_final;
    private String data;
    private boolean situacao;
    private String ip;

    /**
     * @return the usuario
     */
    public Usuario_Bean getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario_Bean usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fundo
     */
    public double getFundo() {
        return fundo;
    }

    /**
     * @param fundo the fundo to set
     */
    public void setFundo(double fundo) {
        this.fundo = fundo;
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
     * @return the credito
     */
    public double getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito) {
        this.credito = credito;
    }

    /**
     * @return the debito
     */
    public double getDebito() {
        return debito;
    }

    /**
     * @param debito the debito to set
     */
    public void setDebito(double debito) {
        this.debito = debito;
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

    /**
     * @return the sangria
     */
    public double getSangria() {
        return sangria;
    }

    /**
     * @param sangria the sangria to set
     */
    public void setSangria(double sangria) {
        this.sangria = sangria;
    }

    /**
     * @return the suprimento
     */
    public double getSuprimento() {
        return suprimento;
    }

    /**
     * @param suprimento the suprimento to set
     */
    public void setSuprimento(double suprimento) {
        this.suprimento = suprimento;
    }

    /**
     * @return the movimento_inicial
     */
    public int getMovimento_inicial() {
        return movimento_inicial;
    }

    /**
     * @param movimento_inicial the movimento_inicial to set
     */
    public void setMovimento_inicial(int movimento_inicial) {
        this.movimento_inicial = movimento_inicial;
    }

    /**
     * @return the movimento_final
     */
    public int getMovimento_final() {
        return movimento_final;
    }

    /**
     * @param movimento_final the movimento_final to set
     */
    public void setMovimento_final(int movimento_final) {
        this.movimento_final = movimento_final;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the situacao
     */
    public boolean isSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

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
    
}
