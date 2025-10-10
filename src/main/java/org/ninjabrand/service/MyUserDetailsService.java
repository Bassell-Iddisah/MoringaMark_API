package org.ninjabrand.service;

import org.ninjabrand.model.Principal;
import org.ninjabrand.model.Users;
import org.ninjabrand.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null) {
            System.out.println("User not found");
             throw new UsernameNotFoundException("User not found");
        }
        return new Principal(user);

    }
}
