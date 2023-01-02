package Gr8G1.prac.playground;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

import static Gr8G1.prac.section.PrArray.concat;

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
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int sRow = 0;
        int sCol = 0;
        int score = 0;

        Game:
        while (operation.length() > 0) {
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

        for (String v : p) {
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
        for (Integer i : result) if (isPrime(i)) primeCount++;

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
            if (gcd % i == 0) result.add(new Integer[]{i, M / i, N / i});
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

        powerset(new String[]{}, sideDishes, 0, result);

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
        // String[] b = concat(subset, new String[] { arr[idx] });
        String[] b = new String[subset.length + 1];

        System.arraycopy(subset, 0, b, 0, subset.length);
        System.arraycopy(new String[]{arr[idx]}, 0, b, subset.length, 1);

        powerset(b, arr, idx + 1, result);
    }

    public static ArrayList<String> powerSet(String str) {
        ArrayList<String> result = new ArrayList<>();

        // 상태공간트리 (state space tree)
        // 중복제거
        char[] chars = deduplicated(str);
        boolean[] visited = new boolean[chars.length];

        dfs(0, visited, chars, result);

        return (ArrayList<String>) result.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        // Collections.sort(result);
        // return result;
    }

    public static char[] deduplicated(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++)  if (str.indexOf(str.charAt(i)) == i) result += str.charAt(i);

        char[] chars = result.toCharArray();
        Arrays.sort(chars);

        return chars;
    }

    public static void dfs(int depth, boolean[] visited, char[] chars, ArrayList<String> result) {
        if (depth == chars.length) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < chars.length; i++) if (visited[i]) sb.append(chars[i]);

            result.add(sb.toString());

            return;
        }

        visited[depth] = false;
        dfs(depth + 1, visited, chars, result);
        visited[depth] = true;
        dfs(depth + 1, visited, chars, result);
    }

    public static int ruleOf72(double rate) {
        // t = {ln(2)/ln(1+r/100) ~ approx 72/r
        int y;
        double d;
        for (y = 0, d = 1; d < 2; y++, d = (d + (d * rate / 100.0))) ;

        return y;
    }

    public static long pow(int n, int p) {
        if (p == 0) return 1;

        long t = pow(n, p / 2);
        long v = (t * t) % 94_906_249;

        if (p % 2 == 0) return v;
        else return (n * v) % 94_906_249;
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

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

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
            for (String[] toHash : arr) if (!this.containsKey(toHash[0])) put(toHash[0], toHash[1]);
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

        int[] min = new int[]{-1, Arrays.stream(arr).mapToInt(String::length).min().orElse(-1)};
        int[] max = new int[]{-1, Arrays.stream(arr).mapToInt(String::length).max().orElse(-1)};

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
            calc += arr[i - 1];
            if (calc >= arr[i]) return false;
        }

        return true;
    }

    public static Integer modulo(int num1, int num2) {
        if (num2 == 0) return null;

        while (num1 >= num2) num1 -= num2;

        return num1;
    }

    public static boolean isIsogram(String str) {
        HashMap<Character, Integer> isogram = new HashMap<>();

        for (Character c : str.toCharArray()) {
            Character k = Character.toLowerCase(c);

            if (!isogram.containsKey(k)) isogram.put(k, 1);
            else return false;
        }

        return true;
    }

    public static String computeSquareRoot(int num) {
        double approx = 1;

        while (Math.pow(approx, 2) != num) {
            if (Double.parseDouble(String.format("%.2f", Math.pow(approx, 2))) == num) break;

            // 바빌로니아 점화식: Xn+1 = 1/2(Xn + a/Xn) ->
            approx = (approx + (num / approx)) / 2;
        }

        return String.format("%.2f", approx);
    }

    public static int numberSearch(String str) {
        double result = 0, i, f;
        Pattern numPattern = Pattern.compile("[0-9]");
        Matcher matcher = numPattern.matcher(str);

        while (matcher.find()) result += Integer.parseInt(matcher.group());

        String s = str.replaceAll(String.valueOf(numPattern), "").replaceAll("(?U)\\s+", "");

        result = result / s.length();
        // i = Math.floor(result); integer portion
        // f = result - i; // fraction portion
        // return f < .5 ? i : i + 1; // rounding result

        System.out.println(result);
        System.out.println(Math.round(result));
        System.out.println(Math.round(1.5));

        return (int) Math.round((result * 10) / 10);
    }

    public static String decryptCaesarCipher(String str, int secret) {
        // encrypt: f(p)=(ap+b) % 26
        // decrypt: f^-1(p)=(ap-b) % 26
        StringBuilder result = new StringBuilder();
        secret %= 26;

        for (int i = 0; i < str.length(); i++) {
            char ct = str.charAt(i);
            int ascii = ct - secret;

            if (Character.isLowerCase(ct) && !Character.isLowerCase(ascii)) ascii += 26;
            else if (Character.isUpperCase(ct) && !Character.isUpperCase(ascii)) ascii += 26;

            if (ct != 32) result.append((char) ascii); // 32: space
            else result.append(ct);
        }

        return result.toString();
    }

    public static String compressString(String str) {
        StringBuilder results = new StringBuilder();

        while (str.length() != 0) {
            Character firstLetter = str.charAt(0);

            Pattern regex = Pattern.compile("^" + firstLetter + "{3,}");
            Matcher match = regex.matcher(str);

            if (match.find()) {
                results.append(match.group().length()).append(firstLetter);

                str = str.replace(match.group(), "");
            } else {
                results.append(firstLetter);

                str = str.substring(1);
            }
        }

        return results.toString();
    }

    public static int largestProductOfThree(int[] arr) {
        Integer[] sortedArr = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

        int calc1 = sortedArr[0] * sortedArr[1] * sortedArr[2];
        int calc2 = sortedArr[0] * sortedArr[sortedArr.length - 1] * sortedArr[sortedArr.length - 2];

        return Math.max(calc1, calc2);
    }

    public static int fibonacci(int n) {
        // naive
        // if (num <= 1) return num;
        // return fibonacci(num - 1) + fibonacci(num - 2);

        // With for
        // int[] f = new int[num + 2];
        //
        // f[0] = 0;
        // f[1] = 1;
        //
        // for (int i = 2; i <= num; i++) f[i] = f[i - 1] + f[i - 2];
        //
        // return f[num];

        // Binet's formula: Sn = Φⁿ – (–Φⁿ) / √5 : O(logN)
        double sr5 = Math.sqrt(5);
        double phi = (1 + sr5) / 2;

        return (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / sr5);
    }

    public static boolean isSubsetOf(int[] base, int[] sample) {
        return new HashSet<>(Arrays.stream(base).boxed().collect(Collectors.toList()))
                   .containsAll(Arrays.stream(sample).boxed().collect(Collectors.toList()));
    }

    public static boolean balancedBrackets(String str) {
        int i = "]})".indexOf(str);

        System.out.println(i);

        HashMap<Character, Character> cMap = new HashMap<>() {{
            put(']', '[');
            put('}', '{');
            put(')', '(');
        }};
        Stack<Character> s = new Stack<>();

        for (Character c : str.toCharArray()) {
            if (!cMap.containsKey(c)) s.push(c);
            else if (s.size() == 0 && cMap.containsKey(c)) return false;
            else if (s.size() != 0 && cMap.get(c) != s.pop()) return false;
        }

        return s.size() == 0;
    }

    // Dynamic Programming
    public static int tiling(int num) {
        // Top Down
        Integer[] dp = new Integer[num + 1];

        if (num <= 2) return num;
        if (dp[num] != null) return dp[num];

        dp[num] = tiling(num - 1) + tiling(num - 2);
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));

        return dp[num];

        // Bottom Up
        // if (num <= 1) return 1;
        //
        // int[] dp = new int[num + 1];
        //
        // dp[0] = 1;
        // dp[1] = 1;
        //
        // for (int i = 2; i < dp.length; i++) {
        //   dp[i] = dp[i - 1] + dp[i - 2];
        //   System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        // }
        //
        // return dp[num];
    }

    public static int rotatedArraySearch(int[] rotated, int target) {
        int start = 0;
        int end = rotated.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (rotated[mid] == target) return mid;

            if (rotated[start] <= rotated[mid]) {
                if (target < rotated[mid] && target >= rotated[start]) end = mid;
                else start = mid + 1;
            }

            if (rotated[end] >= rotated[mid]) {
                if (target > rotated[mid] && target <= rotated[end]) start = mid;
                else end = mid - 1;
            }
        }

        return -1;
    }

    public static int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }

    public static int orderOfPresentation(int N, int[] K) {
        Boolean[] isVisited = new Boolean[K.length + 1];
        Arrays.fill(isVisited, false);

        int pos = 0;

        for (int i = 0; i < K.length; i++) {
            int s = K[i];
            isVisited[s] = true;
            int l = Arrays.stream(Arrays.copyOfRange(isVisited, 1, s)).filter(b -> !b).toArray().length;

            pos += l * fact(N - 1 - i);
        }

        return pos;
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
        // System.out.println(superIncreasing(new int[] {-10, 1, 3, 5, 13, 52}));
        // System.out.println(modulo(123456789, 67));
        // System.out.println(isIsogram("Mouse"));
        // System.out.println(computeSquareRoot(9));
        // System.out.println(computeSquareRoot(9));
        // System.out.println(numberSearch("YlQO uT9"));
        // System.out.println(decryptCaesarCipher("Aa Bb", 27));
        // System.out.println(compressString("wwwggoppopppp"));
        // System.out.println(largestProductOfThree(new int[] {-5, -4, -3, -1, 999, 10000}));
        // System.out.println(largestProductOfThree(new int[] {-50, -20, -30, -5, 40}));
        // System.out.println(largestProductOfThree(new int[] {2, 3, -11, 7, 5, -13}));
        // System.out.println(fibonacci(7));
        // System.out.println(isSubsetOf(new int[] {1, 2, 3, 4, 5}, new int[] {3}));
        // System.out.println(pow(5, 22));
        // System.out.println(balancedBrackets("[][][]()()(){}{}{}"));
        // System.out.println(tiling(5));
        // System.out.println(rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2));

        // System.out.println(Arrays.toString(powerSet("abc").toArray()));
        // System.out.println(Arrays.toString(powerSet("bac").toArray()));

        System.out.println(orderOfPresentation(3, new int[] {3, 1, 2}));

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

        // # 승승장구 비밀 치킨 (순열)
        // newChickenRecipe(new int[] {11, 1, 10, 10001, 10000}, 2);

        // # 블랙잭은 지겨워
        // boringBlackjack(new int[] {1, 2, 3, 4});

        // # 빼빼로데이
        // divideChocolateStick(20, 10);

        // # 집밥이 그리워
        // System.out.println(Arrays.deepToString(missHouseMeal(new String[] { "쌀밥", "김치", "어묵", "감자" }).toArray()));
    }
}
