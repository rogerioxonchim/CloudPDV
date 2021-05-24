/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.service;


import com.cloudpdv.converter.ClienteConverter;
import com.cloudpdv.dao.ClienteDAO;
import com.cloudpdv.entidade.Cliente;
import com.cloudpdv.exception.ResourceNotFoundException;
import com.cloudpdv.vo.server.v1.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@Service
public class ClienteServices {

    @Autowired
    private ClienteDAO dao;

    @Autowired
    private ClienteConverter converter;

    public Page<ClienteVO> findAll(Pageable pageable) {
        Page<Cliente> page = dao.findAll(pageable);
        return page.map(this::convertToEntityVO);
    }

    public ClienteVO findByID(Long id) {
        Cliente entity = dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID"));
        return converter.convertEntityToVO(entity);
    }

    public Cliente findEntityByID(Long id) {
        Cliente entity = dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse Id Cliente"));
        return entity;
    }

    public ClienteVO findEntityByDocumento(String documento, Long empresa, Long loja) {
        Cliente entity = dao.findByDocumento(documento, empresa, loja).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse Documento"));
        return converter.convertEntityToVO(entity);
    }

    public ClienteVO convertToEntityVO(Cliente entity) {
        return converter.convertEntityToVO(entity);
    }

    public Cliente create(ClienteVO vo, Long empresa, Long loja) {
        Cliente entity = converter.convertVOToEntity(vo);
        entity = dao.save(entity);
        return entity;
    }
    
    public Cliente create(ClienteVO vo) {
        Cliente entity = converter.convertVOToEntity(vo);
        entity = dao.save(entity);
        return entity;
    }
}
