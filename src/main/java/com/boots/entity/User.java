package com.boots.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5, message = "Необходимо ввести не менее пяти символов") //ИМЯ ПОЛЬЗОВАТЕЛЯ
    private String username;
    @Size(min=5, message = "Необходимо ввести не менее пяти символов") //ПАРОЛЬ
    private String password;
    @Size(min=5, message = "Необходимо ввести не менее пяти символов") //ЗАЯВКА
    private String application;
    @Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    } //ИМЯ ПОЛЬЗОВАТЕЛЯ

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

    public void setUsername(String username) {
        this.username = username;
    } //ИМЯ ПОЛЬЗОВАТЕЛЯ

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    } //ПАРОЛЬ

    public void setPassword(String password) {
        this.password = password;
    } //ПАРОЛЬ

    public String getPasswordConfirm() {
        return passwordConfirm;
    } //ПАРОЛЬ

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    } //ПАРОЛЬ

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getApplication() {return application; } //ЗАЯВКА

    public void  setApplication(String application) {this.application = application; } //ЗАЯВКА
}
