package com.glassis5;

public class Cw {
	private static final String DOT = "🐈‍"; // 출력할 점 (여기서는 고양이 이모지)
	private static final int LINE_LENGTH = 32; // 선을 그릴 때 사용할 길이

	// 주어진 문자열을 콘솔에 출력하는 함수
	public static void w(String s) {
		System.out.print(s);
	}

	// 주어진 문자열을 출력하고 줄바꿈을 추가하는 함수
	public static void wn(String s) {
		System.out.println(s);
	}

	// 줄바꿈만 추가하는 함수 (오버로딩)
	public static void wn() {
		System.out.println();
	}

	// `LINE_LENGTH` 길이만큼 'DOT'를 출력하는 함수 (선을 긋는 함수)
	public static void line() {
		for (int i = 0; i < LINE_LENGTH; i++) {
			w(DOT);
		}
		wn(); // 줄바꿈 추가
	}

	// 'DOT'를 하나만 출력하는 함수
	public static void dot() {
		w(DOT);
	}

	// 지정된 수 만큼 공백(space)을 출력하는 함수
	public static void space(int c) {
		for (int i = 0; i < c; i++) {
			w(" ");
		}
	}
}
