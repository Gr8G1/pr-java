package Gr8G1.prac.algorithm;

import java.util.Arrays;

public class PrSorting {
  /*
   * # 정렬 알고리즘
   *  -
   *
   */
  public static int[] bubbleSortBasic(int[] arr) {
    int n = arr.length - 1;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    return arr;
  }

  public static int[] bubbleSort(int[] arr) {
    boolean isSwap;
    int n = arr.length - 1;

    for (int i = 0; i < n; i++) {
      isSwap = false;

      for (int j = 0; j < n - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          isSwap = true;
        }
      }

      if (!isSwap) break;
    }

    return arr;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(bubbleSort(new int[]{20, -10, -11, 2, 4, 299})));
  }
}
