package Gr8G1.prac.section.collection;

import java.util.*;

public class PrSet {
  /*
   * # Set<E>
   *
   * Set
   *  - 중복 요소를 포함할 수 없으며 랜덤 액세스를 허용하지 않는다. (저장 순서 보장 X)
   *    > Set 인터페이스로 구현된 클래스: HashSet, TreeSet(완전 이진 트리:ASC), LinkedHashSet
   *
   * Set 인터페이스
   *  - 추가
   *    - boolean add(Object o): 주어진 객체를 추가한다. (저장 성공: true, 중복 발생 저장 실패: false)
   *  - 검색
   *    - boolean contains(Object o): 주어진 객체가 존재 유무 확인
   *    - boolean isEmpty(): Set 값 존재 유무 확인
   *    - Iterator Iterator(): Set을 탐색 할수 있는 Iterator 반환
   *    - int size(): 저장된 값의 수를 반환
   *  - 삭제
   *    - void clear(): Set의 저장된 모든 값 삭제
   *    - boolean remove(Object o): 주어진 객체 삭제
   *
   */

  public static void main(String[] args) {
    // ~ HashSet
    HashSet<String > hash = new HashSet<>();

    hash.add("Java");
    hash.add("Java"); // 중복값 저장 불가
    hash.add("Javascript");

    System.out.println(hash.size());
    for (String s : hash) {
      System.out.println("HashSet: " + s); // 중복값 확인
    }

    // ~ TreeSet
    TreeSet<Integer> tree = new TreeSet<>();
    TreeSet<Integer> newTree = new TreeSet<>();

    tree.add(3);
    tree.add(5);
    tree.add(4);
    tree.add(2);
    tree.add(1);

    newTree.add(4);
    newTree.add(5);
    newTree.add(6);
    newTree.add(7);

    tree.addAll(newTree); // 중복값 4

    System.out.println("tree.size(): " + tree.size());
    System.out.println("tree.first(): " + tree.first());
    System.out.println("tree.last(): " + tree.last());
    System.out.println("tree.higher(1): " + tree.higher(1));
    System.out.println("tree.subSet(2, 5): " + tree.subSet(2, 5));

    for (Integer s : tree) {
      System.out.println("TreeSet: " + s); // ASC(오름차순) 정렬
    }
  }
}
