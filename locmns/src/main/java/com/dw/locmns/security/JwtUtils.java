package com.dw.locmns.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtUtils {


    public  String generateToken(MyUserDetails  userDetails){

        Map<String, Object> data = new HashMap<>();
        data.put("idUtilisateur", userDetails.getUtilisateur().getIdUtilisateur());
        data.put("nomUtilisateur", userDetails.getUtilisateur().getNomUtilisateur());
        data.put("prenomUtilisateur", userDetails.getUtilisateur().getPrenomUtilisateur());
        data.put("adresseUtilisateur", userDetails.getUtilisateur().getAdresseUtilisateur());
        data.put("mailUtilisateur", userDetails.getUtilisateur().getMailUtilisateur());
        data.put("telephoneUtilisateur", userDetails.getUtilisateur().getTelephoneUtilisateur());
        data.put("motDePasseUtilisateur", "");
        data.put("typeUtilisateur", userDetails.getUtilisateur().getTypeUtilisateur());
        data.put("localisation", userDetails.getUtilisateur().getLocalisation());

        return Jwts.builder()
                .setClaims(data)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(540L)))

                .signWith(SignatureAlgorithm.HS256,"secret" )
                .compact();

    }
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

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
