package com.example.contaBancaria.controller;

import com.example.contaBancaria.model.ContaBancariaModel;
import com.example.contaBancaria.model.contabancaria.ContaBancariaFactory;
import com.example.contaBancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contasbancarias")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public ResponseEntity<List<ContaBancariaModel>> buscarTodasAsContas() {
        return ResponseEntity.ok(contaBancariaService.buscarContasBancarias());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ContaBancariaModel>> buscarContaBancariaViaId(@PathVariable Long id) {

        return ResponseEntity.ok(contaBancariaService.mostrarContasBancariasViaId(id));
    }

    @PostMapping
    public ResponseEntity<ContaBancariaModel> cadastrarRegistroContasBancarias(@RequestBody ContaBancariaModel contaBancariaModel, ContaBancariaFactory contaBancariaFactory) {
        ContaBancariaModel contaBancaria = contaBancariaService.cadastrarRegistrosDaConta(contaBancariaModel, contaBancariaFactory);
        return new ResponseEntity<>(contaBancaria, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContaBancariaModel> alterarRegistrosContaBancaria(@RequestBody ContaBancariaModel contaBancariaModel, ContaBancariaFactory contaBancariaFactory) {
        return ResponseEntity.ok(contaBancariaService.alterarRegistrosDaConta(contaBancariaModel, contaBancariaFactory));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarContasBancarias(@PathVariable Long id) {
        contaBancariaService.deletarContaBancaria(id);
    }

}
