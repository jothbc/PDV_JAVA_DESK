/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

import funcoes.CDate;
import funcoes.Conv;

/**
 *
 * @author User
 */
public class Conta_Bean {

    private int id;
    private String descricao;
    private double valor;
    private String vencimento;
    private String pago;

    public final static int BR = 1;
    public final static int SQL = 2;

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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = Conv.CDblDuasCasas(valor);
    }

    /**
     * @return the vencimento
     */
    public String getVencimento(int op) {
        if (vencimento == null) {
            return null;
        }
        if (op == BR) {
            return vencimento;
        } else if (op == SQL) {
            return CDate.DataPTBRtoDataMySQL(vencimento);
        }
        return null;
    }

    /**
     * @param vencimento the vencimento to set Passar data em String no formado
     * PT-BR
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the pago
     */
    public String getPago(int op) {
        if (pago == null) {
            return null;
        }
        if (op == BR) {
            return pago;
        } else if (op == SQL) {
            return CDate.DataPTBRtoDataMySQL(pago);
        }
        return null;
    }

    /**
     * @param pago the pago to set Passar data em String no formado PT-BR
     */
    public void setPago(String pago) {
        this.pago = pago;
    }
}
