package Gr8G1.prac.algorithm;

import java.sql.Array;
import java.util.ArrayList;
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

  public static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) return arr;

    int mid = arr.length / 2;

    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    return merge(left, right);
  }

  public static int[] merge(int[] arrLeft, int[] arrRight) {
    int ll = arrLeft.length;
    int rl = arrRight.length;

    ArrayList<Integer> result = new ArrayList<>(ll + rl);

    // System.out.println(Arrays.toString(arrLeft));
    // System.out.println(Arrays.toString(arrRight));

    int i = 0;
    int j = 0;

    while (i < ll && j < rl) {
      if (arrLeft[i] < arrRight[j]) {
        result.add(arrLeft[i]);
        i++;
      } else {
        result.add(arrRight[j]);
        j++;
      }
    }

    while (i < ll) {
      result.add(arrLeft[i]);
      i++;
    }

    while (j < rl) {
      result.add(arrRight[j]);
      j++;
    }

    return result.stream().mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    // System.out.println(Arrays.toString(bubbleSort(new int[] {20, -10, -11, 2, 4, 299})));
    System.out.println(Arrays.toString(mergeSort(new int[] {0, 9, 8, 7, 6, 1, 2, 3, 4, 5})));
  }
}
