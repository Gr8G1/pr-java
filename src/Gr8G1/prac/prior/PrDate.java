package Gr8G1.prac.prior;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrDate {
  public static void main(String[] args) {
    int year = 2022;
    int month = 12;
    int day = 1;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Calendar cal = Calendar.getInstance();

    cal.set(year, month - 1, day); // month 값 할당시 주의사항: index 개념

    System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    System.out.println(cal.getTime());
  }
}
