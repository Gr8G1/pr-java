package Gr8G1.prac.bj;

import java.util.Scanner;

public class CQ_10869 {
  public static void main(String[] args) {
    // Q: 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
    // I: 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
    // O: 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.

    Scanner sc = new Scanner(System.in);

    int a;
    int b;

    a = sc.nextInt();
    b = sc.nextInt();

    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b);
  }
}
