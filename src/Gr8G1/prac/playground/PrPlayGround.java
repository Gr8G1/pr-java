package Gr8G1.prac.playground;

import Gr8G1.prac.playground.datastructure.PrBufferQueue;

import java.util.*;
import java.util.stream.Collectors;

public class PrPlayGround {
  public static ArrayList<Stack> browserStack(String[] actions, String start) {
    ArrayList<Stack> result = new ArrayList<>() {{
      add(new Stack<String>());
      add(new Stack<String>() {{
        add(start);
      }});
      add(new Stack<String>());
    }};

    Stack<String> prevStack = result.get(0);
    Stack<String> current = result.get(1);
    Stack<String> nextStack = result.get(2);

    for (String s: actions) {
      switch (s.codePointAt(0)) {
        case 45: // "-1"
          if (!prevStack.isEmpty()) {
            nextStack.push(current.pop());
            current.push(prevStack.pop());
          }
          break;
        case 49: // "1"
          if (!nextStack.isEmpty()) {
            prevStack.push(current.pop());
            current.push(nextStack.pop());
          }
          break;
        default: // Char
          prevStack.push(current.pop());
          current.push(s);
          nextStack.clear();
          break;
      }
    }

    return result;
  }

  public static int paveBox(Integer[] boxes) {
    List<Integer> pave = new ArrayList<>();
    Integer[] temp = Arrays.copyOfRange(boxes, 0, boxes.length);

    while (temp.length > 0) {
      // ! Variable used in lambda expression should be final or effectively final
      Integer[] fiTemp = temp;
      // 새로운 배열의 참조를 넘겨야 되는 이유?
      // 람다 캡쳐링

      int fv = Arrays.stream(fiTemp).filter(n -> n > fiTemp[0]).findFirst().orElse(-1);
      int fIdx = Arrays.stream(fiTemp).collect(Collectors.toList()).indexOf(fv);

      if (fIdx != -1) {
        pave.add(fIdx);
        temp = Arrays.copyOfRange(fiTemp, fIdx, fiTemp.length);
      } else {
        pave.add(fiTemp.length);
        temp = Arrays.copyOfRange(fiTemp, 0, 0);
      }
    }

    return pave.stream().max(Integer::compare).orElse(1);
  }

  public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
    PrBufferQueue q = new PrBufferQueue(bufferSize);

    int time = 1;
    int docIdx = 0;

    q.push(new int[] {1, documents[docIdx++]});

    while (q.size() > 0) {
      time++;
      q.upBuffer();

      if (q.getBuffer() > bufferSize) q.shift();
      if (docIdx > documents.length - 1) continue;

      int capa = q.capacity();
      int size = q.size();

      if (capacities >= (documents[docIdx] + capa) && bufferSize > size) {
        q.push(new int[] {1, documents[docIdx++]});
      }
    }

    return time;
  }

  public static int pow(int n, int p) {
    if (p == 0) return 1;

    int t = pow(n, p / 2);
    int v = t * t;

    if (p % 2 == 0) { // 짝수
      return v;
    } else {          // 홀수
      return n * v;
    }
  }

  public static boolean po2(int n) {
    // while 연산
    // if (n < 1) return false;
    //
    // while (n > 1) {
    //   if (n % 2 == 0) n /= 2;
    //   else return false;
    // }
    //
    // return true;

    //  (Bit 연산) - (1, 2의 보수의 이해)
    if (n < 1) return false;

    return (n & (n - 1)) == 0;
  }

  public static String firstChar(String str) {
    return Arrays.stream(str.split(" ")).reduce("", (a, c) -> a + c.charAt(0));
  }

  public static void main(String[] args) {
    // # HashMap 초기화
    // System.out.println(
    //   new HashMap<String, String>() {{
    //     put("greeting", "Hello");
    //   }}
    // );

    // // # 72법칙 - 72 / rate
    // int y;
    // double d;
    // double rate = 3.3;
    // for (y = 0, d = 1; d < 2; y++, d = (d + (d * rate / 100.0)));
    // return y;

    // # 거듭제곱의 성질
    // System.out.println(pow(3, 3));

    // # 2의 제곱근
    // System.out.println(p2(8));

    // # paveBox
    System.out.println(paveBox(new Integer[] {5, 2, 3, 4, 6}));

    // # BufferQueue
    // System.out.println(queuePrinter(10, 100, new int[] {10, 10, 10, 10}));

    // # FirstChar
    System.out.println(firstChar("Hello World!"));
  }
}

