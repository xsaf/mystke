package com.bna.business;

enum Animal {
	DOG("aa"), CAT("bb");
	String sound;

	Animal(String s) {
		sound = s;
	}
}

public class TestWrapper {
	static Animal a;

	public static void main(String[] args) {

		System.out.println(a.DOG.sound);

	}

}
