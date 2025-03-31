package ch04;

public class Member {

	String m;
	String m1 = "멤버변수입니다.";

	public Member() {
		String m = "지역변수입니다.";
		System.out.println(m);
	}

	public static void main(String[] args) {
		Member member = new Member();
		System.out.println("초기화하지 않은 멤버변수 : " + member.m);
		System.out.println("초기화한 멤버변수 : " + member.m1);
	}

}
