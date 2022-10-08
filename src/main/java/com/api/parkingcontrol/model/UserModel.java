package com.api.parkingcontrol.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USER") /*
/UserDetails, coloca a nossa aplicação que já está no Spring, na visão do Spring Security
possibilitando o e
*/
public class UserModel implements UserDetails, Serializable {//Relacionado a conversão de objetos java para bites para serem salvo no banco de dados
    private static final long serialVersionUID = 1L; //Controle das conversões feitas pela JVM

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //Evita conflitos em aplicações de microservices

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "TB_USERS_ROLES",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleModel> roles;


    @Override
    //Autoridade concedida
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
