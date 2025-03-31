package ch04;

public class Switch {
	public static void main(String[] args) {

		int score = 80;

		switch (score) {

		case 100:
			System.out.println("점수는 100점입니다.");
			break;
		case 90:
			System.out.println("점수는 90점입니다.");
			break;
		case 80:
			System.out.println("점수는 80점입니다.");
			break;
		default:
			System.out.println("점수는 70점입니다.");
			break;
		}// switch-case
	}
}
