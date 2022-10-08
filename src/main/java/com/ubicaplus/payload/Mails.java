package com.ubicaplus.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

/**
 * Parent class for Mail data object
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mails implements Serializable {
    @XmlElement(name = "Mail")
    private List<Mail> Mail;
}
