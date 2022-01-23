package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.User;
import it.univr.efcgang.mentcare.models.UserAuthDetails;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test class of User class in model
 * that test all the methods of that class
 */
public class TestUserAuthDetail extends BaseTest {

    public User dummyUser(){
        User user = new User(
                "mariorossi",
                "secure",
                "mario",
                "ADMIN"
        );
        user.setActive(true);
        return user;
    }

    @Test
    public void testGetUsername() {
        User user = dummyUser();
        String username = "luigibianchi";
        user.setUsername(username);
        UserAuthDetails auth = new UserAuthDetails(user);

        assertEquals(username, auth.getUsername() );
    }

    @Test
    public void testIsAccountNonExpired() {
        User user = dummyUser();
        UserAuthDetails auth = new UserAuthDetails(user);
        assertTrue(auth.isAccountNonExpired() );
    }

    @Test
    public void testIsAccountNonLocked() {
        User user = dummyUser();
        UserAuthDetails auth = new UserAuthDetails(user);
        assertTrue(auth.isAccountNonLocked() );
    }

    @Test
    public void testIsCredentialsNonExpired() {
        User user = dummyUser();
        UserAuthDetails auth = new UserAuthDetails(user);
        assertTrue(auth.isCredentialsNonExpired() );
    }

    @Test
    public void testIsEnabled() {
        User user = dummyUser();
        user.setActive(false);
        UserAuthDetails auth = new UserAuthDetails(user);
        assertEquals(user.getActive(), auth.isEnabled() );
    }
}
