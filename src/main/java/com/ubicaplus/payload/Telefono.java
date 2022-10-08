package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * An attribute from the Provider Service Response
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "Telefono")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Telefono implements Serializable {

    @XmlElement(name = "TelPos")
    private String TelPos;

    @XmlElement(name = "NoReportes")
    private String NoReportes;

    @XmlElement(name = "ProductoActivo")
    private String ProductoActivo;

    @XmlElement(name = "TipoUbicacion")
    private String TipoUbicacion;

    @XmlElement(name = "SectorEconomico")
    private String SectorEconomico;

    @XmlElement(name = "PrimerReporte")
    private String PrimerReporte;

    @XmlElement(name = "UltimoReporte")
    private String UltimoReporte;

    @XmlElement(name = "Prefijo")
    private String Prefijo;

    @XmlElement(name = "Telefono")
    private String Telefono;

    @XmlElement(name = "Ciudad")
    private String Ciudad;
}
