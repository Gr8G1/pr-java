-- 프로시저 작성 예시

DELIMITER $$
CREATE PROCEDURE INSERT_BOOK
(
    IN _파라미터 VARCHAR(20),
    _파라미터 VARCHAR(20),
   OUT RESULT INT -- 반환값 설정
)
BEGIN
    DECLARE @변수명 데이터형식; -- 변수 선언

    SET @변수명 = 변수값;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION -- SQL에러 발생시 ROLLBACK
        BEGIN
            ROLLBACK;
        SET RESULT = -1;
    END;

    START TRANSACTION; -- 트랜잭션 시작

    -- SQL 구문 작성
    -- ...

    COMMIT; -- 커밋

    SET RESULT = 1; -- 결과 반환
END $$
DELIMITER ;
