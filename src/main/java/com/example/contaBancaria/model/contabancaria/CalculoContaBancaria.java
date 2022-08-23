package com.example.contaBancaria.model.contabancaria;

import com.example.contaBancaria.model.ContaBancariaModel;

import java.math.BigDecimal;

public interface CalculoContaBancaria {

    public BigDecimal calculoDeTransacoes(ContaBancariaModel contaBancariaModel);
}
