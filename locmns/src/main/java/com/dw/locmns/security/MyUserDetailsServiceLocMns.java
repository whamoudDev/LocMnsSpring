package com.dw.locmns.security;

import com.dw.locmns.dao.GestionnaireDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Gestionnaire;
import com.dw.locmns.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServiceLocMns implements UserDetailsService {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UtilisateurDao utilisateurDao;

    @Autowired
    private GestionnaireDao gestionnaireDao;

    @Autowired
    MyUserDetailsServiceLocMns(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Utilisateur> optional = utilisateurDao.findBymailUtilisateur(email);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("L'utilisateur n'existe pas");

        }
        return new MyUserDetails((optional.get()));
    }


}

