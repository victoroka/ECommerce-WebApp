/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.model.javabeans;

import java.util.Date;

/**
 *
 * @author VictorOka
 */
public class Boleto extends Pagamento {
    
    private long numeroBoleto;
    private Date dataVencimento;
    private Date dataEmissao;

    public Boleto(long numeroBoleto, Date dataVencimento, Date dataEmissao, double amount) {
        super(amount);
        this.numeroBoleto = numeroBoleto;
        this.dataVencimento = dataVencimento;
        this.dataEmissao = dataEmissao;
    }

    public long getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(long numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @Override
    public String toString() {
        return "Boleto{" + "numeroBoleto=" + numeroBoleto + ", dataVencimento=" + dataVencimento + ", dataEmissao=" + dataEmissao + '}';
    }
    
}
