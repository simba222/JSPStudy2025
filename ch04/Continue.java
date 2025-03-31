package ch04;

public class Continue {
	public static void main(String[] args) {

		for (int i = 1; i <= 50; i++) {
			if (i%2 == 0) continue;
				System.out.println(i);
		}// for
	}
}
