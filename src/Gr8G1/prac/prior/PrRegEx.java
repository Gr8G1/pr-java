package Gr8G1.prac.prior;

import java.util.*;

public class PrRegEx {
  static boolean containsWhitespace(String str) {
    return str.matches(".*\\s.*");
  }

  public static void main(String[] args) {
    String[] testStrings = {
      "test",
      " test",
      "te st",
      "test ",
      "te   st",
      " t e s t ",
      " ",
      "",
      "\ttest"
    };

    // for (String eachString : testStrings) {
    //   System.out.println("Does \"" + eachString + "\" contain whitespace? " + containsWhitespace(eachString));
    // }

    String s = "{A=1}";
    String[] sa = s.replace("{", "")
        .replace("}", "")
        .split("=");

    System.out.println(String.join(":", sa));
  }
}
