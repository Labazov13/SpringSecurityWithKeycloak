package com.example.SpringSecurityWithKeycloak.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> userInfo(Authentication authentication){
        Map<String, Object> userInfo = new HashMap<>();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            userInfo.put("username", jwt.getClaimAsString("preferred_username"));
            userInfo.put("email", jwt.getClaimAsString("email"));
            userInfo.put("name", jwt.getClaimAsString("name"));
        } else {
            userInfo.put("error", "User is not authenticated");
        }
        return ResponseEntity.ok(userInfo);
    }
}
