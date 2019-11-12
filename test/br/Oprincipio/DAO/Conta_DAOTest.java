/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import br.Oprincipio.Bean.Conta_Bean;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author User
 */
public class Conta_DAOTest {
    
    public Conta_DAOTest() {
    }

    @Test
    @Ignore
    public void addConta() {
        Conta_Bean conta = new Conta_Bean();
        conta.setDescricao("uma conta qualquer");
        conta.setValor(100);
        conta.setVencimento("23/05/2019");
        if (!new Conta_DAO().addConta(conta)){
            System.out.println("erro ao adicionar conta");
        }
    }
    
}
