/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.converter;

import com.cloudpdv.entidade.User;
import com.cloudpdv.vo.server.v1.UserVO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@Service
public class UserConverter {

    public UserVO convertEntityToVO(User entity) {
        UserVO vo = new UserVO();
        vo.setIdUsuario(entity.getId());
        vo.setUserName(entity.getUsername());
        vo.setPassword(entity.getPassword());
        vo.setEmpresa(entity.getEmpresa());
        vo.setLoja(entity.getLoja());
        return vo;
    }
    
     public User convertVoToEntity(UserVO vo) {
        User entity = new User();
        entity.setId(vo.getIdUsuario());
        entity.setUserName(vo.getUserName());
        entity.setPassword(vo.getPassword());
        entity.setEmpresa(vo.getEmpresa());
        entity.setLoja(vo.getLoja());
        return entity;
    }
}
