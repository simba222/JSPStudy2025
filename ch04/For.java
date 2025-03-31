package ch04;

public class For {
	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			if (i == 10) {
				System.out.println("a가 " + i + "이므로 for문은 종료됩니다.");
			}// if
		}// for
	}
}
