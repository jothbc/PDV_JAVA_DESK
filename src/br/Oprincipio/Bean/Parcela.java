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
public class Parcela {
    private int mov;
    private String data;
    private double valor;

    public Parcela(String data, double valor) {
        this.data = data;
        this.valor = valor;
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
     * @return the mov
     */
    public int getMov() {
        return mov;
    }

    /**
     * @param mov the mov to set
     */
    public void setMov(int mov) {
        this.mov = mov;
    }
    
}
