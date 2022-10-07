-- create table
CREATE TABLE UBICA_DETAIL
(ID NUMBER PRIMARY KEY,
 REQ_USUARIO VARCHAR2(4000),
 REQ_FECHACONSULTA VARCHAR2(4000),
 CODIGOCIIU VARCHAR2(4000),
 CODIGO_DEPARTAMENTO VARCHAR2(4000),
 CODIGO_MUNICIPIO VARCHAR2(4000),
 CODIGO_TIPO_INDENTIFICACION VARCHAR2(4000),
 ENTIDAD VARCHAR2(4000),
 ESTADO VARCHAR2(4000),
 FECHA VARCHAR2(4000),
 FECHA_EXPEDICION VARCHAR2(4000),
 HORA VARCHAR2(4000),
 IDENTIFICADOR_LINEA VARCHAR2(4000),
 LUGAR_EXPEDICION VARCHAR2(4000),
 NOMBRE_CIIU VARCHAR2(4000),
 NOMBRE_TITULAR VARCHAR2(4000),
 NUMERO_IDENTIFICACION VARCHAR2(4000),
 RANGO_EDAD VARCHAR2(4000),
 RESPUESTA_CONSULTA VARCHAR2(4000),
 TERCERO VARCHAR2(4000),
 TIPO_IDENTIFICACION VARCHAR2(4000),
 UBICA_PLUS_CIFIN VARCHAR2(4000)
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
