/*
 * Copyright (c) 2019, Jonathan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package br.Oprincipio.DAO;

import br.Oprincipio.Bean.Cliente_Bean;
import br.Oprincipio.Bean.Historico_Cred;
import funcoes.CDate;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jonathan
 */
public class Historico_CredDAOTest {

    public Historico_CredDAOTest() {
    }

    @Test
    @Ignore
    public void addHistorico() {
        Historico_Cred hist = new Historico_Cred();
        hist.setCliente(new Cliente_Bean("jonathan"));
        hist.setData(CDate.DataPTBRAtual());
        hist.setValor(10);
        new Historico_CredDAO().addHist(hist);
    }
    
    @Test
    public void filtrarHistorico(){
        String inicio,fim;
        inicio= "08/11/2019";
        fim = "08/11/2019";
        List<Historico_Cred> hist = new Historico_CredDAO().getHistPeriodo(inicio, fim);
        for(Historico_Cred h:hist){
            System.out.println(h);
        }
    }

}
