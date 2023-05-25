package com.dw.locmns.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {


    public  String generateToken(MyUserDetails  userDetails){

        Map<String, Object> data = new HashMap<>();
        data.put("id", userDetails.getUtilisateur().getIdUtilisateur());
        data.put("prenom", userDetails.getUtilisateur().getPrenomUtilisateur());//ajout du prenom dans le token
       data.put("nom", userDetails.getUtilisateur().getNomUtilisateur());
        data.put("adresse", userDetails.getUtilisateur().getAdresseUtilisateur());
        data.put("mail", userDetails.getUtilisateur().getMailUtilisateur());
        data.put("telephone", userDetails.getUtilisateur().getTelephoneUtilisateur());
        data.put("motDePasse", userDetails.getUtilisateur().getMotDePasseUtilisateur());
        data.put("typeUtilisateur", userDetails.getUtilisateur().getTypeUtilisateur());
        //data.put("localisation", userDetails.getUtilisateur().getLocalisation());






        return Jwts.builder()
                .setClaims(data)
                .setSubject(userDetails.getUsername())

                .signWith(SignatureAlgorithm.HS256,"secret" )
                .compact();

    }
    public Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValide(String token, MyUserDetails userDetails){
        Claims claims = getTokenBody(token);

        return claims.getSubject().equals(userDetails.getUsername());
    }




}
