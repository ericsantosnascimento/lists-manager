package br.com.lists.exception;

/**
 * Created by eric-nasc on 26/02/17.
 */
public class ListServiceException extends RuntimeException {

    public ListServiceException() {
        super();
    }

    public ListServiceException(String message) {
        super(message);
    }

    public ListServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListServiceException(Throwable cause) {
        super(cause);
    }
}