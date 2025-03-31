package ch04;

public class DoWhile {
	public static void main(String[] args) {

		int a = 11;

		do {
			System.out.println(a);
			if (a == 10) {
				System.out.println("a가 " + a + "이므로 while문은 종료됩니다.");
			}// if
			a++;
		} while (a <= 10);// do-while
	}
}
