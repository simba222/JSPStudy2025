package ch04;

public class Gugudan {
	public static void main(String[] args) {

		for (int i = 1; i <= 9; i++) {
			System.out.println();
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + "=" + (i * j) + "\t");
			}// for2
		}// for1
	}
}