package com.ssafy;

import java.util.*;
import java.io.*;

public class BJ_2630_색종이만들기 {
	
	static int arr[][];
	static int white;
	static int blue;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		// 배열초기화
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		white = 0;
		blue = 0;
		devide(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	}

	public static void devide(int x, int y, int n) {
		if (!check(x, y, n)) { // 색종이의 색이 같지 않으면
			devide(x, y, n/2);
			devide(x + n/2, y, n/2);
			devide(x, y + n/2, n/2);
			devide(x + n/2, y + n/2, n/2);
		} else { // 색종이의 색이 같으면
			if (arr[x][y] == 0) // 흰색이면
				white++;
			else // 파란색이면
				blue++;
		}
	}

	//잘린 색종이가 같은색인지 체크하는 함수
	public static boolean check(int x, int y, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[x + i][y + j] != arr[x][y]) {
					return false;
				}
			}
		}

		return true;
	}
}