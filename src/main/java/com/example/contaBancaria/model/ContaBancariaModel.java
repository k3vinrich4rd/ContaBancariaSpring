package com.example.contaBancaria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registro_conta_bancaria")
public class ContaBancariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_da_conta", length = 100, nullable = false)
    private String numeroDaConta;

    @Column(name = "agencia_da_conta", length = 100, nullable = false)
    private String agencia;

    @Column(name = "nome_do_usuario_da_conta", length = 100, nullable = false)
    private String nomeDoUsuario;

    @Column(name = "tipo_de_servico", length = 100, nullable = false)
    private String tipoDeServico;

    @Column(name = "valor_atual_da_conta", length = 100, nullable = false)
    private BigDecimal valorAtualDaConta;

    @Column(name = "valor_fornecido_saque_deposito", length = 100, nullable = false)
    private BigDecimal valorFonercidoSaqueDeposito;

    @Column(name = "valor_final_da_conta", length = 100)
    private BigDecimal valorFinal;


}
