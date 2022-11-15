package Gr8G1.prac.section.lambda;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

public class PrLambda {
  /*
   * # 람다(Lambda)
   *
   * 람다
   *  - 함수형 프로그래밍 기법이 도입된 Java 문법요소
   *  - @FunctionalInterface 1:1 매핑을 통해 구현
   *
   * 함수형 인터페이스
   *  - java.lang.Runnable
   *      > void run(): 매개변수를 받지않고, 반환값도 없는 함수
   *  - Supplier<T>
   *      > T get(): 매개변수는 없지만, T로 매핑 후 반환한다.
   *  - Function<T, R>
   *      > R apply(T t): T 매개변수를 받아 R로 매핑 후 반환한다.
   *  - BiFunction<T, U, R>
   *      > R apply(T t, U u): T, U 매개변수를 받아 R로 매핑 후 반환한다.
   *  - Consumer<T>
   *      > void accept(T t): T 매개변수를 받지만 반환값은 없다.
   *  - BiConsumer<T, U>
   *      > void accept(T t, U u): T, U 매개변수를 받지만 반환값은 없다
   *  - Predicate<T>
   *      > boolean test(T t): T 매개변수를 받아 boolean(조건식 결과) 반환한다
   *  - BiPredicate<T, U>
   *      > boolean test(T t, U u): T, U 매개변수를 받아 boolean(조건식 결과) 반환한다
   *
   *  - UnaryOperator<T>: Function의 자손 (*단항*)
   *      > T apply(T t): T를 배개변수로 받아 T로 매핑 후 반환한다.
   *  - BinaryOperator<T>: BiFunction의 자손 (*이항*)
   *      > T apply(T t, T t): T, T를 매개변수로 받아 T로 매핑 후 반환한다.
   *
   *  ~ Documents: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
   *
   * 메소드 참조(Methods Reference)
   *  - 클래스이름::메서드이름 || 참조변수::메서드이름
   *
   */
  public enum MinOrMax {
    MAX_SCORE("MAX", v -> v >= 5000 && v < 10000),
    MIN_SCORE("MIN", v -> v >= 3000 && v < 5000),
    ZERO_SCORE("ZERO", v -> v > 0 && v < 3000),
    NONE("NONE", v -> false);

    private final String value;
    private final Predicate<Integer> condition;

    MinOrMax(String value, Predicate<Integer> condition) {
      this.value = value;
      this.condition = condition;
    }

    public static MinOrMax findMinOrMax(int score) {
      return Arrays.stream(MinOrMax.values())
          .filter(v -> v.condition.test(score))
          .findAny()
          .orElse(NONE);
    }
  };

  public static void main(String[] args) {
    MyFunc<String> myFuncString = System.out::println;
    myFuncString.apply("Hello World!");

    Function<String, Integer> checkLeng = String::length;
    System.out.println(checkLeng.apply("Hello World!"));

    System.out.println(MinOrMax.findMinOrMax(9090));;
    System.out.println(MinOrMax.findMinOrMax(4890));;

    Supplier<? extends A>  genA = A::new;
    A newA = genA.get();
    System.out.println("It's " + newA.getClass().getSimpleName());

    Consumer<String> con = t -> System.out.println("문자열의 길이: " + t.length());
    con.accept("문자열의길이");

    UnaryOperator<Integer> unaryOperator = i -> i + 1;
    System.out.println(unaryOperator.apply(100));

    BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2;
    System.out.println(binaryOperator.apply("Ja", "va"));
  }
}

class A {}
