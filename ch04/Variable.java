package ch04;

public class Variable {

	public String name = "JSPStudy";
	public int year = 2013;

	public void jspStudy() {
		System.out.println("변수 name은 " + name + "입니다.");
		System.out.println("변수 year는 " + year + "입니다.");
		System.out.println(name + year);
	}

	public static void main(String[] args) {
		Variable v = new Variable();
		v.jspStudy();

	}
}
