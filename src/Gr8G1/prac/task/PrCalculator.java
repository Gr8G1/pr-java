package Gr8G1.prac.task;

import java.util.Scanner;

public class PrCalculator {
    static float f, s; // 입력값
    static String oper; // 연산자
    static String c; // 명령어

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator: while (true) {
            System.out.print("첫번쨰 숫자를 입력해주세요 : ");
            while (true) {

                f = sc.nextFloat();

                if (f == 0) {
                    System.out.println("잘못된 숫자입니다. 다시 입력해주세요: ");
                    continue;
                }

                break;
            }

            System.out.print("연산자를 입력해주세요: ");
            while (true) {
                oper = sc.next();

                switch (oper) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        break;
                    default:
                        System.out.print("잘못된 연산자 입니다. 다시 입력해주세요: ");
                        continue;
                }

                break;
            }

            System.out.print("두번째 숫자를 입력해주세요 : ");
            while (true) {
                s = sc.nextFloat();

                if (s == 0) {
                    System.out.println("잘못된 숫자입니다. 다시 입력해주세요: ");
                    continue;
                }

                switch (oper) {
                    case "+":
                        System.out.println("결과값: " + (f + s));
                        break;
                    case "-":
                        System.out.println("결과값: " + (f - s));
                        break;
                    case "*":
                        System.out.println("결과값: " + (f * s));
                        break;
                    case "/":
                        System.out.println("결과값: " + (f / s));
                        break;
                }

                break;
            }

            System.out.print("계산기를 종료하시겠습니까? (y/N): ");
            while (true) {
                c = sc.next();

                switch (c.toLowerCase()) {
                    case "y":
                        break Calculator;
                    case "n":
                        break;
                    default:
                        System.out.print("잘못된 입력값입니다. 계산기를 종료하시겠습니까? (y/N): ");
                        continue;
                }

                break;
            }
        }

        sc.close();
    }
}
