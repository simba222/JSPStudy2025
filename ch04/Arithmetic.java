package ch04;

public class Arithmetic {
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		int c1, c2, c3, c4, c5;

		c1 = a + b;
		c2 = a - b;
		c3 = a * b;
		c4 = a / b;
		c5 = a % b;

		System.out.println("산술연산자");
		System.out.println("a + b는 " + c1 + "입니다.");
		System.out.println("a - b는 " + c2 + "입니다.");
		System.out.println("a * b는 " + c3 + "입니다.");
		System.out.println("a / b는 " + c4 + "입니다.");
		System.out.println("a / b의 나머지는 " + c5 + "입니다.");
		System.out.println("-------------------------------------------");
		System.out.println("증감연산자");
		System.out.println("++a는 " + (++a)+"입니다.");
		System.out.println("--a는 " + (--a)+"입니다.");
		System.out.println("a++는 " + (a++)+"입니다.");
		System.out.println("a--는 " + (a--)+"입니다.");
		System.out.println(a);
	}

}
