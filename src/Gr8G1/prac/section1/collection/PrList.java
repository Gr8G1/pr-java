package Gr8G1.prac.section1.collection;

import java.util.*;

public class PrList {
  /*
   * # List<E>
   *
   * List
   *  - 순서(index)가 있는 컬렉션이며 중복 요소를 포함할 수 있다.
   *  > List 인터페이스로 구현된 클래스: ArrayList, LinkedList(ArrayList 성능 보완), Vector, Stack
   *
   * List 인터페이스
   *  - 추가
   *    - void add(int index, Object el): 주어진 인덱스에 객체 추가
   *    - boolean addAll(int index, Collection c): 주어진 인덱스에 컬렉션 추가
   *    - Object set(int index, Object el): 주어진 위치에 객체 저장
   *  - 검색
   *    - Object: get(int index): 주어진 인덱스 저장된 객체를 반환
   *    - int	indexOf(Object o): 정방향 탐색, 주어진 객체 위치 반환
   *    - int lastIndexOf(Object o): 역방향 탐색, 주어진 객체 위치 반환
   *    - List subList(int fromIndex, int toIndex): fromIndex부터 toIndex에 있는 객체 반환
   *    - ListIterator listIterator(): List를 탐색할 수 있는 ListIterator 반환
   *    - ListIterator listIterator(int index): 주어진 index부터 List를 탐색할 수 있는 ListIterator 반환
   *  - 삭제
   *    - Object remove(int index): 주어진 인덱스에 저장된 객체 삭제, 삭제된 객체 반환
   *    - boolean remove(Object o): 주어진 객체 삭제
   *  - 정렬
   *    - void sort(Comparator c): 주어진 비교자(comparator)로 List를 정렬
   *
   * ArrayList VS LinkedList
   *  - ArrayList: *(인덱스 순차 나열)* - 검색(O(n)), 순회(O(n)), 나열(O(n)) 유리
   *  - LinkedList: *(Prev, Next 연결형)* - 추가(O(1)) 삭제(O(1)) 유리
   *
   */

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); // 5의 저장 공간 선언 (한번 지정된 공간을 늘릴 수 없다.)
    // list.add(0, 5); // RuntimeError: UnsupportedOperationException -> 저장 공간을 늘릴 수 없다.
    list.set(0, 5); // OK

    for (Integer l: list) {
      System.out.println("List: " + l);
    }

    ArrayList<Integer> a10List = new ArrayList<>(); // initialCapacity 없이 선언하면 10의 기본 저장 공간을 갖는다.

    while (a10List.size() < 10) {
      a10List.add(a10List.size());
    }

    for (Integer l: a10List) {
      System.out.println("For loop: " + l);
    }

    for (Iterator<Integer> it = a10List.iterator(); it.hasNext();) {
      Integer l = it.next();
      System.out.println("Iterator loop: " + l);
    }

    LinkedList<Integer> lkList = new LinkedList<>();

    while (lkList.size() < 10) {
      lkList.add(lkList.size());
    }

    for (Integer l: lkList) {
      System.out.println("For loop: " + l);
    }

    for (Iterator<Integer> it = lkList.iterator(); it.hasNext();) {
      Integer l = it.next();
      System.out.println("Iterator loop: " + l);
    }
  }
}
