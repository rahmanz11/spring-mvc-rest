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
@XmlRootElement(name = "UbicaPlusCifin")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UbicaPlusCifin implements Serializable {

    @XmlElement(name = "GeneroTercero")
    private String GeneroTercero;
}
