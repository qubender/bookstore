package hh.bookstore.bookstore.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests( authorize -> authorize.anyRequest().authenticated())
            .formLogin( formLogin -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/booklist", true).permitAll());
        return http.build();
    }

    @Bean 
    public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
            .username("user")
            .password(encoder.encode("password"))
            .roles("USER")
            .build();
        UserDetails admin = User.withUsername("admin")
            .username("admin")
            .password(encoder.encode("password"))
            .roles("ADMIN")
            .build();
        List<UserDetails> users = new ArrayList<>();
        users.add(user);
        users.add(admin);

        return new InMemoryUserDetailsManager(users);
    }
}
