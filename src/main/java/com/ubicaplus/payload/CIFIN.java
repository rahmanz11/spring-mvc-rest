package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "CIFIN")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CIFIN implements Serializable {

    @XmlElement(name = "Tercero")
    private Tercero Tercero;
}
