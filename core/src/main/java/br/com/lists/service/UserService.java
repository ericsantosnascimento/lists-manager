package br.com.lists.service;

import br.com.lists.exception.UnauthorizedAccess;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by eric-nasc on 07/04/17.
 */
@Service
public class UserService {

    public boolean checkUserSession(UUID userId, String token) {
        if (!isUserLoggedIn(userId, token)) {
            throw new UnauthorizedAccess("Unauthorized access");
        }
        return true;
    }

    private boolean isUserLoggedIn(UUID userId, String token) {
        return true;
    }

}
