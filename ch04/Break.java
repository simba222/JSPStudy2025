package ch04;

public class Break {
	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);

			if (i == 5) {
				break;
			}// if
		}// for
	}
}
