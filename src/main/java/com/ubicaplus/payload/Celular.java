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
 * Celular object data
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "Celular")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Celular implements Serializable {

    @XmlElement(name = "CelPos")
    private String CelPos;

    @XmlElement(name = "NoReportes")
    private String NoReportes;

    @XmlElement(name = "ProductoActivo")
    private String ProductoActivo;

    @XmlElement(name = "SectorEconomico")
    private String SectorEconomico;

    @XmlElement(name = "PrimerReporte")
    private String PrimerReporte;

    @XmlElement(name = "UltimoReporte")
    private String UltimoReporte;

    @XmlElement(name = "Celular")
    private String Celular;
}
