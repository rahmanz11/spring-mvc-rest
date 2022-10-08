package com.ubicaplus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
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

    @Column(name = "DIRECCION_DIRPOS")
    private String DireccionDirPos;

    @Column(name = "DIRECCION_NOREPORTES")
    private String DireccionNoReportes;

    @Column(name = "DIRECCION_PRODUCTOACTIVO")
    private String DireccionProductoActivo;

    @Column(name = "DIRECCION_TIPOUBICACION")
    private String DireccionTipoUbicacion;

    @Column(name = "DIRECCION_SECTORECONOMICO")
    private String DireccionSectorEconomico;

    @Column(name = "DIRECCION_PRIMERREPORTE")
    private String DireccionPrimerReporte;

    @Column(name = "DIRECCION_ULTIMOREPORTE")
    private String DireccionUltimoReporte;

    @Column(name = "DIRECCION_DIRECCION")
    private String DireccionDireccion;

    @Column(name = "DIRECCION_CIUDAD")
    private String DireccionCiudad;

    @Column(name = "TELEFONO_TELPOS")
    private String TelefonoTelPos;

    @Column(name = "TELEFONO_NOREPORTES")
    private String TelefonoNoReportes;

    @Column(name = "TELEFONO_PRODUCTOACTIVO")
    private String TelefonoProductoActivo;

    @Column(name = "TELEFONO_TIPOUBICACION")
    private String TelefonoTipoUbicacion;

    @Column(name = "TELEFONO_SECTORECONOMICO")
    private String TelefonoSectorEconomico;

    @Column(name = "TELEFONO_PRIMERREPORTE")
    private String TelefonoPrimerReporte;

    @Column(name = "TELEFONO_ULTIMOREPORTE")
    private String TelefonoUltimoReporte;

    @Column(name = "TELEFONO_PREFIJO")
    private String TelefonoPrefijo;

    @Column(name = "TELEFONO_TELEFONO")
    private String TelefonoTelefono;

    @Column(name = "TELEFONO_CIUDAD")
    private String TelefonoCiudad;

    @Column(name = "CELULAR_CELPOS")
    private String CelularCelPos;

    @Column(name = "CELULAR_NOREPORTES")
    private String CelularNoReportes;

    @Column(name = "CELULAR_PRODUCTOACTIVO")
    private String CelularProductoActivo;

    @Column(name = "CELULAR_SECTORECONOMICO")
    private String CelularSectorEconomico;

    @Column(name = "CELULAR_PRIMERREPORTE")
    private String CelularPrimerReporte;

    @Column(name = "CELULAR_ULTIMOREPORTE")
    private String CelularUltimoReporte;

    @Column(name = "CELULAR_CELULAR")
    private String CelularCelular;

    @Column(name = "MAIL_NOREPORTES")
    private String MailNoReportes;

    @Column(name = "MAIL_PRIMERREPORTE")
    private String MailPrimerReporte;

    @Column(name = "MAIL_ULTIMOREPORTE")
    private String MailUltimoReporte;

    @Column(name = "MAIL_CORREO")
    private String MailCorreo;
}
