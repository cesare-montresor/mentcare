package it.univr.efcgang.mentcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Public
            .authorizeRequests()
                .regexMatchers("/").permitAll()
                .regexMatchers("/error").permitAll()
                .regexMatchers("/static.*").permitAll()
                .regexMatchers("/img.*").permitAll()

            // Doctors & Office
            .and().authorizeRequests()
                .regexMatchers("/drug.*").hasAnyAuthority("DOCTOR", "OFFICE")
                .regexMatchers("/patient.*").hasAnyAuthority("DOCTOR", "OFFICE")
                .regexMatchers("/prescription.*").hasAnyAuthority( "DOCTOR")
            // Admin
            .and().authorizeRequests()
                .regexMatchers("/user.*").hasAnyAuthority("ADMIN")
                .regexMatchers("/utils.*").hasAnyAuthority("ADMIN")

            // Guest
            .and().authorizeRequests()
                .regexMatchers("/profile.*").authenticated()
                .anyRequest().authenticated()

            // Login
            .and().formLogin()
                .loginPage("/login").permitAll()

            // Logut
            .and().logout()
                .logoutUrl("/logout")
                .permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}