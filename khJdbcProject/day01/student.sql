CREATE TABLE STUDENT_TB(
    STUDENT_ID VARCHAR2(15),
    STUDENT_PWD VARCHAR2(15),
    STUDENT_NAME VARCHAR2(20),
    GENDER CHAR(1),
    AGE NUMBER,
    EMAIL VARCHAR2(30),
    PHONE CHAR(11),
    ADDRESS VARCHAR2(500),
    HOBBY VARCHAR2(50),
    ENROLL_DATE DATE
);
-- Table STUDENT_TB이(가) 생성되었습니다.

-- COMMENT추가
COMMENT ON COLUMN STUDENT_TB.STUDENT_ID IS '회원아이디';
COMMENT ON COLUMN STUDENT_TB.STUDENT_PWD IS '회원비밀번호';
COMMENT ON COLUMN STUDENT_TB.STUDENT_NAME IS '회원이름';
COMMENT ON COLUMN STUDENT_TB.GENDER IS '성별';
COMMENT ON COLUMN STUDENT_TB.AGE IS '나이';
COMMENT ON COLUMN STUDENT_TB.EMAIL IS '이메일';
COMMENT ON COLUMN STUDENT_TB.PHONE IS '전화번호';
COMMENT ON COLUMN STUDENT_TB.ADDRESS IS '주소';
COMMENT ON COLUMN STUDENT_TB.HOBBY IS '취미';
COMMENT ON COLUMN STUDENT_TB.ENROLL_DATE IS '가입날짜';

-- STUDENT_ID에 PRIMARY KEY 제약조건 추가
ALTER TABLE STUDENT_TB
ADD CONSTRAINT STUDENT_PK PRIMARY KEY(STUDENT_ID);

-- GENDER에 CHECK 제약조건 추가
ALTER TABLE STUDENT_TB
ADD CHECK(GENDER IN ('M','F'));

-- NOT NULL은 MODIFY로 가능!
-- AGE NOT NULL 제약조건 추가
ALTER TABLE STUDENT_TB
MODIFY AGE NOT NULL;

-- STUDENT_NAME에 NOT NULL 제약조건 추가
ALTER TABLE STUDENT_TB
MODIFY STUDENT_NAME NOT NULL;

-- STUDENT_PWD NOT NULL 제약조건 추가
ALTER TABLE STUDENT_TB
MODIFY STUDENT_PWD NOT NULL;

-- 제약조건 확인
SELECT * FROM USER_CONSTRAINTS;

INSERT INTO STUDENT_TB
VALUES('admin', 'admin', '관리자', 'M', 30, 
'admin@ioi.or.kr', '01022348484', '서울시 중구 남대문로', 
'코딩,독서,운동', sysdate);

INSERT INTO STUDENT_TB
VALUES('khuser01', 'pass01', '일용자', 'M', 21, 
'khuser01@ioi.or.kr', '01092920303', '서울시 종로구', 
'수영,걷기', sysdate);

-- 반드시 커밋해야 자바에서 확인이 가능함!!!
COMMIT;

SELECT * FROM STUDENT_TB;
RENAME STUDENT_TB TO STUDENT_TBL;
SELECT * FROM STUDENT_TBL;