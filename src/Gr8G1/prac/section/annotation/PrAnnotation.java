package Gr8G1.prac.section.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class PrAnnotation {
  /*
   * # 어노테이션(Annotation)
   *
   * 어노테이션
   *  - 표준
   *    - @Override: 해당 메서드가 오버라이드된 메서드라는 것을 명시, 상위 클래스 또는 인터페이스에서 해당 메서드를 찾을 수 없다면 컴파일 에러 발생
   *    - @Deprecated: 해당 메서드가 더 이상 사용되지 않음을 표시
   *    - @FunctionalInterface: 함수형 인터페이스라는 것을 명시
   *      - 함수형 인터페이스는 오직 하나의 추상 메서드만을 포함해야 되는 제약이 있다.
   *    - @SafeVarargs: 가변인자의 매개변수를 사용할 때의 경고 생략
   *    - @SuppressWarnings: 컴파일 경고 생략
   *      - all: 모든 경고 생략
   *      - cast: 캐스트 경고 생략
   *      - dep-ann: 사용불가 어노테이션 사용 경고 생략
   *      - deprecation: @Deprecated 경고 생략
   *      - fallthrough: switch문 break 누락 경고 생략
   *      - finally: 반환하지 않는 finally 블럭 경고 생략
   *      - null: null 분석 경고 생략
   *      - rawtypes: Generic 사용 클래스의 매개 변수가 특정되지 않을때 경고 생략
   *      - unchecked: 검증되지 않은 연산자 경고 생략
   *      - unused: unused 코드 경고 생략
   *  - 메타
   *    - @Documented: 해당 어노테이션을 Javadoc 포함
   *    - @Target: 어노테이션의 적용범위 지정
   *      - PACKAGE: 패키지
   *      - CONSTRUCTOR: 생성자
   *      - ANNOTATION_TYPE: 어노테이션
   *      - PARAMETER: 매개변수
   *      - METHOD: 메서드
   *      - TYPE: 타입(class, interface, enum)
   *      - TYPE_USE: 타입이 사용되는 모든 대상 (Java 8^)
   *      - TYPE_PARAMETER: 타입 매개변수
   *      - FIELD: 필드(멤버변수, 열거형 상수)
   *      - LOCAL_VARIABLE: 지역변수
   *      - MODULE: 모듈 (Java 9^)
   *    - @Inherited: 어노테이션의 상속 지정
   *    - @Retention: 어노테이션의 유지 기간(시간)을 결정
   *      - Retention policy
   *        - SOURCE: *.java 파일 존재, *.class 파일 미존재 (javac 의해 삭제)
   *        - CLASS: *.class 파일 존재, Runtime 미제공 (*기본값*)
   *        - RUNTIME: *.class 파일 존재, Runtime 제공. (자바 reflection으로 선언한 어노테이션에 접근 가능)
   *    - @Repeatable: 어노테이션의 연속적인 적용
   *    - @Native: 어노테이션을 네이티브 코드로 선언
   */

  public static void main(String[] args) {
    // @사용자(커스텀) 어노테이션
    Annotation[] annoType =  B.class.getDeclaredAnnotations();
    for (Annotation a: annoType) System.out.println(((MyCustomAnno) a).name());

    Field[] annoFileds = B.class.getDeclaredFields();
    for (Field f: annoFileds) {
      System.out.println(f.getAnnotation(MyCustomAnno.class).name());
    }
  }
}

class A {
  void start() {}
  @Deprecated
  static void run() {}
}

@MyCustomAnno(name = "B Class")
class B extends A {
  @MyCustomAnno(name = "Java")
  private String name;

  @Override
  void start() {
    super.start();
  }

  @SuppressWarnings("deprecation") // @Deprecated 경고 생략
  public static void main(String[] args) {
    A.run(); // @Deprecated 알림
  }

  public String getName() {
    return name;
  }
}
