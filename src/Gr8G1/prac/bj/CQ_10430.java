package Gr8G1.prac.bj;

import java.util.Scanner;

public class CQ_10430 {
  public static void main(String[] args) {
    //Q: https://www.acmicpc.net/problem/10430
    Scanner sc = new Scanner(System.in);

    int A, B, C;

    A = sc.nextInt();
    B = sc.nextInt();
    C = sc.nextInt();

    System.out.println((A + B) % C);
    System.out.println(((A % C) + (B % C)) % C);
    System.out.println((A * B) % C);
    System.out.println(((A % C) * (B % C)) % C);
  }
}
