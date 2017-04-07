package br.com.lists.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccess extends ListServiceException {

    public UnauthorizedAccess() {
        super();
    }

    public UnauthorizedAccess(String message) {
        super(message);
    }

    public UnauthorizedAccess(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedAccess(Throwable cause) {
        super(cause);
    }


}