package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class
 */
@Getter
@Setter
@NoArgsConstructor
@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
public class InvalidUserException extends RuntimeException {

    private String message;

    public InvalidUserException(String message) {
        super(String.format("%s", message));
    }
}
