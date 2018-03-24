package main.service;

import main.Entities.User;

import java.util.Optional;

/**
 * Created by igor on 3/17/18.
 */
public interface SecurityContextService {
    Optional<User> currentUser();
}
