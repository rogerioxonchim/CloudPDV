/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.controller.v1;


import com.cloudpdv.entidade.Cliente;
import com.cloudpdv.entidade.User;
import com.cloudpdv.service.ClienteServices;
import com.cloudpdv.service.UserServices;
import com.cloudpdv.vo.server.v1.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@Api(value = "Cliente EndPoint", description = "Descricao para Cliente", tags = {"ClienteEndPoint"})
@RestController
@RequestMapping("/api/v1/auth/clientes")
public class ClienteController {

    @Autowired
    private ClienteServices services;

    @Autowired
    private UserServices userServices;

    @Autowired
    private PagedResourcesAssembler<ClienteVO> vo;

    @ApiOperation(value = "Listar todos clientes")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> findAll(
            @RequestHeader("Authorization") String Bearer,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "1500") int limit,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "desNome"));

        Page<ClienteVO> list = services.findAll(pageable);
        list.stream()
                .forEach(c -> c.add(linkTo(methodOn(ClienteController.class).findById(c.getIdCliente())).withSelfRel())
                );

        PagedResources<?> resources = vo.toResource(list);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @ApiOperation(value = "Buscar cliente por parametro")
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ClienteVO findById(
            @PathVariable("id") Long id) {
        ClienteVO entityVO = services.findByID(id);
        entityVO.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
        return services.findByID(id);
    }

    @ApiOperation(value = "Buscar cliente por documento")
    @GetMapping(value = "/documento/{documento}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ClienteVO findEntityByDocumento(
            @RequestHeader("Authorization") String Bearer,
            @PathVariable("documento") String documento) {
        User user = userServices.getUser(Bearer);
        ClienteVO entityVO = services.findEntityByDocumento(documento, user.getEmpresa(), user.getLoja());
        entityVO.add(linkTo(methodOn(ClienteController.class).findById(entityVO.getIdCliente())).withSelfRel());
        return services.findByID(entityVO.getIdCliente());
    }

    @ApiOperation(value = "create clinte")
    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ClienteVO create(
            @RequestHeader("Authorization") String Bearer,
            @RequestBody ClienteVO vo) {
        User user = userServices.getUser(Bearer);

        Cliente entity = services.create(vo, user.getEmpresa(), user.getLoja());
        if (entity != null) {
            entity.add(linkTo(methodOn(ClienteController.class).findById(entity.getIdCliente())).withSelfRel());
            return services.convertToEntityVO(entity);
        } else {
            return null;
        }
    }
}
