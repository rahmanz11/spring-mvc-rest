package com.ubicaplus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UbicaDetail implements Serializable {

    @Column(name = "ID")
    Long id;

    @Column(name = "REQUSUARIO")
    String ReqUsuario;

    @Column(name = "REQFECHACONSULTA")
    Date ReqFechaconsulta;

    @Column(name = "IDENTIFICADORLINEA")
    String IdentificadorLinea;

    @Column(name = "TIPOIDENTIFICACION")
    String TipoIdentificacion;

    @Column(name = "CODIGOTIPOINDENTIFICACION")
    String CodigoTipoIndentificacion;

    @Column(name = "NUMEROIDENTIFICACION")
    String NumeroIdentificacion;

    @Column(name = "NOMBRE1")
    String Nombre1;

    @Column(name = "APELLIDO1")
    String Apellido1;

    @Column(name = "APELLIDO2")
    String Apellido2;

    @Column(name = "NOMBRETITULAR")
    String NombreTitular;

    @Column(name = "NOMBRECIIU")
    String NombreCiiu;

    @Column(name = "LUGAREXPEDICION")
    String LugarExpedicion;

    @Column(name = "FECHAEXPEDICION")
    String FechaExpedicion;

    @Column(name = "ESTADO")
    String Estado;

    @Column(name = "NUMEROINFORME")
    String NumeroInforme;

    @Column(name = "ESTADOTITULAR")
    String EstadoTitular;

    @Column(name = "RANGOEDAD")
    String RangoEdad;

    @Column(name = "CODIGOCIIU")
    String CodigoCiiu;

    @Column(name = "CODIGODEPARTAMENTO")
    String CodigoDepartamento;

    @Column(name = "CODIGOMUNICIPIO")
    String CodigoMunicipio;

    @Column(name = "FECHA")
    String Fecha;

    @Column(name = "HORA")
    String Hora;

    @Column(name = "ENTIDAD")
    String Entidad;

    @Column(name = "RESPUESTACONSULTA")
    String RespuestaConsulta;

    @Lob
    @Column(name = "UBICAPLUSCIFIN")
    Clob UbicaPlusCifin;
}
