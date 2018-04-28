package main.Controllers;

import lombok.Getter;
import lombok.Setter;
import main.auth.TokenHandler;
import main.service.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

/**
 * Created by igor on 3/17/18.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final TokenHandler tokenHandler;
    private final SecurityContextService securityContextService;

    @Autowired
    LoginController(AuthenticationManager authenticationManager,
                   TokenHandler tokenHandler,
                   SecurityContextService securityContextService) {
        this.authenticationManager = authenticationManager;
        this.tokenHandler = tokenHandler;
        this.securityContextService = securityContextService;
    }

    @PostMapping
    public AuthResponse auth(@RequestBody AuthParams params) throws AuthenticationException{
        final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return securityContextService.currentUser().map(user -> {
            final String token = tokenHandler.createTokenForUser(user);
            return new AuthResponse(token);
        }).orElseThrow(RuntimeException::new);
    }

    private static final class AuthParams {
        @Getter @Setter
        private String email;
        @Getter @Setter
        private String password;

        public AuthParams() {
        }

        public AuthParams(String email, String password) {
            this.email = email;
            this.password = password;
        }

        UsernamePasswordAuthenticationToken toAuthenticationToken() {
            return new UsernamePasswordAuthenticationToken(email, password);
        }
    }

    private static final class AuthResponse {
        private String token;

        public AuthResponse() {
        }

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
