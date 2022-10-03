package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RestResponse implements Serializable {
    private CIFIN cifin;
    private CifinError cifinError;
    private String errorMessage;
}
