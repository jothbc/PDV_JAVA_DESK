/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

import funcoes.CDate;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Boleto_Bean {

    private int id;
    private Fornecedor_Bean fornecedor;
    private String cd_barras;
    private double valor;
    private String vencimento;
    private String pago;
    private int banco;

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
     * @return the cd_barras
     */
    public String getCd_barras() {
        return cd_barras;
    }

    /**
     * @param cd_barras the cd_barras to set
     * @throws java.lang.Exception
     */
    public void setAll(String cd_barras) throws Exception {
        if (cd_barras.length() == 48) {
            cd_barras = arrumar48_44(cd_barras);
            this.valor = Double.parseDouble(cd_barras.substring(5, 15)) / 100;
        } else {
            if (cd_barras.length() != 44 && cd_barras.length() != 47) {
                throw new Exception("Código de Barras Inválido!\nTamanho do código informado: " + cd_barras.length() + "\nEsperado: 44 ou 47");
            }
            if (cd_barras.length() == 47) {
                String temp = "";
                temp = temp + cd_barras.substring(0, 4);
                temp = temp + cd_barras.substring(32);
                temp = temp + cd_barras.substring(4, 9);
                temp = temp + cd_barras.substring(10, 20);
                temp = temp + cd_barras.substring(21, 31);
                cd_barras = temp;
            }
            this.valor = Double.parseDouble(cd_barras.substring(9, 19)) / 100;
        }
        this.banco = Integer.parseInt(cd_barras.substring(0, 3));
        this.vencimento = CDate.SomarData(Integer.parseInt(cd_barras.substring(5, 9)), CDate.InicialBanco());
        if (this.vencimento.equals(CDate.InicialBanco())) {
            JOptionPane.showMessageDialog(null, "Provavelmente não foi possível determinar o vencimento.\nPor favor verifique se o mesmo esta correto.");
        }
        if (this.valor == 0) {
            JOptionPane.showMessageDialog(null, "Não foi possivel determinar o valor.\nPor favor verifique o mesmo.");
        }
        this.cd_barras = cd_barras;
    }

    public void setCd_barras(String cd_barras) {
        this.cd_barras = cd_barras;
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
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the pago
     */
    public String getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(String pago) {
        this.pago = pago;
    }

    /**
     * @return the banco
     */
    public int getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(int banco) {
        this.banco = banco;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor_Bean getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor_Bean fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String arrumar48_44(String cd_barras) {
        String temp = "";
        char[] c = new char[48];
        for (int x = 0; x < 48; x++) {
            c[x] = cd_barras.charAt(x);
        }
        for (int x = 0; x < 48; x++) {
            if (x != 11 && x != 23 && x != 35 && x != 47) {
                temp += c[x];
            }
        }
        return temp;
    }
}
