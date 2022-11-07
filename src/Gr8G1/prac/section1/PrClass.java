package Gr8G1.prac.section1;

public class PrClass {
  /*
   * # 메모리 구조
   *
   * 낮은 주소(low memory)    ----------메모리---------
   *                        |    클래스/클래스 변수    | (메소드 영역)
   *                        |      객체 인스턴스      |  (힙 영역)
   *                        |                      |     ||
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
   * 스택은 푸시(push) 데이터 저장, 팝(pop) 데이터를 인출 이후 후입선출(LIFO, Last-In First-Out) 방식에 따라 동작한다.
   * 메모리의 높은(아래) 주소에서 낮은(위) 주소의 방향으로 할당한다.
   *
   */

  /*
   * # 필드 타입별 초기화 정보
   *
   *  > [타입: 초기화값]
   *  - byte: 0
   *  - char: \u0000(빈 공백)
   *  - short: 0
   *  - int: 0
   *  - long: 0
   *  - float: 0.0F
   *  - double: 0.0
   *  - boolean: false
   *  - 참조형(Array/Class/interface): null
   *
   */

  /*
   * # 클래스(Class)
   *
   * 구성 요소
   *  - 필드(field) - (Member)
   *    - 클래스 변수
   *      - 초기화 여부: O
   *      - 생성시기: 클래스가 메모리에 올라갈때
   *      - 소멸시기: 프로그램이 종료될때
   *      - 저장 메모리: Method 영역
   *    - 인스턴스 변수
   *      - 초기화 여부: O
   *      - 생성시기: 인스턴스가 생성될 때
   *      - 소멸시기: 인스턴스가 소멸할 때
   *      - 저장 메모리: Heap 영역
   *    - 지역 변수
   *      - 초기화 여부: X
   *      - 생성시기: 블록({}) 내에서 변수 선언문이 실행될 때
   *      - 소멸시기: 블록({})을 벗어날 때
   *      - 저장 메모리: Stack 영역
   *  - 메소드(method)
   *    - 시그니처
   *      - [접근 제어자] [static] [final] 타입 이름 [= 초기화 값];
   *    - 메소드 오버로딩 요구조건
   *        1. 메소드의 이름이 같아야 한다.
   *        2. 매개변수의 개수 또는 타입이 달라야 한다.
   *  - 생성자(constructor)
   *    - 생성자는 오버로딩이 가능하다.
   *    - 생성자 미 선언시 자동 생성된다.
   *    - 생성자 명은 클래스명과 동일해야 한다.
   *    - 인스턴스 변수의 초기화에 사용된다.
   *  - 중첩 클래스(nested)
   *  - 내부 클래스(inner)
   *  - 지역 클래스(local)
   *
   * ~ 생성자를 제외한 나머지 3가지 요소를 클래스 멤버(member)라 칭한다.
   *
   * this
   *  - 모든 메서드에는 자신이 포함된 클래스의 객체를 가리키는 "this" 라는 참조변수가 존재한다.
   *  - "this"는 멤버 변수 접근시 생략 가능하나 필드명과 지역변수를 구분하기 위한 용도로 사용 권장.
   *
   * this()
   *  - 생성자 상호(추가) 호출에 사용된다.
   *  - ! 주의: 생성자의 내부에서만 사용할 수 있다.
   *  - ! 주의: 반드시 생성자의 첫 줄에 위치해야 한다.
   *  - ! 생성자 첫 줄에 this()가 없는 경우 컴파일러가 자동으로 this()를 삽입한다. 이때 클래스에 *기본생성자*가 없으면 에러가 발생한다.
   *
   */

  PrClass() { // 생성자
    this("생성자를 호출합니다."); // 생성자 호출
  }
  PrClass(String s) { // 생성자 오버로딩
    System.out.println(s);
  }

  static String sf = "static field"; // 필드 (클래스 변수)
  String instf = "instance field"; // 필드 (인스턴스 변수)

  static void sClassMethod() {} // 메소드 (클래스 메소드)
  void iMethod() { // 메소드 (인스턴스 메소드)
    String instf = "local";

    System.out.println(this.instf); // -> "instance field"
    System.out.println(instf); // -> "local"
  }
  void iMethod(int i) {} // 메소드 오버로딩

  static class nClass {} // 중첩 클래스
  class iClass {} // 이너 클래스

  public static void main(String[] args) {
    PrClass iPrClass = new PrClass(); // 인스턴스화
    PrClass.nClass nClass = new PrClass.nClass(); // 중첩 클래스 인스턴스화
    PrClass.iClass iClass = iPrClass.new iClass(); // 내부 클래스 인스턴스화

    System.out.println(iPrClass);
    System.out.println(nClass);
    System.out.println(iClass);
  }
}
