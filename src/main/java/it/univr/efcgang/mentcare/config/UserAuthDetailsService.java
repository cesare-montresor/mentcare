package it.univr.efcgang.mentcare.config;

import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.models.UserAuthDetails;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(userName);

        user.orElseThrow( () -> new UsernameNotFoundException("Not found: " + userName) );

        return user.map(UserAuthDetails::new).get();
    }


    public User UserAdd(String username, String password, String name, String roles) {
        // Username is already present
        Optional<User> userExists = userRepository.findByUsername(username);
        if (userExists.isPresent()) return null;

        //Get system password encoder
        PasswordEncoder encoder = passwordEncoder;
        if (encoder == null){
            encoder = securityConfiguration.getPasswordEncoder();
        }
        String password_enc = encoder.encode(password);

        //Create new user
        User user = new User(username, password_enc, name, roles);

        return userRepository.save(user);
    }


}