package ch04;

public class Grammar {

	public String name = "JSPStudy";
	

	public void jspStudy(int year) {
		System.out.println("변수 name은 " + name + "입니다.");
		System.out.println("변수 year는 " + year + "입니다.");
		System.out.println(name + year);
	}

	public static void main(String[] args) {
		int year = 2013;
		Grammar g = new Grammar();
		g.jspStudy(year);
	}
}
