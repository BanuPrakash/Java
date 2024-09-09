package com.example.demosecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Autowired
private DataSource dataSource;

//    @Bean
//    public InMemoryUserDetailsManager users() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("roger")
//                        .password("{noop}secret")
//                        .authorities("ROLE_USER").build(),
//                User.withUsername("smitha")
//                        .password("{noop}secret")
//                        .authorities("ROLE_ADMIN", "ROLE_USER").build()
//        );
//    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(requests -> requests.requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/hello").hasAnyRole("ADMIN","USER")
                .requestMatchers("/").permitAll())
                .formLogin(Customizer.withDefaults());
        return security.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.jdbcAuthentication().dataSource(dataSource);
    }
}
