package main.auth;

import main.Entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by igor on 3/17/18.
 */
@Component
public interface TokenHandler {
    Optional<UserDetails> parseUserFromToken(String token);
    String createTokenForUser(User user);
}
