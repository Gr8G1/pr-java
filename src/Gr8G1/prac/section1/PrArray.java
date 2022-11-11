package Gr8G1.prac.section1;

import java.util.*;

public class PrArray {
  /*
   * # 배열(Array)
   *  - 1차원 배열
   *    - 타입[] 배열이름 = new 타입[배열길이];
   *    - 타입[] 배열이름 = new 타입[] { ... };
   *    - 타입[] 배열이름 = { ... };
   *  - 2차원 배열
   *    - 타입[][] 배열이름 = new 타입[배열길이][];
   *    - 타입[][] 배열이름 = new 타입[배열길이][] {{ ... }, { ... }};
   *  - 가변 배열(dynamic array)
   *    - Java에서 2차원 배열을 생성시 열의 길이를 명시하지 않음으로써, 행마다 다른 길이의 배열을 요소로 저장할 수 있다.
   *
   * ! 주의: 배열의 길이(선언, 초기화)에 항상 유념하도록 하자.
   *
   */
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4, 5}; // Java Array indexOf 미제공
    ArrayList<Integer> newArr = new ArrayList<>(Arrays.asList(arr)); // ArrayList <-> List 변환 후 사용

    System.out.println(newArr.indexOf(1));

    // Array.stream
    String[] strings = {"1", "2", "3"};
    int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
  }
}
