package com.example.demojava;

import com.sap.cloud.security.xsuaa.token.authentication.XsuaaJwtDecoderBuilder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtTroublefilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String autheader = httpServletRequest.getHeader("Authorization");
        if(autheader == null){
            System.out.println("Authorization header not found!!");
            return;
        }


        JwtDecoder jwtDecoder = new XsuaaJwtDecoderBuilder(xsuaaBinding).withoutXsuaaAudienceValidator().build();
        String jwtEncoded = autheader.substring(7);
        Jwt jwtDecoded = jwtDecoder.decode(jwtEncoded);


    }
}
