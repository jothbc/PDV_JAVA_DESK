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
public class Usuario_Bean {
    private int id;
    private String nome;
    private String senha;
    private boolean privilegio;

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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the privilegio
     */
    public boolean isPrivilegio() {
        return privilegio;
    }

    /**
     * @param privilegio the privilegio to set
     */
    public void setPrivilegio(boolean privilegio) {
        this.privilegio = privilegio;
    }
    
}
