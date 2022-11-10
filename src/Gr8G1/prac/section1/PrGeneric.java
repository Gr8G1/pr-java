package Gr8G1.prac.section1;

import java.util.Arrays;
import java.util.List;

public class PrGeneric {
  /*
   * # 제네릭(Generic)
   *
   * 제네릭(Generic)이란?
   *  - 컴파일시 타입 체크를 해주는 기능 (JDK.1.5^)
   *    > *런타임 타입 체크*를 **컴파일 단계**로 끌어올린것
   *
   * 제네릭 클래스
   *  - static 키워드를 가질 수 없다. (메모리 생성 시점에 제네릭 타입을 정의 할 수 없기때문)
   *
   * 제네릭 메소드
   *  - static 키워드를 가질 수 있다.
   *  - 제네릭 타입의 변수는 지역 변수 처럼 동작한다.
   *
   * 와일드 카드 (범위 제한)
   *  - <? extends T>: 상한 제한 -> T 자신을 포함한 상속받는 하위 클래스 타입만 허용 (Upper-bound)
   *  - <? super T>: 하한 제한 -> T 자신을 포함한 상위 클래스 타입만 허용 (Lower-bound)
   *  - <?>: 모든 타입 허용 (<? extneds Object> 와 같다)
   *  - ! 주의: interface의 구현도 extends를 사용한다 (implements X)
   *
   * 제네릭 타입 컨벤션
   *  - E: Element
   *  - K: Key
   *  - N: Number
   *  - T: Type
   *  - V: Value
   *  - S, U, V: 2nd, 3rd, 4th types
   *
   * PECS : "Producer Extends, Consumer Super"
   *  - 소비자: ? super (쓰기)
   *  - 생산자: ? extends (읽기)
   *
   */
}

class Box<T> {
  private T meterial;

  public Box() {}
  public Box(T meterial) {
    this.meterial = meterial;
  }

  public T getMeterial() {
    return meterial;
  }
}

class GlassBox<T> extends Box<T> { // 상위 클래스 Box<T>: 일반화(가변형) 선언
  public GlassBox(T meterial) {
    super(meterial);
  }

  public static void main(String[] args) {
    List<Box<Integer>> list = Arrays.asList(
        new GlassBox<>(100),
        new GlassBox<>(80)
    );

    Printer.printSuperBox(list);
    Printer.printExtendsBox(list);
  }
}

class PlasticBox extends Box<String> { // 상위 클래스 Box<String> : 명시적 제네릭 타입 선언
  public PlasticBox(String meterial) { // 상위 클래스의 명시적 제네릭 타입 선언에 맞춰 하위 클래스 생성자의 매개변수 타입 지정
    super(meterial);
  }

  public static void main(String[] args) {
    List<Box<String>> list = Arrays.asList(
        new PlasticBox("Plastic recyle 100%"), // 컴파일 단계에서 제네릭 타입 유추 가능 <String> -> <> : 타입 생략
        new PlasticBox("Plastic recycle 80%")  // 컴파일 단계에서 제네릭 타입 유추 가능 <String> -> <> : 타입 생략
    );

    Printer.printSuperBox(list); // 제네릭 메소드 <T> 생략 : 컴파일 단계에서 제네릭 타입 유추 가능
    Printer.printExtendsBox(list); // 제네릭 메소드 <T> 생략 : 컴파일 단계에서 제네릭 타입 유추 가능
  }
}

class Printer {
  public static <T> void printSuperBox(List<? super Box<T>> list) { // 제네릭 타입을 매개변수로 받는 흔하지 않은 시그니처 선언 방식
    list.set(0, (Box<T>) new Box<Integer>(1)); // 억지로 맞춘 형 변환
  }

  public static <T> void printExtendsBox(List<? extends Box<T>> list) {
    for (Box<T> b : list) {
      System.out.println(b.getMeterial());
    }
  }
}
