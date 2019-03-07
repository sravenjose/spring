package com.rest.service;

import com.rest.JPA.UserRepo;
import com.rest.entity.CustomUserDetails;
import com.rest.entity.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImp implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserList> optionalUserList= userRepo.findByName(username);
        optionalUserList.orElseThrow(() -> new UsernameNotFoundException("username not found"));
        return optionalUserList.map(CustomUserDetails::new).get();

    }
}
