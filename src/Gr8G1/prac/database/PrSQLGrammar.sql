DECLARE @변수명 데이터형식; -- 변수 선언

--

SELECT @변수명;
SET @변수명 = 변수값;

IF 조건 THEN
    -- ...
ELSEIF 조건 THEN
    -- ...
ELSE
    -- ...
END IF;

--

CASE
    WHEN 조건값 THEN 반환값
    -- WHEN - THEN - ...
    ELSE 기본 반환값
END

--

별칭:LOOP
   IF 조건 THEN
    -- 반복 구문 ...
    LEAVE 별칭; -- break
   END IF;
END LOOP;

--

별칭:WHILE 조건 DO
    -- 반복 구문 ...
    ITERATE 별칭 -- continue
END WHILE;

--

별칭:REPEAT
    -- 반복 구문 ...
    LEAVE 별칭; -- break;
END REPEAT;

