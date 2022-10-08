package com.api.parkingcontrol.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration // Para mostrar ao Spring que é uma classe de configuração
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { //Para fazer configurações customizadas de configuração
    //O Spring Security já traz o Csrf habilitado, impossibilitando executar ações (Post e delete)


    final UserDetailsServiceImpl userDetailsService;
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override //Customizando as requisições HTTP
    //Onde vamos receber solicitações Http, onde podemos criar restrições para determinadas solicitações
    protected void configure(HttpSecurity http) throws Exception {
        http.
                // "**" em casos que temos de passar algum ‘id’ na url do método Http
                httpBasic()
                .and()
                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/parking-spot").hasRole("USER")
//                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")
                .anyRequest().authenticated() //Todas as solicitações Http precisam ser autenticadas
                .and()
                .csrf().disable(); //Desabilitando o csrf


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService) //Passando as configurações que fizemos na classe
                .passwordEncoder(passwordEncoder());/*
                Realizando a autenticação usando o userDetailsService e o passWordEncoder
                */
    }

    @Bean // Dá o controle para o Spring
    //Tratamento para criptografia
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
















































//        http
//                .httpBasic(). //Http basico
//                and(). // e
//                authorizeRequests(). //Autorização de requisições
//                anyRequest().permitAll(); //Para qualquer requisição, vamos permitir todos os acessos


//        //Autenticação em memória utilizando senha, username e roles (papeis)
//        //Com essa configuração a aplicação não gera mais um password do Spring Security
//        auth.inMemoryAuthentication()
//                .withUser("kevin")
//                .password(passwordEncoder().encode("1234"))
//                .roles("ADMIN");
//    }