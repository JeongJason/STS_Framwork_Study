CREATE SEQUENCE SEQ_BOARD;

CREATE TABLE TBL_BOARD(
	BNO NUMBER(10) PRIMARY KEY,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	WRITER VARCHAR2(1000) NOT NULL,
	REGDATE DATE DEFAULT SYSDATE,
	UPDATEDATE DATE DEFAULT SYSDATE
);

INSERT INTO TBL_BOARD
(BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE)
VALUES(SEQ_BOARD.NEXTVAL, '테스트 제목2', '테스트 내용2', 'user01', SYSDATE, SYSDATE
);

SELECT * FROM TBL_BOARD ;

INSERT INTO TBL_BOARD (BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE) SELECT SEQ_BOARD.NEXTVAL, TITLE, CONTENT, WRITER, REGDATE , UPDATEDATE FROM TBL_BOARD;


SELECT /*+ INDEX_DESC(TBL_BOARD, SYS_C007001)*/
BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE
 FROM TBL_BOARD;













