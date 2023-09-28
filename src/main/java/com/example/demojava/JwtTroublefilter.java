package com.example.demojava;

import com.sap.cloud.security.token.TokenClaims;
import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;
import com.sap.cloud.security.xsuaa.token.authentication.XsuaaJwtDecoderBuilder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtTroublefilter extends GenericFilterBean {

    private XsuaaServiceConfiguration xsuaaServiceConfiguration_;
    public JwtTroublefilter(XsuaaServiceConfiguration xsuaaServiceConfiguration) {
        this.xsuaaServiceConfiguration_ = xsuaaServiceConfiguration;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String autHeader = httpServletRequest.getHeader("Authorization");
        if(autHeader == null){
            System.out.println("Authorization header not found!!");
            return;
        }



        JwtDecoder jwtDecoder = new XsuaaJwtDecoderBuilder(xsuaaServiceConfiguration_).withoutXsuaaAudienceValidator().build();
        String jwtEncoded = autHeader.substring(7);
        Jwt jwtDecoded = jwtDecoder.decode(jwtEncoded);

        System.out.println("===> [TROUBLE] This incoming JWT is sent to my app: " + jwtEncoded);
        System.out.println("===> [TROUBLE] The incoming JWT decoded: " + jwtDecoded.getClaims().toString());
        System.out.println("===> [TROUBLE] The incoming JWT is compared to the XSUAA binding of my app.");
        System.out.println("===> [TROUBLE] The incoming JWT must have my apps clientid in the aud.");

        System.out.println("===> [TROUBLE] JWT aud:     " + jwtDecoded.getAudience());
        System.out.println("===> [TROUBLE] XSUAA cliId: " + xsuaaServiceConfiguration_.getClientId());

        System.out.println("===> [TROUBLE] JWT sub:     " + jwtDecoded.getSubject());
        System.out.println("===> [TROUBLE] JWT iss:   " + jwtDecoded.getIssuer());
        System.out.println("===> [TROUBLE] XSUAA url: " + xsuaaServiceConfiguration_.getUaaUrl());
        System.out.println("===> [TROUBLE] JWT scopes: " + String.valueOf(jwtDecoded.getClaimAsStringList(TokenClaims.XSUAA.SCOPES)));

        chain.doFilter(request, response);

    }
}
