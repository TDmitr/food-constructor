package main.auth;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by igor on 3/17/18.
 */
public interface TokenAuthenticationService {
    Authentication getAuthentication(HttpServletRequest request);
}
