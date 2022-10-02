package com.ubicaplus.payload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Tercero")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Tercero implements Serializable {

    @XmlElement(name = "IdentificadorLinea")
    private String IdentificadorLinea;

    @XmlElement(name = "TipoIdentificacion")
    private String TipoIdentificacion;

    @XmlElement(name = "CodigoTipoIndentificacion")
    private String CodigoTipoIndentificacion;

    @XmlElement(name = "NumeroIdentificacion")
    private String NumeroIdentificacion;

    @XmlElement(name = "Nombre1")
    private String Nombre1;

    @XmlElement(name = "Apellido1")
    private String Apellido1;

    @XmlElement(name = "Apellido2")
    private String Apellido2;

    @XmlElement(name = "NombreTitular")
    private String NombreTitular;

    @XmlElement(name = "NombreCiiu")
    private String NombreCiiu;

    @XmlElement(name = "LugarExpedicion")
    private String LugarExpedicion;

    @XmlElement(name = "FechaExpedicion")
    private String FechaExpedicion;

    @XmlElement(name = "Estado")
    private String Estado;

    @XmlElement(name = "NumeroInforme")
    private String NumeroInforme;

    @XmlElement(name = "EstadoTitular")
    private String EstadoTitular;

    @XmlElement(name = "RangoEdad")
    private String RangoEdad;

    @XmlElement(name = "CodigoCiiu")
    private String CodigoCiiu;

    @XmlElement(name = "CodigoDepartamento")
    private String CodigoDepartamento;

    @XmlElement(name = "CodigoMunicipio")
    private String CodigoMunicipio;

    @XmlElement(name = "Fecha")
    private String Fecha;

    @XmlElement(name = "Hora")
    private String Hora;

    @XmlElement(name = "Entidad")
    private String Entidad;

    @XmlElement(name = "RespuestaConsulta")
    private String RespuestaConsulta;

    @XmlElement(name = "UbicaPlusCifin")
    private UbicaPlusCifin UbicaPlusCifin;

    public Tercero() {}

    @Override
    public String toString() {
        return "Tercero{" +
                "IdentificadorLinea='" + IdentificadorLinea + '\'' +
                ", TipoIdentificacion='" + TipoIdentificacion + '\'' +
                ", CodigoTipoIndentificacion='" + CodigoTipoIndentificacion + '\'' +
                ", NumeroIdentificacion='" + NumeroIdentificacion + '\'' +
                ", Nombre1='" + Nombre1 + '\'' +
                ", Apellido1='" + Apellido1 + '\'' +
                ", Apellido2='" + Apellido2 + '\'' +
                ", NombreTitular='" + NombreTitular + '\'' +
                ", NombreCiiu='" + NombreCiiu + '\'' +
                ", LugarExpedicion='" + LugarExpedicion + '\'' +
                ", FechaExpedicion='" + FechaExpedicion + '\'' +
                ", Estado='" + Estado + '\'' +
                ", NumeroInforme='" + NumeroInforme + '\'' +
                ", EstadoTitular='" + EstadoTitular + '\'' +
                ", RangoEdad='" + RangoEdad + '\'' +
                ", CodigoCiiu='" + CodigoCiiu + '\'' +
                ", CodigoDepartamento='" + CodigoDepartamento + '\'' +
                ", CodigoMunicipio='" + CodigoMunicipio + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", Hora='" + Hora + '\'' +
                ", Entidad='" + Entidad + '\'' +
                ", RespuestaConsulta='" + RespuestaConsulta + '\'' +
                ", UbicaPlusCifin=" + UbicaPlusCifin.toString() +
                '}';
    }

    public String getIdentificadorLinea() {
        return IdentificadorLinea;
    }

    public void setIdentificadorLinea(String identificadorLinea) {
        IdentificadorLinea = identificadorLinea;
    }

    public String getTipoIdentificacion() {
        return TipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        TipoIdentificacion = tipoIdentificacion;
    }

    public String getCodigoTipoIndentificacion() {
        return CodigoTipoIndentificacion;
    }

    public void setCodigoTipoIndentificacion(String codigoTipoIndentificacion) {
        CodigoTipoIndentificacion = codigoTipoIndentificacion;
    }

    public String getNumeroIdentificacion() {
        return NumeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        NumeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre1() {
        return Nombre1;
    }

    public void setNombre1(String nombre1) {
        Nombre1 = nombre1;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String apellido1) {
        Apellido1 = apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String apellido2) {
        Apellido2 = apellido2;
    }

    public String getNombreTitular() {
        return NombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        NombreTitular = nombreTitular;
    }

    public String getNombreCiiu() {
        return NombreCiiu;
    }

    public void setNombreCiiu(String nombreCiiu) {
        NombreCiiu = nombreCiiu;
    }

    public String getLugarExpedicion() {
        return LugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        LugarExpedicion = lugarExpedicion;
    }

    public String getFechaExpedicion() {
        return FechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        FechaExpedicion = fechaExpedicion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getNumeroInforme() {
        return NumeroInforme;
    }

    public void setNumeroInforme(String numeroInforme) {
        NumeroInforme = numeroInforme;
    }

    public String getEstadoTitular() {
        return EstadoTitular;
    }

    public void setEstadoTitular(String estadoTitular) {
        EstadoTitular = estadoTitular;
    }

    public String getRangoEdad() {
        return RangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        RangoEdad = rangoEdad;
    }

    public String getCodigoCiiu() {
        return CodigoCiiu;
    }

    public void setCodigoCiiu(String codigoCiiu) {
        CodigoCiiu = codigoCiiu;
    }

    public String getCodigoDepartamento() {
        return CodigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        CodigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return CodigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        CodigoMunicipio = codigoMunicipio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String entidad) {
        Entidad = entidad;
    }

    public String getRespuestaConsulta() {
        return RespuestaConsulta;
    }

    public void setRespuestaConsulta(String respuestaConsulta) {
        RespuestaConsulta = respuestaConsulta;
    }

    public UbicaPlusCifin getUbicaPlusCifin() {
        return UbicaPlusCifin;
    }

    public void setUbicaPlusCifin(UbicaPlusCifin ubicaPlusCifin) {
        UbicaPlusCifin = ubicaPlusCifin;
    }
}
