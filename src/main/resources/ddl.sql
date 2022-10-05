-- create table
CREATE TABLE UBICA_DETAIL
(ID NUMBER PRIMARY KEY,
 RESPONSE VARCHAR2(4000),
 STATUS NUMBER,
 REQUEST_DATE_TIME TIMESTAMP,
 RESPONSE_DATE_TIME TIMESTAMP
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
