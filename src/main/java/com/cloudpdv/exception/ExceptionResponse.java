/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Rogério Xonchim Alves Correa
 */
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    @Getter
    @Setter
    private Date timestamp;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String details;

}
