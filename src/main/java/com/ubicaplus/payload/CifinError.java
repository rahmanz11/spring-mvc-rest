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
@XmlRootElement(name = "CifinError")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CifinError implements Serializable {
    @XmlElement(name = "Error")
    private Error Error;
}
