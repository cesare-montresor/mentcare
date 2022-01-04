package it.univr.efcgang.mentcare.config;

import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.models.UserAuthDetails;
import it.univr.efcgang.mentcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

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


    public User UserGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (! (auth.getPrincipal() instanceof UserAuthDetails )){ return null; } // auth.getPrincipal() returns an empty string when not authenticated
        UserAuthDetails details = (UserAuthDetails) auth.getPrincipal();

        Optional<User> user = userRepository.findByUsername( details.getUsername() );
        if (user.isEmpty() ) {return null;}

        return user.get();
    }

    public User UserSet(String username){
        Optional<User> userSearch = userRepository.findByUsername(username);
        if ( userSearch.isEmpty() ) {return null;}
        User user = userSearch.get();
        UserAuthDetails userAuth = new UserAuthDetails(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userAuth, null, userAuth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return user;
    }

}