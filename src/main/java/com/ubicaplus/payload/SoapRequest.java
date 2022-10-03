package com.ubicaplus.payload;

import java.io.Serializable;

public class SoapRequest implements Serializable {
    private String codigoInformacion;
    private String tipoIdentificacion;
    private String motivoConsulta;
    private String numeroIdentificacion;
    private String primerApellido;

    public SoapRequest() {}

    public String getCodigoInformacion() {
        return codigoInformacion;
    }

    public void setCodigoInformacion(String codigoInformacion) {
        this.codigoInformacion = codigoInformacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
}
