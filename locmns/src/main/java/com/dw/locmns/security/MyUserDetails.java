package com.dw.locmns.security;

import com.dw.locmns.model.Utilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MyUserDetails  implements UserDetails {
    private Utilisateur utilisateur;


    public MyUserDetails(Utilisateur utilisateur)  {
        this.utilisateur =utilisateur;

    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(utilisateur.getTypeUtilisateur().getRoleUtilisateur()));

    }

    @Override
    public String getPassword() {
        return utilisateur.getMotDePasseUtilisateur();
    }

    @Override
    public String getUsername() {
        return utilisateur.getMailUtilisateur();
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
}
