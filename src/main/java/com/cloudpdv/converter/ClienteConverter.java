/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.converter;

import com.cloudpdv.entidade.Cliente;
import com.cloudpdv.vo.server.v1.ClienteVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@Service
public class ClienteConverter {

    private static final Logger logger = LogManager.getLogger(ClienteConverter.class);

    public ClienteVO convertEntityToVO(Cliente entity) {
        try {
            ClienteVO vo = new ClienteVO();
            vo.setCodInterno(entity.getCodInterno());
            vo.setDesNome(entity.getDesNome());
            vo.setNumCPF(entity.getNumCPF());
            vo.setNumRG(entity.getNumRG());
            vo.setEmpresa(entity.getEmpresa());
            vo.setLoja(entity.getLoja());
            vo.setDesBairro(entity.getDesBairro());
            vo.setDesComplemento(entity.getDesComplemento());
            vo.setDesEndereco(entity.getDesEndereco());            
            vo.setDesObservacao(entity.getDesObservacao());            
            vo.setNumCelular(entity.getNumCelular());
            vo.setNumCep(entity.getNumCep());
            vo.setNumEndereco(entity.getNumEndereco());
            vo.setNumFone(entity.getNumFone());            
            vo.setValLimiteCredito(entity.getValLimiteCredito());
            vo.setCidade(entity.getCidade());
            return vo;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }

    public Cliente convertVOToEntity(ClienteVO entitVO) {
        try {
            Cliente entity = new Cliente();
            entity.setCodInterno(entitVO.getCodInterno());
            entity.setDesNome(entitVO.getDesNome());
            entity.setNumCPF(entitVO.getNumCPF());
            entity.setNumRG(entitVO.getNumRG());
            entity.setEmpresa(entitVO.getEmpresa());
            entity.setLoja(entitVO.getLoja());
            entity.setDesBairro(entitVO.getDesBairro());
            entity.setDesComplemento(entitVO.getDesComplemento());
            entity.setDesEndereco(entitVO.getDesEndereco());            
            entity.setDesObservacao(entitVO.getDesObservacao());            
            entity.setNumCelular(entitVO.getNumCelular());
            entity.setNumCep(entitVO.getNumCep());
            entity.setNumEndereco(entitVO.getNumEndereco());
            entity.setNumFone(entitVO.getNumFone());            
            entity.setValLimiteCredito(entitVO.getValLimiteCredito());
            entity.setCidade(entitVO.getCidade());
            return entity;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }
}
