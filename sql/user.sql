drop table member;
drop sequence member_no_seq;

CREATE TABLE member
( 
no        NUMBER(8),
name      VARCHAR2(30),
email     VARCHAR2(80),
password  VARCHAR2(30),
gender    VARCHAR2(10)
) ;

ALTER TABLE member
ADD ( CONSTRAINT member_no_pk PRIMARY KEY ( no ) );


CREATE SEQUENCE member_no_seq
 START WITH     1
 INCREMENT BY   1
 MAXVALUE       99999999
 NOCACHE
 NOCYCLE;
 
 COMMIT;
 
 SELECT MEMBER_NO_SEQ.NEXTVAL FROM DUAL;
 SELECT * FROM MEMBER;
 delete from member where no=5;
 INSERT INTO MEMBER VALUES(MEMBER_NO_SEQ.NEXTVAL, 'hansunhee', 'hansunhee@samsung.com', '1234', 'female');
 UPDATE MEMBER SET GENDER='male' WHERE EMAIL = 'hansunhee@samsung.com';