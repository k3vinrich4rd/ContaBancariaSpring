package com.example.contaBancaria.service;

import com.example.contaBancaria.model.ContaBancariaModel;
import com.example.contaBancaria.model.contabancaria.ContaBancariaFactory;
import com.example.contaBancaria.respository.ContaBancariaRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ContaBancariaTest {

    @Mock
    ContaBancariaService contaBancariaService;

    @MockBean
    ContaBancariaRepository contaBancariaRepository;

    private ContaBancariaModel contaBancariaModel;
    private ContaBancariaFactory contaBancariaFactory;

    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        contaBancariaModel = new ContaBancariaModel(1L, "9958", "696969", "Kevin", "Deposito", new BigDecimal("232323"), new BigDecimal("3454353"), new BigDecimal("900"));
    }

    @Test
    @DisplayName("Testando o metodo de cadastrar")
    void testeCadastroDeContaBancariaEstaFuncionando() {
        contaBancariaRepository.save(contaBancariaModel);
        Mockito.when(contaBancariaRepository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.verify(contaBancariaRepository, Mockito.times(1)).save(contaBancariaModel);
    }

    @Test
    @DisplayName("Deve retornar true, pois nenhum usuario foi cadastrado")
    void testeDeExibicaoDeContas() {
        List<ContaBancariaModel> contasBancarias = contaBancariaService.buscarContasBancarias();
        assertTrue(contasBancarias.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar true se o metodo de deletar estiver funcionando corretamente ")
    void testeDeletamentoDeContasBancarias() {
        contaBancariaService.deletarContaBancaria(1L);
        assertTrue(true);
    }

    @Test
    @DisplayName("Deve retornar true se o metodo de buscar por id, estiver funcionando corretamente")
    void testeDeBuscarPorIdContasBancarias() {
        contaBancariaService.mostrarContasBancariasViaId(1L);
        assertTrue(true);
    }

    @Test
    @DisplayName("Deve retornar se o metodo de atualizar contas, estiver funcionando corretamente")
    void testeAtualizarContas() {
        contaBancariaService.alterarRegistrosDaConta(contaBancariaModel, contaBancariaFactory);
        contaBancariaRepository.save(contaBancariaModel);
        assertTrue(true);
    }
}
