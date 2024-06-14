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
@RequestMapping("/admin")
public class AdminController {
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> adminInfo(Authentication authentication){
        Map<String, Object> adminInfo = new HashMap<>();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            adminInfo.put("username", jwt.getClaimAsString("preferred_username"));
            adminInfo.put("email", jwt.getClaimAsString("email"));
            adminInfo.put("name", jwt.getClaimAsString("name"));
        } else {
            adminInfo.put("error", "User is not authenticated");
        }
        return ResponseEntity.ok(adminInfo);
    }
}
