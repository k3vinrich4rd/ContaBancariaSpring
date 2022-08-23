package com.example.contaBancaria.service;

import com.example.contaBancaria.model.ContaBancariaModel;
import com.example.contaBancaria.model.contabancaria.ContaBancariaFactory;
import com.example.contaBancaria.respository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancariaModel> buscarContasBancarias() {
        return contaBancariaRepository.findAll();
    }

    public Optional<ContaBancariaModel> mostrarContasBancariasViaId(Long id) {
        return contaBancariaRepository.findById(id);
    }

    public ContaBancariaModel cadastrarRegistrosDaConta(ContaBancariaModel contaBancariaModel, ContaBancariaFactory contaBancariaFactory) {
        BigDecimal resultado = ContaBancariaFactory.tipoDeServico(contaBancariaModel.getTipoDeServico()).calculoDeTransacoes(contaBancariaModel);
        contaBancariaModel.setValorFinal(resultado);

        return contaBancariaRepository.save(contaBancariaModel);
    }

    public ContaBancariaModel alterarRegistrosDaConta(ContaBancariaModel contaBancariaModel, ContaBancariaFactory contaBancariaFactory) {
        BigDecimal resultado = ContaBancariaFactory.tipoDeServico(contaBancariaModel.getTipoDeServico()).calculoDeTransacoes(contaBancariaModel);
        contaBancariaModel.setValorFinal(resultado);

        return contaBancariaRepository.save(contaBancariaModel);
    }

    public void deletarContaBancaria(Long id) {
        contaBancariaRepository.deleteById(id);
    }


}

