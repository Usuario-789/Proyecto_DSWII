package com.cibertec.proyecto.service;

import java.util.Arrays;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import com.cibertec.proyecto.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                   .map(u -> new org.springframework.security.core.userdetails.User(
                           u.getUsername(),
                           u.getPassword(),
                           Arrays.stream(u.getRoles().split(","))
                                 .map(SimpleGrantedAuthority::new)
                                 .toList()))
                   .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}

