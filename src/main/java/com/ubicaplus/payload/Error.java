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
 * Error mapping class - returned by the Provider Serivce
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Error implements Serializable {
    @XmlElement(name = "CodigoInformacion")
    private String CodigoInformacion;

    @XmlElement(name = "MotivoConsulta")
    private String MotivoConsulta;

    @XmlElement(name = "NumeroIdentificacion")
    private String NumeroIdentificacion;

    @XmlElement(name = "TipoIdentificacion")
    private String TipoIdentificacion;

    @XmlElement(name = "Operacion")
    private String Operacion;

    @XmlElement(name = "CodigoError")
    private String CodigoError;

    @XmlElement(name = "MensajeError")
    private String MensajeError;
}
