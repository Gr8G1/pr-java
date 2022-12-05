package Gr8G1.prac.database;

public class PrSQL {

  /*
   * # SQL(Structured Query Language)
   *
   * 설치(Mac)
   *  - Mysql Github: https://gist.github.com/nrollr/3f57fc15ded7dddddcc4e82fe137b58e
   *
   * 단일 라인 주석 (Single-line comment)
   *  - '--'
   * 블록 주석 (Multi-line Comment)
   *  - 일반적인 언어에서 제공하는 블록 주석과 동일
   *
   * 데이터 정의 언어(DDL: Data Definition Language)
   *  > SCHEMA, DOMAIN, TABLE, VIEW, INDEX를 정의 또는 변경 삭제 시 사용되는 언어
   *  - CREATE: SCHEMA, DOMAIN, TABLE, VIEW, INDEX 정의
   *  - ALTER: TABLE에 대한 정의 변경
   *  - DROP: SCHEMA, DOMAIN, TABLE, VIEW, INDEX 삭제
   *
   * 데이터 조작 언어(DML: Data Manipulation Language)
   *  > 질의어를 통해 실직적으로 데이터를 처리하는데 사용하는 언어
   *  - SELECT: 데이터 조회
   *  - INSERT: 데이터 삽입
   *  - UPDATE: 데이터 수정
   *  - DELETE: 데이터 삭제
   *
   * 데이터 제어 언어(DCL: Data Control Language)
   *  > 데이터의 보한, 무결성, 회복, 병행 수행 제어 등을 정의하는데 사용하는 언어
   *  - GRANT: 특정 데이터베이스 사용자에게 특정 작업수행 권한 부여
   *  - REVOKE: 특정 데이터베이스 사용자에게 특정 작업수행 권한 회수
   *
   * 트랜잭션 제어어(TCL: Transaction Control Language)
   *  - COMMIT: 트랜잭션 처리가 정상 종료시 수행 내용을 데이터베이스에 반영하는 연산을 수행
   *  - ROLLBACK: 트랜잭션 처리가 비정상적으로 종료되어 일관성이 깨졌을 때, 모든 변경 작업을 취소하고 이전 상태로 되돌리는 연산을 수행
   *  - SAVEPOINT: 트랜잭션 작은 단위로 분활하여 특정 지점을 생성하는 연산을 수행
   *
   * SQL 구문(실행순서)
   *  SELECT DISTINCT 속성명 ----------- (5, 7)
   *    FROM 테이블명 ------------------ (1)
   *      [] JOIN 테이블명 -----------------(2)
   *      ON 조건 -----------------------(3)
   *    WHERE 조건 --------------------- (4)
   *    GROUP BY 속성명 ---------------- (6)
   *    HAVING 그룹 조건 --------------- (7)
   *    ORDER BY 속성명 ---------------- (9)
   *
   * ~ KEYWORDS
   *  CREATE DATABASE 데이터베이스명 CHARACTER SET utf8;
   *  CREATE TABLE 테이블명
   *  (
   *    속성명1 속성1 AUTO_INCREMENT,
   *    속성명2 속성2 NOT NULL,
   *    속성명3 속성3 DEFAULT 기본값
   *    CONSTRAINT 제약조건명 CHECK (속성명1 >= 속성1 AND 속성명2 = '속성2')
   *  );
   *
   *  USE 데이터베이스명;
   *
   *  DROP DATABASE 데이터베이스명;
   *
   *  DROP TABLE IF EXISTS 테이블명;
   *
   *  DROP TABLE 테이블명, ...;
   *
   *  ALTER TABLE 테이블명
   *    ADD CONSTRAINT 제약조건명
   *      PRIMARY KEY (속성명, ...),
   *      FOREIGN KEY (속성명, ...) REFERENCES 테이블명 (테이블 속석명, ...);
   *
   *  ALTER TABLE 테이블명
   *    DROP [CONSTRAINT, COLUMN, PRIMARY KEY, INDEX, VIEW, DEFAULT ...] [...];
   *
   *  ALTER COLUMN 속성명 속성;
   *
   *  BACKUP DATABASE 데이터베이스명
   *    TO DISK = '경로';
   *
   *  SELECT [DISTINCT, TOP 1~] 속성명 AS 별칭, ...
   *    INTO 테이블명
   *    FROM 테이블명
   *    UNION [ALL]
   *    [FULL] [LEFT, RIGHT, OUTER, INNER] JOIN 테이블명
   *    ON 조건
   *    GROUP BY 속성명
   *    HAVING 조건
   *    WHERE 조건 IS [NOT] NULL
   *    ORDER BY 속성명 [ASC, DESC]
   *    LIMIT 1~;
   *
   *  ~ WHERE 속성명 [NOT] LIKE 조건; (_: 공란 / %: 나머지)
   *  ~ WHERE 속성명 [NOT] OR 조건;
   *  ~ WHERE 속성명 [NOT] BETWEEN 조건 [AND] 조건;
   *  ~ WHERE 속성명 [NOT] IN (속성값, ...);
   *  ~ WHERE 속성명 = ANY(SELECT 구문) | ALL(SELECT 구문)
   *    > ANY(SELECT 구문): 하나라도 일치하면 True 반환
   *    > ALL(SELECT 구문): 전체가 일치하면 True 반환
   *
   *  INSERT INTO 테이블명 (`속성명`, ...) VALUES (속성값, ...);
   *
   *  UPDATE 테이블명 SET 속성명 = 속성값 WHERE 조건;
   *
   *  DELETE FROM 테이블명 | TRUNCATE 테이블명;
   *
   * ~ Operators
   *  - 다른 언어에서 제공되는 연산자들 대부분 사용 가능
   *
   * ~ Type
   *  문자
   *    - CHAR(size): 고정길이 문자 - 0 ~ 255 characters
   *    - VARCHAR(size): 가변길이 문자 - 0 ~ 65535 characters
   *    - BINARY(size): CHAR(size) 동일 / 저장 방식 차이 - 2진 문자 (8,000 bytes)
   *    - VARBINARY(size): VARCHAR(size) 동일 / 저장 방식 차기 - 2진 문자 (8,000 bytes)
   *  문자열
   *    - TINYTEXT: 255 characters
   *    - TEXT(size): 65,535 bytes
   *    - MEDIUMTEXT: 16,777,215 characters
   *    - LONGTEXT: 4,294,967,295 characters
   *  블롭(BLOBs(Binary Large Objects))
   *    - TINYBLOB: 255 bytes
   *    - BLOB(size): 65,535 bytes
   *    - MEDIUMBLOB: 16,777,215 bytes
   *    - LONGBLOB: 4,294,967,295 bytes
   *  - ENUM(val, ...)
   *  - SET(val, ...)
   *  비트
   *    - BIT(1~64 - 기본값: 1): 비트값 저장
   *  불리언
   *    - BOOL: 불리언 저장 - 0: false, !0 = true
   *    - BOOLEAN: BOOL과 동일
   *  정수
   *    - TINYINT(size): Signed: -128 ~ 127 / Unsigned: 0 ~ 255
   *    - SMALLINT(size): Signed: -32768 ~ 32767 / Unsigned: 0 ~ 65535.
   *    - MEDIUMINT(size): Signed: -8388608 ~ 8388607 / Unsigned: 0 ~ 16777215
   *    - INT(size): Signed: -2147483648 ~ 2147483647 / Unsigned: 0 ~ 4294967295
   *    - INTEGER(size): INT()와 동일
   *    - BIGINT(size): Signed: -9223372036854775808 ~ 9223372036854775807 / Unsigned: 0 ~ 18446744073709551615
   * 실수
   *    - FLOAT(size, d): deprecated in MySQL 8.0.17
   *    - FLOAT(p): p: 0 ~ 24 = FLOAT() / p: 25 ~ 53 = DOUBLE()
   *    - DOUBLE(size, d)
   *    - DOUBLE PRECISION(size, d)
   *    - DECIMAL(size, d)
   *    - DEC(size, d): DECIMAL(size,d)과 동일
   * 시간(날짜)
   *    - DATE: Format: YYYY-MM-DD
   *    - DATETIME(fsp): Format: YYYY-MM-DD hh:mm:ss
   *    - TIMESTAMP(fsp): Format: YYYY-MM-DD hh:mm:ss / the Unix epoch('1970-01-01 00:00:00' UTC)
   *    - TIME(fsp): Format: hh:mm:ss
   *
   * ~ 내장 함수들
   *  CONUNT()
   *  SUM()
   *  MIN()
   *  MAX()
   *  AVG()
   *  POW()
   *  GETDATE()
   *  SYSDATETIME()
   *  USER_NAME()
   *
   *  - YEAR(GETDATE()) AS 년, MONTH(GETDATE()) AS 월, DAY(GETDATE()) AS 일;
   *
   * ~ 프로그래밍 문법 지원
   *  - PrSQLGrammar 참조
   *
   */
}
