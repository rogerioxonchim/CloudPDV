package com.cloudpdv.service;

import com.cloudpdv.converter.UserConverter;
import com.cloudpdv.dao.UserRepository;
import com.cloudpdv.entidade.User;
import com.cloudpdv.seguranca.JwtTokenProvider;
import com.cloudpdv.seguranca.VO.AccountCredentialsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Autowired
    private UserConverter converter;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado.");
        }
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public User getUser(String token) {
        try {
            token = token.substring(7, token.length());
            if (token != null && tokenProvider.validateToken(token)) {
                Authentication auth = tokenProvider.getAuthentication(token);
                if (auth != null) {
                    return (User) auth.getPrincipal();
                }
            }
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
        return null;
    }

    public User getUsuario(String usuario) {
        try {
            User user = repository.findByUsername(usuario);
            if (user != null) {
                return user;
            } else {
                throw new UsernameNotFoundException("Usuário " + usuario + " não encontrado.");
            }
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    public User getLogin(String usuario, String password) {
        try {
            User user = repository.findByLogin(usuario, password);
            if (user != null) {
                return user;
            } else {
                throw new UsernameNotFoundException("Usuário " + usuario + " não encontrado.");
            }
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    public User getUser(@RequestBody AccountCredentialsVO data) {
        try {
            User user = repository.findByUsername(data.getUsername());
            if (user != null) {
                return user;
            } else {
                throw new UsernameNotFoundException("Usuário " + data.getUsername() + " não encontrado.");
            }
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
