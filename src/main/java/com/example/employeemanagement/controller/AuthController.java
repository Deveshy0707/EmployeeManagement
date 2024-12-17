package com.example.employeemanagement.controller;

import com.example.employeemanagement.security.jwt.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtility util;

    @GetMapping("/login/{userName}/{password}")
    public String login(@PathVariable String userName, @PathVariable String password) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

        return util.generateToken(auth);
    }
}
