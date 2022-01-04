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

@Configuration
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
                .antMatchers("/").permitAll()
                .antMatchers("/error").permitAll()

            // Doctors & Office
            .and().authorizeRequests()
                .antMatchers("/drug").hasAnyAuthority("ADMIN", "DOCTOR", "OFFICE")
                .antMatchers("/patient").hasAnyAuthority("ADMIN", "DOCTOR", "OFFICE")
                .antMatchers("/prescription").hasAnyAuthority("ADMIN", "DOCTOR")

            // Admin
            .and().authorizeRequests()
                .antMatchers("/user").hasAuthority("ADMIN")
                .antMatchers("/utils").hasAuthority("ADMIN")

            // Any other request, other than public, require authentication
            .and().authorizeRequests()
                .anyRequest().authenticated()

            // Login
            .and().formLogin()
                .loginPage("/login").permitAll()

            // Logut
            .and().logout()
                .logoutUrl("/logout")
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .permitAll()
;
            // Errors
            //.and().exceptionHandling()
            //    .accessDeniedPage("/error");
        ;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}