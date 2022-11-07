package Gr8G1.prac.section1.oop;

import java.util.Arrays;

public class PrInheritance {
  /*
   * # 객체 지향 프로그래밍(OOP)
   *
   * 객체 지향 프로그래밍 4대 요소
   *  1. 캡슐화
   *  2. *상속*
   *  3. 추상화
   *  4. 다형성
   *
   */

  /*
   * # 상속
   *
   * 상속(inheritance)이란?
   * - 객체 지향 프로그래밍(OOP)에서 자손 클래스가 조상 클래스의 기능을 그대로 이어받아서 재사용하는 것을 말한다.
   *    자바에서는 계승, 확장(extends)이라는 단어로 사용된다.
   *
   * 다중상속(Multiple inheritance)이란?
   *  - 객체 지향 프로그래밍의 특징 중 하나이며, 어떤 클래스가 하나 이상의 상위 클래스로부터 여러 가지 행동이나 특징을 상속받을 수 있는 것을 말한다.
   *    이런 다중 상속은 한 객체에서 여러 부모의 메소드를 사용하기 위해서 사용하는데 한 객체가 여러 부모 클래스를 가지게 되는 것은 문제가 생긴다.
   *    그 문제를 다이아몬드 문제라고 한다. 이 죽음의 다이아몬드는 D라는 자식 클래스에서 callMethod()이라는 메소드를 사용했다면 A, B, C 중 어느 객체에 접근해 함수를 사용할 것인지 애매한 상황이 생긴다.
   *    그로인해 자바의 경우 *단일 상속만*을 사용한다
   *  > A: 부모 클래스, B,C: A 자식 클래스, D: B,C 자식 클래스
   *
   * 상속 제외 경우 3가지
   *  1. 상속은 부모클래스로부터 멤버변수, 메소드르 상속 받는 것은 가능하지만 *생성자*는 상속이 불가능하다.
   *  2. 접근 제어자가 private로 선언된 멤버변수와 메서드는 상속이 불가능하다.
   *  3. 부모클래스와 자식클래스가 다른 패키지에 존재한다면 default 접근 권한을 갖는 메소드는 상속이 불가능하다.
   *
   * super
   * - 상속(부모 클래스) 객체 접근
   * super()
   *  - 상속(부모 클래스) 객체 생성자 호출
   *  - ! 주의: 생성자의 내부에서만 사용할 수 있다.
   *  - ! 주의: 반드시 생성자의 첫 줄에 위치해야 한다.
   *  - ! 생성자 첫 줄에 super()가 없는 경우 컴파일러가 자동으로 super()를 삽입한다. 이때 상위클래스에 *기본생성자*가 없으면 에러가 발생한다.
   *
   *  메소드 오버라이딩(Method Overriding)
   *  - 상위 클래스로부터 상속받은 메서드와 동일한 이름의 메서드를 재정의하는 것.
   *    - 메소드 오버라이딩 요구조건
   *      1. 상위 클래스의 메소드의 선언부(메서드 이름, 매개변수, 반환타입)가 완전히 일치해야한다.
   *      2. 상위 클래스의 메서드의 접근 제어자의 범위와 같거나 넓어야 한다.
   *      3. 상위 클래스의 메서드보다 많이 선언할 수 없다.
   *
   */

  /*
   * # 포함 관계
   *  - 포함(composite)은 상속처럼 클래스를 재사용할 수 있는 방법으로, 클래스의 멤버로 다른 클래스 타입의 참조변수를 선언하는 것을 의미한다.
   *
   * 상속-포함 관계 설정
   *  - is-a: A~는(은) B~이다. (상속)
   *  - has-a: A~는(은) B~를(을) 가지고 있다. (포함)
   *
   */
  public static void main(String[] args) {
    UnitedStates US = new UnitedStates(new Lang("en"));
    Korea KO = new Korea(new Lang("ko"));
    Seoul SE = new Seoul(new Lang("ko-se"));

    System.out.println(US.lang.lang);
    System.out.println(US.greetings());
    System.out.println(KO.lang.lang);
    System.out.println(KO.greetings());
    System.out.println(KO.consonant);
    System.out.println(SE.lang.lang);
    System.out.println(SE.greetings());
    System.out.println(SE.getGrammer());
  }
}

class Lang {
  String lang;

  public Lang(String lang) {
    this.lang = lang;
  }
}

class UnitedStates {
  Lang lang; // UnitedStates <- Lang 포함 관계

  char[] consonant = {'A', 'B', 'C', 'D'};
  char[] vowel = {'E', 'I', 'O', 'U'};

  public UnitedStates(Lang lang) {
    this.lang = lang;
  }

  public String greetings() {
    return "Hello. :)";
  }
}

class Korea {
  Lang lang; // Korea <- Lang 포함 관계

  char[] consonant = {'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ'};
  char[] vowel = {'ㅏ', 'ㅑ', 'ㅓ', 'ㅕ'};

  public Korea(Lang lang) {
    this.lang = lang;
  }

  public String greetings() {
    return "안녕하세요. :)";
  }
}

class Seoul extends Korea { // Seoul -> Korea = 상속 관계
  public Seoul(Lang lang) {
    super(lang);
  }

  public String greetings() { // 메소드 오버라이딩
    return "반가워요. :)";
  } // 메소드 오버라이딩
  public String getGrammer() {
    return Arrays.toString(super.consonant) + " " + Arrays.toString(super.vowel);
  }
}
