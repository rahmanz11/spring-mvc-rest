package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

/**
 * XML Tree parent class of the Direccion
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Direcciones implements Serializable {
    @XmlElement(name = "Direccion")
    List<Direccion> Direccion;
}
