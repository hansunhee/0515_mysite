DROP TABLE COMMENTS;
DROP TABLE BOARD;
DROP SEQUENCE COMMENTS;
DROP SEQUENCE BOARD;

CREATE TABLE COMMENTS (
  NO NUMBER(20) NOT NULL,
  NAME VARCHAR2(20) NOT NULL, 
  CONTENT VARCHAR2(2000) NOT NULL,
  REG_DATE DATE,
  PRIMARY KEY (NO) 
);

CREATE SEQUENCE COMMENTS_SEQ
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCACHE
NOCYCLE;

CREATE TABLE BOARD (
  NO NUMBER(20) NOT NULL,
  NAME VARCHAR2(20) NOT NULL, 
  TITLE VARCHAR2(50) NOT NULL,
  CONTENT VARCHAR2(2000) NOT NULL,
  REG_DATE DATE,
  HIT NUMBER(20) NOT NULL,
  COMMENTS_NO NUMBER(20),
  PRIMARY KEY (NO),
  FOREIGN KEY (COMMENTS_NO) REFERENCES COMMENTS (NO)
);

CREATE SEQUENCE BOARD_SEQ
INCREMENT BY 1
START WITH 1
MAXVALUE 9999999
NOCACHE
NOCYCLE;
   
SELECT * FROM BOARD;
SELECT * FROM COMMENTS;
SELECT BOARD_SEQ.NEXTVAL FROM DUAL;
SELECT COMMENTS_SEQ.NEXTVAL FROM DUAL;