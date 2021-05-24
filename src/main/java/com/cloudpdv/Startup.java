package com.cloudpdv;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableFeignClients
public class Startup extends SpringBootServletInitializer {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        SpringApplication.run(Startup.class, args);
    }

//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
//        String result = bCryptPasswordEncoder.encode("c4ca4238a0b923820dcc509a6f75849b");
//        System.out.println("My hash " + result);
//        
//        StandardPasswordEncoder bCryptPasswordEncoder = new StandardPasswordEncoder();
//        String result = bCryptPasswordEncoder.encode("c4ca4238a0b923820dcc509a6f75849b");
//        System.out.println("My hash " + result);
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(getClass());
    }
}
