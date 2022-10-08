package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

/**
 * Parent class to hold Telefono data
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Telefonos implements Serializable {
    @XmlElement(name = "Telefono")
    private List<Telefono> Telefono;
}
