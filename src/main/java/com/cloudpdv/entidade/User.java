package com.cloudpdv.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Entity
@Table(name = "tb_usuario")
@EqualsAndHashCode
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @Setter
    @Getter
    private Long id;

    @Column(name = "des_email", unique = true)
    @Getter
    @Setter
    private String userName;

    @Column(name = "des_senha", length = 65)
    @Getter
    @Setter
    private String password;

    @Transient
    @Getter
    @Setter
    private Boolean accountNonExpired = true;

    @Transient
    @Getter
    @Setter
    private Boolean accountNonLocked = true;

    @Transient
    @Getter
    @Setter
    private Boolean credentialsNonExpired = true;

    @Transient
    @Getter
    @Setter
    private Boolean enabled = true;

    @Column(name = "cod_empresa")
    @Getter
    @Setter
    private Long empresa;

    @Column(name = "cod_loja")
    @Getter
    @Setter
    private Long loja;

    @Transient
    @Getter
    @Setter
    private List<Permission> permissions;

    public List<String> getRoles() {
        Permission permission = new Permission();
        permissions = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");

        permission.setId(1L);
        permission.setDescription("ADMIN");
        permissions.add(permission);

        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.permissions;
    }

    @Override
    public String getPassword() {
        try {
            StandardPasswordEncoder bCryptPasswordEncoder = new StandardPasswordEncoder("secretKey");
            String result = bCryptPasswordEncoder.encode(password);
            return result;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return password;
        }
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
