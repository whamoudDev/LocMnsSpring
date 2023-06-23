package com.dw.locmns.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    MyUserDetailsServiceLocMns myUserDetailsServiceLocMns;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization"); //Recoit l'authorisation où il y a notre token

        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7); //Enleve les 7 caractères (Bearer + espace)
            String mail = jwtUtils.getTokenBody(jwt).getSubject();
            MyUserDetails userDetails = (MyUserDetails) this.myUserDetailsServiceLocMns.loadUserByUsername(mail);

            if (jwtUtils.tokenValide(jwt, userDetails)) { //Vérifie la validité  des credentials
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken); //Sauvegarde l'authentification dans le contexte
            }

        }
        filterChain.doFilter(request, response);
    }


}

