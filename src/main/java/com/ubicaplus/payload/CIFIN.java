package com.ubicaplus.payload;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "CIFIN")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CIFIN implements Serializable {

    @XmlElement(name = "Tercero")
    private Tercero Tercero;

    public CIFIN() {}

    @Override
    public String toString() {
        return "CIFIN{" +
                "Tercero=" + Tercero.toString() +
                '}';
    }

    public Tercero getTercero() {
        return Tercero;
    }

    public void setTercero(Tercero tercero) {
        Tercero = tercero;
    }
}
