package Gr8G1.prac.section1;

import java.util.StringTokenizer;

public class PrString {
    // ~ 문자열
    static String str = "String";
    // String str = 'abcd'; // Error: 작은따옴표 사용 불가

    public static void main(String[] args) {
        // StringTokenizer
        StringTokenizer strTk = new StringTokenizer("New%String%Tokenizer", "%");

        while (strTk.hasMoreTokens()) {
            System.out.println(strTk.countTokens());
            System.out.println(strTk.nextToken());
        }

        // StringBuilder
        StringBuilder strBd = new StringBuilder();

        strBd.append("New String Builder");
        System.out.println(strBd);
        strBd.delete(strBd.length() - 2, strBd.length());
        System.out.println(strBd);

        // StringBuffer
        StringBuffer strBf = new StringBuffer("String");
        strBf.append("Buffer");
        strBf.insert(0, "New");

        System.out.println(strBf);
    }
}
