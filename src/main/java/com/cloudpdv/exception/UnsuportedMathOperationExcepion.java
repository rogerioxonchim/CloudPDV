/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cloudpdv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Rogério Xonchim Alves Correa
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationExcepion extends RuntimeException{

    public UnsuportedMathOperationExcepion(String exception) {
        super(exception);
    }
}
