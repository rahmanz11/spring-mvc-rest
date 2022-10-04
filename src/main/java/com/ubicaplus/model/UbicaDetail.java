package com.ubicaplus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UbicaDetail implements Serializable {

    @Column(name = "ID")
    Long id;

    @Column(name = "RESPONSE")
    String response;

    @Column(name = "STATUS")
    Long status;

    @Column(name = "REQUEST_DATE_TIME")
    @DateTimeFormat(pattern = "YYYY-MM-DD HH24:MI:SS")
    Date requestDateTime;

    @Column(name = "RESPONSE_DATE_TIME")
    @DateTimeFormat(pattern = "YYYY-MM-DD HH24:MI:SS")
    Date responseDateTime;
}
