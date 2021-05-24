/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cloudpdv.exception;

import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjectNotFoundException  extends RuntimeException implements Serializable{
    private static final long SerialVersionID = 1L;
    public ObjectNotFoundException(String message){
        super(message);
    }
}
