-- create table
CREATE TABLE UBICA_DETAIL
(ID NUMBER PRIMARY KEY,
 REQUSUARIO VARCHAR2(4000),
 REQFECHACONSULTA TIMESTAMP,
 IDENTIFICADORLINEA VARCHAR2(4000),
 TIPOIDENTIFICACION VARCHAR2(4000),
 CODIGOTIPOINDENTIFICACION VARCHAR2(4000),
 NUMEROIDENTIFICACION VARCHAR2(4000),
 NOMBRE1 VARCHAR2(4000),
 APELLIDO1 VARCHAR2(4000),
 APELLIDO2 VARCHAR2(4000),
 NOMBRETITULAR VARCHAR2(4000),
 NOMBRECIIU VARCHAR2(4000),
 LUGAREXPEDICION VARCHAR2(4000),
 FECHAEXPEDICION VARCHAR2(4000),
 ESTADO VARCHAR2(4000),
 NUMEROINFORME VARCHAR2(4000),
 ESTADOTITULAR VARCHAR2(4000),
 RANGOEDAD VARCHAR2(4000),
 CODIGOCIIU VARCHAR2(4000),
 CODIGODEPARTAMENTO VARCHAR2(4000),
 CODIGOMUNICIPIO VARCHAR2(4000),
 FECHA VARCHAR2(4000),
 HORA VARCHAR2(4000),
 ENTIDAD VARCHAR2(4000),
 RESPUESTACONSULTA VARCHAR2(4000),
 DIRECCION_DIRPOS VARCHAR2(4000),
 DIRECCION_NOREPORTES VARCHAR2(4000),
 DIRECCION_PRODUCTOACTIVO VARCHAR2(4000),
 DIRECCION_TIPOUBICACION VARCHAR2(4000),
 DIRECCION_SECTORECONOMICO VARCHAR2(4000),
 DIRECCION_PRIMERREPORTE VARCHAR2(4000),
 DIRECCION_ULTIMOREPORTE VARCHAR2(4000),
 DIRECCION_DIRECCION VARCHAR2(4000),
 DIRECCION_CIUDAD VARCHAR2(4000),
 TELEFONO_TELPOS VARCHAR2(4000),
 TELEFONO_NOREPORTES VARCHAR2(4000),
 TELEFONO_PRODUCTOACTIVO VARCHAR2(4000),
 TELEFONO_TIPOUBICACION VARCHAR2(4000),
 TELEFONO_SECTORECONOMICO VARCHAR2(4000),
 TELEFONO_PRIMERREPORTE VARCHAR2(4000),
 TELEFONO_ULTIMOREPORTE VARCHAR2(4000),
 TELEFONO_PREFIJO VARCHAR2(4000),
 TELEFONO_TELEFONO VARCHAR2(4000),
 TELEFONO_CIUDAD VARCHAR2(4000),
 CELULAR_CELPOS VARCHAR2(4000),
 CELULAR_NOREPORTES VARCHAR2(4000),
 CELULAR_PRODUCTOACTIVO VARCHAR2(4000),
 CELULAR_SECTORECONOMICO VARCHAR2(4000),
 CELULAR_PRIMERREPORTE VARCHAR2(4000),
 CELULAR_ULTIMOREPORTE VARCHAR2(4000),
 CELULAR_CELULAR VARCHAR2(4000),
 MAIL_NOREPORTES VARCHAR2(4000),
 MAIL_PRIMERREPORTE VARCHAR2(4000),
 MAIL_ULTIMOREPORTE VARCHAR2(4000),
 MAIL_CORREO VARCHAR2(4000)
);

-- create sequence for auto increment id
CREATE SEQUENCE UBICA_DETAIL_ID_SEQ
    START WITH 1
    MAXVALUE 999999999
    MINVALUE 1
    CYCLE
    NOCACHE
NOORDER;

-- create trigger to fetch the sequence while insert into the table
CREATE OR REPLACE TRIGGER UBICA_DETAIL_ID_TRIG
before insert on UBICA_DETAIL
for each row
begin
if inserting then
if :NEW.ID is null then
select UBICA_DETAIL_ID_SEQ.nextval into :NEW.ID from dual;
end if;
end if;
end;
/
