/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.vo.server.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@EqualsAndHashCode(callSuper = false)
public class ClienteVO extends ResourceSupport implements Serializable {

    @Setter
    @Getter
    private Long idCliente;

    
    @JsonProperty("codigo_interno")
    @Getter
    @Setter
    private Long codInterno;

    @JsonIgnore
    @Getter
    @Setter
    private Long empresa;

    @JsonIgnore
    @Getter
    @Setter
    private Long loja;

    @JsonProperty("nome")
    @Getter
    @Setter
    private String desNome;

    @JsonProperty("cpf")
    @Getter
    @Setter
    private String numCPF;

    @JsonProperty("rg")
    @Getter
    @Setter
    private String numRG;

    @JsonProperty("observacao")
    @Getter
    @Setter
    private String desObservacao;

    @Getter
    @Setter
    private String desEndereco;

    @Getter
    @Setter
    private String numEndereco;

    @Getter
    @Setter
    private String desBairro;

    @Getter
    @Setter
    private String desComplemento;

    @Getter
    @Setter
    private String numCep;

    @Getter
    @Setter
    private String numFone;

    @Getter
    @Setter
    private String numCelular;

    @Getter
    @Setter
    private String desContato;

    @Getter
    @Setter
    private String cidade;

    @Getter
    @Setter
    private double valLimiteCredito = 0;

    public ClienteVO(Long codInterno, Long empresa, Long loja, String desNome, String numCPF, String numRG, String desObservacao, String desEndereco, String numEndereco, String desBairro, String desComplemento, String numCep, String numFone, String numCelular, String desContato, String cidade) {
        this.codInterno = codInterno;
        this.empresa = empresa;
        this.loja = loja;
        this.desNome = desNome;
        this.numCPF = numCPF;
        this.numRG = numRG;
        this.desObservacao = desObservacao;
        this.desEndereco = desEndereco;
        this.numEndereco = numEndereco;
        this.desBairro = desBairro;
        this.desComplemento = desComplemento;
        this.numCep = numCep;
        this.numFone = numFone;
        this.numCelular = numCelular;
        this.desContato = desContato;
        this.cidade = cidade;
    }

    public ClienteVO() {
    }

    @Override
    public String toString() {
        return "ClienteVO{" + "idCliente=" + idCliente + ", codInterno=" + codInterno + ", empresa=" + empresa + ", loja=" + loja + ", desNome=" + desNome + ", numCPF=" + numCPF + ", numRG=" + numRG + ", desObservacao=" + desObservacao + ", desEndereco=" + desEndereco + ", numEndereco=" + numEndereco + ", desBairro=" + desBairro + ", desComplemento=" + desComplemento + ", numCep=" + numCep + ", numFone=" + numFone + ", numCelular=" + numCelular + ", desContato=" + desContato + ", cidade=" + cidade + ", valLimiteCredito=" + valLimiteCredito + '}';
    }

}
