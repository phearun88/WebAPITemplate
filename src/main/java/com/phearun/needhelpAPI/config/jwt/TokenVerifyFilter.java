/**
 * Author : PhearunPhin
 * Date : 10/20/2023
 */

package com.phearun.needhelpAPI.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class TokenVerifyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String secretkey = "mykeys0123456789abcdefghijklmnopqrstuvwxyz";

        String authorizationHearder = request.getHeader("Authorization");

        if(Objects.isNull(authorizationHearder) || !authorizationHearder.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authorizationHearder.replace("Bearer ", "");

        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(secretkey.getBytes()))
                .parseClaimsJws(token);

        Claims body = claimsJws.getBody();

        String username = body.getSubject();
//        Objects

    }
}
