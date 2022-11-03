package Gr8G1.prac.section1;

import java.util.Arrays;

public class PrArray {
  public static void main(String[] args) {
    // Array.stream
    String[] strings = {"1", "2", "3"};
    int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    // System.out.println(Arrays.toString(nums));
  }
}
