package Gr8G1.prac.section1.collection;

import java.util.*;

public class PrMap {
  /*
   * # Map<K, V>
   *
   * Map
   *  - K(key), V(value)를 매핑하며 중복 키는 존재할 수 없고 각 키는 하나의 값만 매핑할 수 있다.
   *    > 저장된 객체를 Entry 객체라 칭하고, Entry 객체는 K(key), V(value)를 각각 Key 객체와 Value객체로 저장한다.
   *    > Map 인터페이스로 구현된 클래스: HashMap, TreeMap, LinkedHashMap ...
   *
   * Map 인터페이스
   *  - 추가
   *    - V put(K key, V value): 전달된 키에 대응하는 값으로 특정 값을 매핑
   *  - 검색
   *    - boolean containsKey(Object key): 전달된 키를 포함하고 있는지 확인
   *    - boolean containsValue(Object value): 전달된 값에 해당하는 하나 이상의 키를 포함하고 있는지 확인
   *    - V get(Object key): 전달된 키에 대응하는 값을 반환 (대응키값 없을 시 null 반환)
   *    - boolean isEmpty(): 매핑된 값 존재 유무 확인
   *    - Set<K> keySet(): 맵에 포함된 모든 키를 Set 객체로 반환
   *    - int size(): 매핑된 총 개수를 반환
   *  - 삭제
   *    - void clear()	해당 맵의 모든 매칭을 제거함
   *    - V remove(Object key): 전달된 키에 대응하는 매핑을 제거
   *    - boolean remove(Object key, Object value): 특정 값에 대응하는 키의 매핑을 제거
   *  - 제어
   *    - V replace(K key, V value): 전달된 키에 대응하는 값을 특정 값으로 대체함
   *    - boolean replace(K key, V oldValue, V newValue): 특정 값에 대응하는 전달된 키의 값을 새로운 값으로 대체
   *
   */

  public static void main(String[] args) {
    // ~ HashMap
    HashMap<Character, Integer> cHashMap = new HashMap<>();

    for (Character c: "Banana".toCharArray()) {
      /*
       * ! Extract side effect
       * ~: !cHashMap.containsKey(c) ? cHashMap.put(c, 1) : cHashMap.put(c, cHashMap.get(c) + 1);
       *  ->
       * ~: cHashMap.put(c, !cHashMap.containsKey(c) ? 1 : cHashMap.get(c) + 1);
       */
      if (!cHashMap.containsKey(c)) cHashMap.put(c, 1);
      else cHashMap.put(c, cHashMap.get(c) + 1);
    }

    HashMap<String, Integer> hashMap = new HashMap<>();

    System.out.println(cHashMap);

    hashMap.put("Java", 100);
    hashMap.put("Java", 300); // 중복키값 저장 불가
    hashMap.put("Javascript", 100);

    System.out.println("hashMap.size(): " + hashMap.size());
    System.out.println("hashMap.get(\"Java\"): " + hashMap.get("Java"));

    Set<String> keySet = hashMap.keySet();
    for (String key : keySet) {
      Integer value = hashMap.get(key);
      System.out.println("keySet - Key: " +key + ", Value: " + value);
    }

    Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
    for (Map.Entry<String, Integer> entries: entrySet) {
      System.out.println(entries);
      System.out.println("entrySet - Key: " + entries.getKey() + ", Value: " + entries.getValue());
    }

    for (Map.Entry<String, Integer> entries: hashMap.entrySet()) {
      System.out.println(entries);
      System.out.println("entrySet - Key: " + entries.getKey() + ", Value: " + entries.getValue());
    }

    // ~ Hashtable
    Hashtable<String, Integer> hashtable = new Hashtable<>(); // Hashtable <- table *소문자* 주의

    hashtable.put("Java", 100);
    hashtable.put("Java", 100); // 중복키값 저장 불가
    hashtable.put("Javascript", 100);

    Iterator<String> kit = hashtable.keySet().iterator();
    while (kit.hasNext()) {
      System.out.println(kit.next());
    }
  }
}
