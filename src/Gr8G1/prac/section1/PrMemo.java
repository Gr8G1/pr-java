package Gr8G1.prac.section1;

import java.util.Date;

public class PrMemo {
    /*
     * # Java Sepc: https://docs.oracle.com/javase/specs/jls/se13/html/index.html
     */

    /*
     * # 이스케이프 시퀀스
     *
     * \a: 경고음
     * \b: 백스페이스
     * \t: 수평 탭
     * \r: 복귀 (Carriage return)
     * \n: 개행 (Line Feed)
     * \v: 수직 탭 (프린트 전용)
     * \f: 페이지 나누기(폼 피드) (프린트 전용)
     * \\: \
     * \ooo: 8진수 표기 (ASCII)
     * \xhh: 16진수 표기 (ASCII)
     * \xhhh: 16진수 표기(유니코드)
     *
     */

    /*
     * # 포맷 (개략)
     *
     * %n: 개행
     * %b: 불리언
     * %c: 문자
     * %s: 문자열
     * %d: 정수 (10진법 표기)
     * %f: 실수
     * %e: 지수
     * %u: 부호 없는 정수
     * %o: 8진수 (octal)
     * %i: 10진수 (decimal)
     * %x: 16진수 (hexadecimal)
     * %t: 날짜/시간
     * %%: % (프린트)
     * \%: % (프린트)
     *
     * ! [%공간.표기개수]:개별 설정 가능
     * ! '<' or '{n}$': 재사용 플래그
     *
     * ~ 참조: http://www.java2s.com/Tutorials/Java/Java_Format/index.htm
     *
     */

    /*
     * # 파일 권한 설정 (Unix 기반)
     * ~ 참조: https://kb.iu.edu/d/abdb
     */

    /*
     * # 삼항 (Document)
     *
     * ! 삼항 연산자 사용시 주의사항
     * 조건신 ? 피연산1 : 피연산2;
     *
     * 피연산1과 피연산2의 타입(형) 다른 경우 조건 표현식의 타입을 결정하는 부분은 크게 아래 3가지 경우로 결정된다.
     *
     * 1. boolean: 1과 2의 타입이 불리언 인 경우 타입은 불리언이 된다.
     * 2. numeric: 1과 2의 타입이 numeric 인 경우 타입은 BNP(Binary Numeric Promotion) 의해 결정된다.
     *      BNP
     *       1. 레퍼런스 언박싱
     *       2. bnp(피연산자1, 피연산자2): double > float > long > int
     * 3. 그 외: LUB(Least Upper Bound) 의해 결정된다.
     *
     * ~ 참조: https://docs.oracle.com/javase/specs/jls/se13/html/jls-15.html#jls-15.25
     *
     */

    static boolean containsWhitespace(String str) {
        return str.matches(".*\\s.*");
    }

    public static void main(String[] args) {
        System.out.printf("[%15s] %d%n", "ABC", 123456);
        System.out.printf("[%-15s]%n", "ABC");

        System.out.printf("[%d]%n", 123456);

        System.out.printf("[%15.2f]%n", 1.23456);
        System.out.printf("[%15.2f]%n", 12.3456);

        Date date = new Date();

        System.out.printf("%tF-%<tT%n", date);
        System.out.printf("%tF-%1$tT%n", date);
        System.out.println();

        String[] testStrings = {"test", " test", "te st", "test ", "te   st", " t e s t ", " ", "", "\ttest"};
        for (String eachString : testStrings) {
            System.out.println( "Does \"" + eachString + "\" contain whitespace? " + containsWhitespace(eachString));
        }
    }
}
