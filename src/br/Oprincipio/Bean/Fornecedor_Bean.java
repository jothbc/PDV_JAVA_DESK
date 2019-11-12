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
public class Fornecedor_Bean {

    private int id;
    private String nome;
    private int chave;
    private List<Banco_Bean> banco;
    private String cnpj;
    private String cpf;
    private String telefone;
    private String email;
    private String ie;

    public Fornecedor_Bean() {
        banco = new ArrayList<>();
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
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the chave
     */
    public int getChave() {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(int chave) {
        this.chave = chave;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public boolean areInfo() {
        return (getCnpj() != null || getCpf() != null || getTelefone() != null || getEmail() != null);
    }

    /**
     * @return the banco
     */
    public List<Banco_Bean> getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(List<Banco_Bean> banco) {
        this.banco = banco;
    }

    public void addBanco(Banco_Bean b) {
        banco.add(b);
    }

    public void removeBanco(Banco_Bean b) {
        banco.remove(b);
    }
    public String toString(){
        return ("Nome: "+this.nome+ "\nChave: "+this.chave+"\nId: "+id+"\nQuantidade de bancos: "+this.banco.size()+"\n");
    }

    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
    }
}
