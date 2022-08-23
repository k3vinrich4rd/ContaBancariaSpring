package com.example.contaBancaria.model.contabancaria;

public class ContaBancariaFactory {

    public static CalculoContaBancaria tipoDeServico(String tipoDeServico) {
        if (tipoDeServico.equalsIgnoreCase("SAQUE")) {
            return new Saque();
        } else if (tipoDeServico.equalsIgnoreCase("DEPOSITO")) {
            return new Deposito();
        } else {
            return null;
        }
    }
}
