package Gr8G1.prac.section.oop;

import java.util.function.Consumer;

public class PrAbstraction {
  /*
   * # 객체 지향 프로그래밍(OOP)
   *
   * 객체 지향 프로그래밍 4대 요소
   *  1. 캡슐화
   *  2. 상속
   *  3. *추상화*
   *  4. 다형성
   *
   */

  /*
   * # 추상화
   *
   * 추상화(Abstraction)란?
   *  - 사전적 의미는 사물이나 표상을 어떤 성질, 공통성, 본질에 착안하여 그것을 추출하여 파악하는 것"이라고 정의된다.
   *    프로그래밍에서의 추상적 개념은 공통성(속성)과 본질(메소드)을 모아 추출하는 것을 의미한다.
   *
   * 추상 클래스(미완성 클래스)
   *  - 추상 메소드를 포함한 클래스
   *  - ! 추상 클래스는 의도적인 미완성 클래스로 완성된 일부를 가질 수 있다.
   *  - ! 추상 클래스를 상속하는 하위 클래스에서 미완성 부분의 구체화를 강제한다.
   *  - ! 추상 클래스는 실체(인스턴스)화 불가능하다.
   *
   *  > abstract class A {
   *      ...
   *      abstract viod explicit(); // -> 추상 메소드(미완성 메소드) 의도적 미완성
   *      ...
   *    }
   *
   *    class B extends A {
   *      viod explicit() { ... } // -> 미완성 메소드 구체화
   *    }
   *
   * 인터페이스(interface)
   *  - 사전적 의미는 "-간/사이"를 뜻하는 inter와 "얼굴/면"을 의미하는 face의 결합으로 구성된 단어로, 두 개의 다른 대상 사이를 연결한다는 뜻이다.
   *    프로그래밍에서의 인터페이스는 서로 다른 두 시스템, 장치, 소프트웨어 따위를 서로 이어주는 부분 또는 그런 접속 장치를 의미한다.
   *  - 추상 메소드의 집합이다.
   *  - 상속의 개념과 동일하지만 "구현하다"라는 의미를 가진 implements 키워드를 사용한다.
   *  - *서로 관계없는* 클래스들의 관계를 맺어줄 수 있다.
   *  - 인터페이스 내부 정보
   *    - 모든 필드는 public static final로 정의된다.
   *    - static, default 메소드를 제외한 나머지는 public abstract로 정의된다.
   *  - ! 인터페이스를 구현하는 하위 클래스에서 미완성 부분의 구체화를 강제한다.
   *  - ! 인터페이스는 다중 상속이 가능하다. (단 인터페이스 -> 인터페이스로의 상속만 가능)
   *
   *  > interface A {
   *      public static final float PI = 3.14F;
   *      static final float PI = 3.14F;
   *      final float PI = 3.14F;
   *      > 상동
   *      float PI = 3.14F;
   *
   *      public abstract explicit();
   *      abstract explicit();
   *      > 상동
   *      explicit();
   *
   *      default void defaultMethod() {
   *        ... 구현부를 가질 수 있다.
   *      }
   *
   *      static void staticMethod() {
   *        ... 구현부를 가질 수 있다.
   *      }
   *    }
   */
  public static void main(String[] args) {
     C c = new C();

     c.to();;
  }
}

interface A {
  void to();
}

interface B {
  void to();
}

class C implements A, B {
  @Override
  public void to() {
    System.out.println("It's implements A, B to");
  }
}