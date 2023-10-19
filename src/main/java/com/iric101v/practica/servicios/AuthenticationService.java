package com.iric101v.practica.servicios;

import com.iric101v.practica.dao.JwtAuthenticationResponse;
import com.iric101v.practica.dao.SignInRequest;
import com.iric101v.practica.dao.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}