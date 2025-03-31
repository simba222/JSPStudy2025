package ch04;

import out.Parents;

public class Child extends Parents{
	public static void main(String[] args) {
		Parents p = new Parents();
		System.out.println(p.par);
	}
}