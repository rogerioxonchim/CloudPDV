/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@Entity
@Table(name = "tb_cliente")
public class Cliente extends ResourceSupport implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long idCliente;

    @Column(name = "cod_interno", nullable = true, unique = false)
    @Getter
    @Setter
    private Long codInterno;

    @Column(name = "cod_empresa", nullable = true, unique = false)
    @Getter
    @Setter
    private Long empresa;

    @Column(name = "cod_loja", nullable = true, unique = false)
    @Getter
    @Setter
    private Long loja;

    @Column(name = "des_nome", length = 200)
    @Getter
    @Setter
    private String desNome;

    @Column(name = "num_cpf", length = 20)
    @Getter
    @Setter
    private String numCPF;

    @Column(name = "num_rg", length = 20)
    @Getter
    @Setter
    private String numRG;

    @Column(name = "des_observacao", length = 5000)
    @Getter
    @Setter
    private String desObservacao;

    //ENDERECO
    @Column(name = "des_endereco", length = 250)
    @Getter
    @Setter
    private String desEndereco;

    @Column(name = "num_endereco", length = 10)
    @Getter
    @Setter
    private String numEndereco;

    @Column(name = "des_bairro", length = 50)
    @Getter
    @Setter
    private String desBairro;

    @Column(name = "des_complemento", length = 50)
    @Getter
    @Setter
    private String desComplemento;

    @Column(name = "num_cep", length = 10)
    @Getter
    @Setter
    private String numCep;

    @Column(name = "num_telefone", length = 20)
    @Getter
    @Setter
    private String numFone;

    @Column(name = "num_celular", length = 20)
    @Getter
    @Setter
    private String numCelular;

    @Column(name = "des_contato", length = 50)
    @Getter
    @Setter
    private String desContato;

    @Column(name = "des_cidade", length = 100)
    @Getter
    @Setter
    private String cidade;

    @Column(name = "val_limite_credito", precision = 10, scale = 2)
    @Getter
    @Setter
    private double valLimiteCredito = 0;

}
