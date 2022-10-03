package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedServerException extends RuntimeException {
    public UnauthorizedServerException() {
        super("Access Unauthorized");
    }
}
