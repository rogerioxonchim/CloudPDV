package com.cloudpdv.seguranca.VO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private Long caixa;
}
