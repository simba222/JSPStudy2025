package ch04;

public class While {
	public static void main(String[] args) {

		int a = 1;

		while (a <= 10) {
			System.out.println(a);
			if (a == 10) {
				System.out.println("a가 " + a + "이므로 while문은 종료됩니다.");
			}// if
			a++;
		}// while
	}
}
