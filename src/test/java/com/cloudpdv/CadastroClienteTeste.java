/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv;

import com.cloudpdv.entidade.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.cloudpdv.service.ClienteServices;
import com.cloudpdv.vo.server.v1.ClienteVO;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroClienteTeste {

    @Autowired
    private ClienteServices clienteServices;

    @Test
    public void testarCadastro() {
        // ====================== CENÁRIO ============================
        List<ClienteVO> clientesVO = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            ClienteVO clienteVO = new ClienteVO(
                    Long.valueOf(i),
                    1L,
                    1L,
                    "Rogério " + i,
                    "XXXXXXXXXXX",
                    "XXXX",
                    "TESTE JUNIT",
                    "ENDERECO",
                    "NENDERECO",
                    "BAIRRO",
                    "CCOMPLEMENTO",
                    "CEP",
                    "(18) 1234-1234",
                    "(18) 99898-9898",
                    "CONTATO",
                    "GUARARAPES");

            clientesVO.add(clienteVO);
        }

//        List<ClienteVO> clientesVO = new ArrayList<>();
//        clientesVO.add(clienteVO);
//        clientesVO.add(clienteVO2);
        // ====================== AÇÃO =================================
        for (ClienteVO clienteVO : clientesVO) {
            Cliente cliente = clienteServices.create(clienteVO);
        }

        Sort.Direction sortDirection = "desc".equalsIgnoreCase("desNome") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(0, 12, Sort.by(sortDirection, "desNome"));

        List<ClienteVO> clientes = clienteServices.findAll(pageable).getContent();

        // ====================== VALIDAÇÃO ============================
        for (ClienteVO cliente : clientes) {
            assertThat(cliente).isNotNull();
            assertThat(cliente.getCodInterno()).isNotNull();
        }
        assertThat(clientes.get(0).getDesNome()).isEqualTo(clientesVO.get(0).getDesNome());
        assertThat(clientes.get(0).getDesNome()).isEqualTo(clientesVO.get(1).getDesNome());
    }

}
