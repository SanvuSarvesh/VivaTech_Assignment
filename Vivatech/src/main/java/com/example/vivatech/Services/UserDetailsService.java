package com.example.vivatech.Services;

import com.example.vivatech.Model.User;
import com.example.vivatech.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(phoneNo);
        if(user==null){
            user = new User();
            user.setUserName(phoneNo);
            userRepository.save(user);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), "",
                new ArrayList<>());
    }
}
