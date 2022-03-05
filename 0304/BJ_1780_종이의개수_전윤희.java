package com.ssafy;

import java.util.*;
import java.io.*;

public class BJ_1780_종이의개수 {

	static int arr[][];
	static int minus, zero, plus;

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

		minus = 0;
		zero = 0;
		plus = 0;

		devide(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	public static void devide(int x, int y, int n) {
		if (!check(x, y, n)) { // 범위내에서 모든 숫자가 같지 않다면
			for (int i = 0; i < n; i = i + n/3) {
				for (int j = 0; j < n; j = j + n/3) {
					devide(x + i, y + j, n/3);
				}
			}
		} else { // 범위내에서 모든 숫자가 같다면
			if (arr[x][y] == 0)
				zero++;
			else if (arr[x][y] == 1)
				plus++;
			else
				minus++;
		}
	}

	// 범위내 같은 숫자인지 체크하는 함수
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