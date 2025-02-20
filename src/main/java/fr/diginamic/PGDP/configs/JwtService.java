package fr.diginamic.PGDP.configs;

import fr.diginamic.PGDP.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private String jwtExpirationTime;

    public String generateToken(User authenticatedUser) {
        long expirationTime = Long.parseLong(jwtExpirationTime);
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

        String jwtToken = Jwts.builder()
                .subject(authenticatedUser.getEmail())
                .claim("roles", authenticatedUser.getAuthorities()) // Add roles to the token
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key, StandardSecureDigestAlgorithms.findBySigningKey(key))
                .compact();

        ResponseCookie responseCookie = ResponseCookie.from("jwt", jwtToken)
                .httpOnly(true)
                .maxAge(expirationTime)
                .path("/")
                .build();

        return responseCookie.toString();
    }

    public Long getJwtExpirationTime() {
        return Long.parseLong(jwtExpirationTime);
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
