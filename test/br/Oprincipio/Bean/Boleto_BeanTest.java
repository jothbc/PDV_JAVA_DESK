/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Bean;

import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.TreeNode;
import org.apache.commons.collections.list.TreeList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author User
 */
public class Boleto_BeanTest {
    
    public Boleto_BeanTest() {
    }
    
    @Ignore
    @Test
    public void testSomeMethod() {
        try {
            Boleto_Bean b = new Boleto_Bean();
            b.setAll("836300000012723601620005001010201943700927829130");
            System.out.println(b.getValor());
        } catch (Exception ex) {
            Logger.getLogger(Boleto_BeanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void tree(){

    } 
}
