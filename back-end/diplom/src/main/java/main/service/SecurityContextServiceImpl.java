package main.service;

import main.Entities.User;
import main.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by igor on 3/17/18.
 */
@Service
@Transactional
public class SecurityContextServiceImpl implements SecurityContextService {

    private final UserRepository userRepository;

    @Autowired
    public SecurityContextServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> currentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.of(userRepository.findOneByEmail(authentication.getName()));
    }
}
