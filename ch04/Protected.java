package ch04;

class OutSider2{
	protected String s="OutSider2";
}

public class Protected {
	public static void main(String[] args) {
		OutSider2 o = new OutSider2();
		System.out.println(o.s);
	}
}