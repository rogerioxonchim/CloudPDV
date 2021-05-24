package com.cloudpdv.config;

import com.cloudpdv.seguranca.JwtConfigurer;
import com.cloudpdv.seguranca.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Bean
    public StandardPasswordEncoder passwordEncoder() {
        StandardPasswordEncoder bCryptPasswordEncoder = new StandardPasswordEncoder("secretKey");
        return bCryptPasswordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin", "/api-docs/**", "/swagger-ui.html**").permitAll()
                .antMatchers("/no-auth/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/api/v1/auth/**").authenticated()
                .antMatchers("/users").denyAll()
                .and()
                .apply(new JwtConfigurer(tokenProvider));
    }

}
