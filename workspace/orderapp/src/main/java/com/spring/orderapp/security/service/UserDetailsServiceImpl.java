package com.spring.orderapp.security.service;

import com.spring.orderapp.security.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {
    private final UserDao userDao; // same as @Autowired

    public UserDetailsService userDetailsService() {
     return new UserDetailsService() {
         // instead of login using username/password we will login using email/password
         // username passed will be email
         @Override
         public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             return userDao.findByEmail(username)
                     .orElseThrow(() -> new UsernameNotFoundException("user not found!!!"));
         }
     };
    }
}
