package com.cloudpdv.vo.server.v1;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@EqualsAndHashCode(callSuper = false)
public class UserVO extends ResourceSupport implements Serializable {

    @Setter
    @Getter
    private Long idUsuario;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String nome;
    
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Long empresa;

    @Getter
    @Setter
    private Long loja;

}
