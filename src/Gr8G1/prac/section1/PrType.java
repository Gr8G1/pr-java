package Gr8G1.prac.section1;

public class PrType {
    static short b = PrVariable.b;
    static short s = PrVariable.s;
    static int i = PrVariable.i;
    static long l = PrVariable.l;
    static float f = PrVariable.f;
    static double d = PrVariable.d;

    public static void main(String[] args) {
        // ~ 암시/묵시적 타입 변환
        // 변환 가능 형태
        // (byte(1) => short(2)/char(2) => int(4) => long(8): 정수) => float(4) => double(8)

        short ns = b;
        int ni = s;
        long nl = i;
        float nf = l;
        double nd = f;

        System.out.println("b => s: " + ns + ", s => i: " + ni + ", i => l: " + nl);
        System.out.println("l => f: " + nf + ", f => d: " + nd);

        // ~ 명시적 타입 변환
        // ! 강제 타입 변환 시 데이터 손실에 유의
        // (byte(1) <= short(2)/char(2) <= int(4) <= long(8): 정수) <= float(4) <= double(8)

        // # 정수 표현 기본 타입: int
        // # 실수 표현 기본 타입: double

        // 원시 데이터 타입 확인:
        // System.out.println(((Object)변수명).getClass().getSimpleName());

        // (캐스팅) 강제 변환: (float => int)
        int lti = Long.valueOf(Long.MAX_VALUE).intValue();           // -1

        // (캐스팅) 강제 변환: (float => int)
        int fti = (int) (3.4 * Math.pow(10, 38 - 1));   // 양수 표현 최대값
        // (캐스팅) 강제 변환: (double => int)
        int dti = (int) (-1.8 * Math.pow(10, 308 - 1)); // 음수 표현 최대값

        System.out.println("타입: " + ((Object) lti).getClass().getSimpleName() + ", " + lti);
        System.out.println("타입: " + ((Object) fti).getClass().getSimpleName() + ", " + fti);
        System.out.println("타입: " + ((Object) dti).getClass().getSimpleName() + ", " + dti);
    }
}
