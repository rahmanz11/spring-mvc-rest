package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SoapResponse implements Serializable {
    private CIFIN CIFIN;
    private CifinError CifinError;
    private String errorMessage;
    private boolean unauthorized;
}
