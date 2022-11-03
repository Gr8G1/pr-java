package Gr8G1.prac.memo;

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
   * # 메모리 구조
   *
   * 낮은 주소(low memory)    ----------메모리---------
   *                        |    클래스/클래스 변수    | (메소드 영역)
   *                        |      객체 인스턴스      | (힙 영역)
   *                        |                      |    ||
   *                        |   메소드(지역/매개)변수   | (스택 영역)
   * 높은 주소(high memory)   ------------------------
   *
   * 모든 자바 프로그램은 자바 가상 머신(JVM)을 통해서 실행됩니다.
   * 자바 프로그램이 실행되면, JVM은 운영 체제로부터 해당 프로그램을 수행할 수 있도록 필요한 메모리를 할당받습니다.
   * 이렇게 할당받은 메모리를 JVM은 용도에 따라 다음과 같이 구분하여 관리합니다.
   *
   * ~ 메소드(method): 자바 프로그램에서 사용되는 클래스에 대한 정보와 함께 클래스 변수(static variable)가 저장되는 영역
   * JVM은 자바 프로그램에서 특정 클래스가 사용되면 해당 클래스의 클래스 파일(*.class)를 읽어들여, 해당 클래스에 대한 정보를 메소드 영역에 저장합니다.
   *
   * ~ 힙(heap) 영역: 자바 프로그램에서 사용되는 모든 인스턴스 변수가 저장되는 영역
   * JVM은 자바 프로그램에서 new 키워드를 사용하여 인스턴스가 생성되면, 해당 인스턴스의 정보를 힙 영역에 저장합니다.
   * 힙 영역은 메모리의 낮은 주소에서 높은 주소의 방향으로 할당됩니다.
   *
   * ~ 스택(stack) : 자바 프로그램에서 메소드가 호출될 때 메소드의 스택 프레임이 저장되는 영역
   * JVM은 자바 프로그램에서 메소드가 호출되면, 메소드의 호출과 관계되는 지역 변수와 매개변수를 스택 영역에 저장합니다.
   * 이렇게 스택 영역은 메소드의 호출과 함께 할당되며, 메소드의 호출이 완료되면 소멸합니다.
   * 이렇게 스택 영역에 저장되는 메소드의 호출 정보를 스택 프레임(stack frame)이라고 합니다.
   *
   * 스택은 푸시(push) 데이터 저장, 팝(pop) 데이터를 인출 이후 후입선출(LIFO, Last-In First-Out) 방식에 따라 동작한다.
   * 메모리의 높은(아래) 주소에서 낮은(위) 주소의 방향으로 할당한다.
   *
   */

  public static void main(String[] args) {
    System.out.printf("[%15s] %d%n", "ABC", 123456);
    System.out.printf("[%-15s]%n", "ABC");

    System.out.printf("[%d]%n", 123456);

    System.out.printf("[%15.2f]%n", 1.23456);
    System.out.printf("[%15.2f]%n", 12.3456);

    Date date = new Date();

    System.out.printf("%tF-%<tT%n", date);
    System.out.printf("%tF-%1$tT%n", date);
  }
}
