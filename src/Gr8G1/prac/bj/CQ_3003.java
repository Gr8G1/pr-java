package Gr8G1.prac.bj;

import java.util.Scanner;

public class CQ_3003 {
  public static void main(String[] args) {
    //Q: https://www.acmicpc.net/problem/3003
    Scanner sc = new Scanner(System.in);

    final int[] cUnit = {1, 1, 2, 2, 2, 8}; // 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
    int iCount = 0;

    System.out.println(new int[]{1, 1, 2, 2, 2, 8}[0]);


    while (iCount < cUnit.length) {
      int u = sc.nextInt();

      System.out.println(cUnit[iCount++] - u);
    }
  }
}
