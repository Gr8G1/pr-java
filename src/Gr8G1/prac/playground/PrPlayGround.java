package Gr8G1.prac.playground;

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

    for (String s : actions) {
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

  public static Integer boardGame(int[][] board, String operation) {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};
    int sRow = 0;
    int sCol = 0;
    int score = 0;

    Game: while (operation.length() > 0) {
      char c = operation.charAt(0);
      operation = operation.substring(1);

      switch (c) {
        case 'D':
          sRow = sRow + dir[0][0];
          sCol = sCol + dir[0][1];
          break;
        case 'U':
          sRow = sRow + dir[1][0];
          sCol = sCol + dir[1][1];
          break;
        case 'R':
          sRow = sRow + dir[2][0];
          sCol = sCol + dir[2][1];
          break;
        case 'L':
          sRow = sRow + dir[3][0];
          sCol = sCol + dir[3][1];
          break;
        default:
          return null;
      }

      if (sRow < 0 || sRow > board.length || sCol < 0 || sCol > board.length) return null;
      if (board[sRow][sCol] != 0) score += board[sRow][sCol];

    }

    return score != -1 ? score : null;
  }

  public static int coinChangeDP(int coins[], int leng, int sum) {
    if (sum == 0) return 1;
    if (sum < 0 || leng <= 0) return 0;

    return coinChangeDP(coins, leng - 1, sum) + coinChangeDP(coins, leng, sum - coins[leng - 1]);
  }

  public static long ocean(int target, int[] type) { // CoinChange Algorithm
    long[] table = new long[target + 1];
    Arrays.fill(table, 0);

    table[0] = 1;

    for (int k : type)
      for (int j = k; j <= target; j++)
        table[j] += table[j - k];

    // d[i][j] = d[i-1][j] (0 <= j < cost[i]) = d[i][j-cost[i]] + d[i-1][j] (cost[i] <= j)

    return table[target];
  }

  public static ArrayList<String[]> rockPaperScissors(int rounds) {
    ArrayList<String[]> result = new ArrayList<>();
    String[] p = {"rock", "paper", "scissors"};

    getPwr(0, rounds, p, new String[rounds], result);

    return result;
  }

  public static void getPwr(int s, int r, String[] p, String[] selected, ArrayList<String[]> result) {
    if (s == r) {
      result.add(Arrays.copyOfRange(selected, 0, selected.length));
      return;
    }

    for (String v: p) {
      selected[s] = v;
      getPwr(s + 1, r, p, selected, result);
    }
  }

  public static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
    ArrayList<Integer[]> result = new ArrayList<>();
    int[] arr = Arrays.stream(stuffArr).filter(n -> Integer.toString(n).replace(String.valueOf('1'), "").length() < 3).toArray();
    Arrays.sort(arr);

    if (stuffArr.length <= choiceNum) return null;

    getP(0, choiceNum, arr, new boolean[arr.length], new Integer[choiceNum], result);

    System.out.println(Arrays.deepToString(result.toArray()));

    return result;
  }

  public static void getP(int s, int r, int[] arr, boolean[] visited, Integer[] selected, ArrayList<Integer[]> result) {
    if (s == r) {
      result.add(Arrays.copyOfRange(selected, 0, selected.length));
      return;
    }

    for (int i = 0; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected[s] = arr[i];
        getP(s + 1, r, arr, visited, selected, result);
        visited[i] = false;
      }
    }
  }

  public static int boringBlackjack(int[] cards) {
    ArrayList<Integer> result = new ArrayList<>();
    int primeCount = 0;

    getC(0, 0, 3, cards, new boolean[cards.length], new int[cards.length], result);

    System.out.println(Arrays.deepToString(result.toArray()));
    for (Integer i: result) if (isPrime(i)) primeCount++;

    System.out.println(primeCount);

    return primeCount;
  }

  public static void getC(int s, int d, int r, int[] arr, boolean[] visited, int[] selected, ArrayList<Integer> result) {
    if (d == r) {
      result.add(Arrays.stream(selected).sum());
      return;
    }

    for (int i = s; i < arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        selected[d] = arr[i];
        getC(i + 1, d + 1, r, arr, visited, selected, result);
        visited[i] = false;
      }
    }
  }

  public static boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) if (num % i == 0) return false;
    return true;
  }

  public static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
    // [직원수, M, N]
    ArrayList<Integer[]> result = new ArrayList<>();
    int gcd = GCD(M, N);

    for (int i = 1; i <= gcd; i++) {
      if (gcd % i == 0 ) result.add(new Integer[] {i, M / i, N / i});
    }

    System.out.println(Arrays.deepToString(result.toArray()));

    return result;
  }

  public static int GCD(int a, int b) {
    return a % b != 0 ? GCD(b, a % b) : b;
  }

  public static int LCM(int a, int b) {
    return a * b / GCD(a, b);
  }

  public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
    ArrayList<String[]> result = new ArrayList<>();

    Arrays.sort(sideDishes);

    powerset(new String[] {}, sideDishes, 0, result);

    result.sort((a, b) -> {
      if (a.length == 0 || b.length == 0) return 0;
      return -1;
    });

    return result;
  }

  public static void powerset(String[] subset, String[] arr, int idx, ArrayList<String[]> result) {
    if (idx == arr.length) {
      result.add(subset);
      return;
    }

    // 부분집합 미포함
    powerset(subset, arr, idx + 1, result);

    // 부분집합 포함
    // concat(subset, new String[] { arr[idx] });
    String[] b = new String[subset.length + 1];

    System.arraycopy(subset, 0, b, 0, subset.length);
    System.arraycopy(new String[] { arr[idx] }, 0, b, subset.length, 1);

    powerset(b, arr,idx + 1, result);
  }

  public static int ruleOf72(double rate) {
    // t = {ln(2)/ln(1+r/100) ~ approx 72/r
    int y;
    double d;
    for (y = 0, d = 1; d < 2; y++, d = (d + (d * rate / 100.0))) ;

    return y;
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

  public static String reverseString(String str) { return new StringBuilder(str).reverse().toString(); }

  public static String letterCapitalize(String str) {
    String[] strArr = Arrays.stream(str.split(" "))
        .map(s -> !s.equals("")
            ? Character.toUpperCase(s.charAt(0)) + s.substring(1)
            : ""
        )
        .toArray(String[]::new);

    return String.join(" ", strArr);
  }

  public static HashMap<String, String> convertListToHashMap(String[][] arr) {
    return arr.length != 0
      ? new HashMap<>() {{
          for (String[] toHash: arr) if (!this.containsKey(toHash[0])) put(toHash[0], toHash[1]);
        }}
      : new HashMap<>();
  }

  public static String convertDoubleSpaceToSingle(String str) {
    return str.replaceAll("\\s{2}?", " ");
  }

  public static boolean ABCheck(String str) {
    return str.matches("(?i).*?a(.{3})b.*?") || str.matches("(?i).*?b(.{3})a.*?");
  }

  public static String insertDash(String str) {
    if (str.length() == 0) return null;
    if (str.length() == 1) return str;

    StringBuilder nStr = new StringBuilder();
    String[] sStr = str.split("");

    for (int i = 0; i <= sStr.length - 2; i++) {
      int prev = Integer.parseInt(sStr[i]);
      int next = Integer.parseInt(sStr[i + 1]);

      nStr.append(prev);

      if (prev % 2 != 0 && next % 2 != 0) nStr.append("-");
      if (i == sStr.length - 2) nStr.append(next);
    }

    return nStr.toString();
  }

  public static String[] removeExtremes(String[] arr) {
    if (arr.length == 0) return null;

    int[] min = new int[] {-1, Arrays.stream(arr).mapToInt(String::length).min().orElse(-1)};
    int[] max = new int[] {-1, Arrays.stream(arr).mapToInt(String::length).max().orElse(-1)};

    for (int i = 0; i < arr.length; i++) {
      if (min[1] == arr[i].length()) min[0] = i;
      if (max[1] == arr[i].length()) max[0] = i;
    }

    arr[min[0]] = "__remove__";
    arr[max[0]] = "__remove__";

    return Arrays.stream(arr).filter(n -> !n.equals("__remove__")).toArray(String[]::new);
  }

  public static int[] reverseArr(int[] arr) {
    int[] reverse = new int[arr.length];

    for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) reverse[j] = arr[i];

    // swap
    // for (int i = 0, t, n = arr.length - 1; i < arr.length / 2; i++) {
    //   t = arr[i];
    //   arr[i] = arr[n - i];
    //   arr[n - i] = t;
    // }

    return reverse;
  }

  public static String readVertically(String[] arr) {
    // 1 2 3 - 0 1 2 - 14 25 36
    // 4 5 6 - 1 3 5 - 147 258 369
    // 7 8 9 - 2 5 8 - 1470 258- 369=
    // 0 - = - 3 7 11

    // for (int i = 1; i < arr.length; i++) {
    //   for (int j = 0, p = i ; j < arr[i].length(); j++, p++) {
    //     try {
    //       str.insert(j == 0 ? p : (p + (i * j)), arr[i].charAt(j));
    //     } catch (Exception e) {
    //       str.append(arr[i].charAt(j));
    //     }
    //   }
    // }
    //
    // return str.toString();
    int maxLength = 0;
    for (String s : arr) if (maxLength < s.length()) maxLength = s.length();

    String[] temp = new String[maxLength];

    for (String str : arr) {
      for (int j = 0; j < str.length(); j++) {
        if (temp[j] == null) temp[j] = Character.toString(str.charAt(j));
        else temp[j] = temp[j] + str.charAt(j);
      }
    }

    StringBuilder result = new StringBuilder();

    for (String s : temp) result.append(s);

    return result.toString();
  }

  public static boolean superIncreasing(int[] arr) {
    int calc = 0;

    for (int i = 1; i < arr.length; i++) {
      calc += arr[i-1];
      if (calc >= arr[i]) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    // # HashMap 초기화
    // System.out.println(
    //   new HashMap<String, String>() {{
    //     put("greeting", "Hello");
    //   }}
    // );

    // # 72의 법칙
    // System.out.println(ruleOf72(12.8));

    // # 거듭제곱의 성질
    // System.out.println(pow(3, 3));

    // # 2의 제곱근
    // System.out.println(p2(8));

    // # 포장도로
    // System.out.println(paveBox(new Integer[] {5, 2, 3, 4, 6}));

    // # 문자열 관련
    // System.out.println(firstChar("Hello World!"));
    // System.out.println(reverseString("Hello World!"));
    // System.out.println(firstCapitalize("Hello World!"));
    // System.out.println(letterCapitalize("hello    world   !!!"));
    // System.out.println(convertDoubleSpaceToSingle("Hello  World!!!"));
    // System.out.println(insertDash("112233445566778899"));
    // System.out.println(Arrays.toString(removeExtremes(new String[]{"1", "456", "789", "123", "2", "3"})));
    // System.out.println(Arrays.toString(reverseArr(new int[] {1, 2, 3, 4, 5})));
    // System.out.println(readVertically(new String[] {"12", "4567", "789"}));
    System.out.println(superIncreasing(new int[] {-10, 1, 3, 5, 13, 52}));

    // # 구현
    // 보드게임
    // System.out.println(
    //   boardGame(
    //     new int[][]{
    //       {0, 0, 0, 0, 0},
    //       {0, 0, 1, 0, 0},
    //       {0, 0, 0, 0, 0},
    //       {0, 0, 0, 1, 0},
    //       {0, 0, 0, 0, 0}
    //     },
    //     "RRDUDUD"
    //   )
    // );

    // # 금고털이 (동전 교환 알고리즘)
    // System.out.println(
    //     ocean(10, new int[] {1, 2, 5, 10})
    // );

    // # 문자열 변환
    // System.out.println(
    //   convertListToHashMap(new String[][] {})
    // );

    // # 가위바위보 게임 (중복 순열)
    // rockPaperScissors(5);

    // 승승장구 비밀 치킨 (순열)
    // newChickenRecipe(new int[] {11, 1, 10, 10001, 10000}, 2);

    // 블랙잭은 지겨워
    // boringBlackjack(new int[] {1, 2, 3, 4});

    // 빼빼로데이
    // divideChocolateStick(20, 10);

    // 집밥이 그리워
    // System.out.println(Arrays.deepToString(missHouseMeal(new String[] { "pasta", "oysterSoup", "beefRibs", "tteokbokki" }).toArray()));
  }
}