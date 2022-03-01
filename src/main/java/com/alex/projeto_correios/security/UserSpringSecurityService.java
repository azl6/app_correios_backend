package com.alex.projeto_correios.security;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSpringSecurityService implements UserDetailsService {

    @Autowired
    private ClienteRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cli = repo.findByEmail(email);
        if (cli == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSpringSecurity(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
    }
}
