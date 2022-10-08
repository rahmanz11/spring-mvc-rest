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

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "Direccion")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Direccion implements Serializable {

    @XmlElement(name = "DirPos")
    private String DirPos;

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

    @XmlElement(name = "Direccion")
    private String Direccion;

    @XmlElement(name = "Ciudad")
    private String Ciudad;
}
