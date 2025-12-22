package com.rav3.ecom.service;

import com.rav3.ecom.model.UserPrincipal;
import com.rav3.ecom.model.Users;
import com.rav3.ecom.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
