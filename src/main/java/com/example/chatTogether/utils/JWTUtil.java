
package com.example.chatTogether.utils;

import com.example.chatTogether.entities.UserAuth;
import com.example.chatTogether.repositories.JwtUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class JWTUtil {

    @Value("${jwt.token.expiry.day}")
    private Long tokenExpiryDay;

    @Value("${jwt.token.secret.key}")
    private  String SECRET_KEY;


    private final JwtUserRepository jwtUserRepository;

    public String extractIdentifier(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        try {

            final Claims claims = extractAllClaims(token);
            if (claims.getExpiration().before(new Date())) {
                return null;
            }
            return claimsResolver.apply(claims);
        }catch (ExpiredJwtException e){
            log.error("Token expired");
            return null;
        }
    }


    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(Long details){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims,String.valueOf( details));
    }

    private String createToken(Map<String, Object> claims, String subject){
        long time = System.currentTimeMillis();
        long expiry = Duration.ofDays(tokenExpiryDay).toMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + expiry))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public Boolean validateToken(String token, String identifier){
        UserAuth userAuth = jwtUserRepository.findByJwt(token);
        if(Objects.isNull(userAuth)){
            return Boolean.FALSE;
        }
        final String userid = String.valueOf(userAuth.getUserId());
        //String identifier1 = extractIdentifier(token);
        return (userid.equals(identifier) && !isTokenExpired(token) && userAuth.getExpiryTime().isAfter(LocalDateTime.now()));
    }
}
