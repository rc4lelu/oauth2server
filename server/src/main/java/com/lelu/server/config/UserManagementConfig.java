package com.lelu.server.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserManagementConfig {


    @Bean
    //@Order(2)
    public SecurityFilterChain userManagementSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        authz -> authz
                                .requestMatchers("/index.html", "/", "/login1", "/login", "*.js", "*.css", "*"
                                        + ".ico").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());


        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("admin")
                .password("admin")
                .roles("read", "create")
                .credentialsExpired(false)
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
