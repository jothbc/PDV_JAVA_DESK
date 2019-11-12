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
public class POS_Bean {
    private int seq_ini;
    private int seq_final;
    private int movimento;
    private List<Parcela> parcela;
    private double total;

    public POS_Bean() {
        parcela = new ArrayList<>();
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
     * @return the parcela
     */
    public List<Parcela> getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(List<Parcela> parcela) {
        this.parcela = parcela;
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
    
    public void addParcela(String dataPT,double valor){
        this.parcela.add(new Parcela(dataPT,valor));
    }

    /**
     * @return the seq_ini
     */
    public int getSeq_ini() {
        return seq_ini;
    }

    /**
     * @param seq_ini the seq_ini to set
     */
    public void setSeq_ini(int seq_ini) {
        this.seq_ini = seq_ini;
    }

    /**
     * @return the seq_final
     */
    public int getSeq_final() {
        return seq_final;
    }

    /**
     * @param seq_final the seq_final to set
     */
    public void setSeq_final(int seq_final) {
        this.seq_final = seq_final;
    }
}
