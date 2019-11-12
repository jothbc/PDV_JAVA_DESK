/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

import funcoes.CDate;
import funcoes.Conv;
import java.util.Date;

/**
 *
 * @author User
 */
public class Cliente_Bean {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private double crediario;
    private String aniversario;
    private double credito;

    public static final String BR = "BR";
    public static final String SQL = "SQL";

    public Cliente_Bean() {
    }

    
    public Cliente_Bean(String nome) {
        this.nome = nome;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     * @throws java.lang.Exception
     */
    public void setNome(String nome) throws Exception {
        if (nome.equals("")) {
            throw new Exception("É necessário um Nome de Cliente.");
        }
        this.nome = nome.toUpperCase();
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the crediario
     */
    public double getCrediario() {
        return Conv.CDblDuasCasas(crediario);
    }

    /**
     * @param crediario the crediario to set
     */
    public void setCrediario(double crediario) {
        this.crediario = Conv.CDblDuasCasas(crediario);
    }

    public String getAniversario(String tipo) {
        if (this.aniversario == null) {
            return null;
        }
        if (tipo.equals(BR)) {
            return CDate.DataMySQLtoDataStringPT(this.aniversario);
        } else if (tipo.equals(SQL)) {
            return this.aniversario;
        }
        return null;
    }

    /**
     *
     * @return a type date of aniversario
     * @throws Exception
     */
    public Date getAniversarioDate() {
        try {
            return CDate.DataPTBRStringToDate(CDate.DataMySQLtoDataStringPT(this.aniversario));
        } catch (Exception ex) {
            return null;
        }
    }

    public void setAniversario(String aniversario, String tipo) {
        if (tipo.equals(BR)) {
            this.aniversario = CDate.DataPTBRtoDataMySQL(aniversario);
        } else if (tipo.equals(SQL)) {
            this.aniversario = aniversario;
        } else {
            this.aniversario = null;
        }
    }

    public void addCrediario(double valor) {
        this.crediario += Conv.CDblDuasCasas(valor);
    }

    public void removeCrediario(double valor) {
        this.crediario -= Conv.CDblDuasCasas(valor);
    }

    /**
     * @return the credito
     */
    public double getCredito() {
        return Conv.CDblDuasCasas(credito);
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito) {
        this.credito = Conv.CDblDuasCasas(credito);
    }

    public void addCredito(double credito) {
        this.credito += Conv.CDblDuasCasas(credito);
    }

    public void removeCredito(double credito) {
        this.credito -= Conv.CDblDuasCasas(credito);
    }

    public String aniversarioHoje() {
        return "Cliente: " + this.nome + " faz Aniversário HOJE!";
    }
}
