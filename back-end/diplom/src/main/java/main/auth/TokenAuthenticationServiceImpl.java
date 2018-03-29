package main.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by igor on 3/17/18.
 */
@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private final TokenHandler tokenHandler;

    @Autowired
    TokenAuthenticationServiceImpl(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request) {
        final String authHeader = request.getHeader("authorization");
        if (authHeader == null) return null;
        if (!authHeader.startsWith("Bearer")) return null;

        final String jwt = authHeader.substring(7);
        if (jwt.isEmpty()) return null;

        return tokenHandler
                .parseUserFromToken(jwt)
                .map(UserAuthentication::new)
                .orElse(null);
    }
}
