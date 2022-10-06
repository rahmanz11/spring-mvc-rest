package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SoapRequest implements Serializable {
    private String req_usuario;
    private String req_password;
    private String codigoInformacion;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String primerApellido;
    private String motivoConsulta;
}
