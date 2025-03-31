package ch04;

public class Static {

	static String jspStudy = "static으로 선언된 변수입니다.";
	
	private static void jspStudy() {
		String jspStudy = "static으로 선언된 메소드입니다.";
		System.out.println(jspStudy);
	}

	public static void main(String[] args) {
		System.out.println(jspStudy);
		Static.jspStudy();
	}
}