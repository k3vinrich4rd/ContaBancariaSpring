package com.example.contaBancaria.model.contabancaria;

import com.example.contaBancaria.model.ContaBancariaModel;

import java.math.BigDecimal;

public class Deposito implements CalculoContaBancaria {
    @Override
    public BigDecimal calculoDeTransacoes(ContaBancariaModel contaBancariaModel) {
        return contaBancariaModel.getValorAtualDaConta().add(new BigDecimal(String.valueOf(contaBancariaModel.getValorFonercidoSaqueDeposito())));
    }
}
