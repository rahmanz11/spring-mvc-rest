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
@XmlRootElement(name = "Mail")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Mail implements Serializable {

    @XmlElement(name = "NoReportes")
    private String NoReportes;

    @XmlElement(name = "PrimerReporte")
    private String PrimerReporte;

    @XmlElement(name = "UltimoReporte")
    private String UltimoReporte;

    @XmlElement(name = "Correo")
    private String Correo;
}
