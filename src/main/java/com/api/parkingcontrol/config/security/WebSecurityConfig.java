package com.api.parkingcontrol.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // Para mostrar ao Spring que é uma classe de configuração
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { //Para fazer configurações customizadas de configuração

    //Onde vamos receber solicitações Http, onde podemos criar restrições para determinadas solicitações
    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic(). //Http basico
                and(). // e
                authorizeRequests(). //Autorização de requisições
                anyRequest().permitAll(); //Para qualquer requisição, vamos permitir todos os acessos
    }
}
