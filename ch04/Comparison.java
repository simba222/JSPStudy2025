package ch04;

public class Comparison {
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		int r1 = 10, r2 = 10, r3 = 10, r4 = 10, r5 = 10, r6 = 10;

		r1 = a;
		r2 += a;
		r3 -= a;
		r4 *= a;
		r5 /= a;
		r6 %= a;

		System.out.println("비교연산자");
		System.out.println("a > b는 " + (a > b) + "입니다.");
		System.out.println("a >= b는 " + (a >= b) + "입니다.");
		System.out.println("a == b는 " + (a == b) + "입니다.");
		System.out.println("a != b는 " + (a != b) + "입니다.");
		System.out.println("대입연산자");
		System.out.println("r1 = a는 " + r1 + "입니다.");
		System.out.println("r2 += a는 " + r2 + "입니다.");
		System.out.println("r3 -= a는 " + r3 + "입니다.");
		System.out.println("r4 *= a는 " + r4 + "입니다.");
		System.out.println("r5 /= a는 " + r5 + "입니다.");
		System.out.println("r6 %= a는 " + r6 + "입니다.");
	}
}
