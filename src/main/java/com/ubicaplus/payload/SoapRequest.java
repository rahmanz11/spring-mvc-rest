package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SoapRequest implements Serializable {
    private String codigoInformacion;
    private String tipoIdentificacion;
    private String motivoConsulta;
    private String numeroIdentificacion;
    private String primerApellido;
}
