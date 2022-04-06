package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {

	static int N;
	static int[][] arr;
	static int sinmul;
	static int ssnsum;
	static boolean isSelected[];
	static int umai;


//  비트마스킹으로 풀어보기 -- 이 코드는 속도비교를 해보기 위해 구글링을 통해 가져온 코드입니다.
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][2];
		isSelected = new boolean[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		umai = Integer.MAX_VALUE;
		sinmul = 1;
		ssnsum = 0;
		for (int i = 1; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					sinmul = sinmul*arr[j][0];
					ssnsum = ssnsum+arr[j][1];
				}
			}
			umai = Math.min(umai, Math.abs(sinmul - ssnsum));
			sinmul = 1;
			ssnsum = 0;
		}
		System.out.println(umai);

	}


//	부분집합으로 풀어보기 -- 직접 구현한 코드입니다.
	public static void main1(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][2];
		isSelected = new boolean[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sinmul = 1;
		ssnsum = 0;
		umai = Integer.MAX_VALUE;
		sub(0);

		System.out.println(umai);
	}

	public static void sub(int cnt) {

		if (cnt == N) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {

					sinmul *= arr[i][0];
					ssnsum += arr[i][1];
				} else {
					count++;
				}
			}
			if (count != N) {
				umai = Math.min(umai, Math.abs(sinmul - ssnsum));
			}
			sinmul = 1;
			ssnsum = 0;
			return;
		}

		// 선택되었을 때
		isSelected[cnt] = true;
		sub(cnt + 1);

		// 선택되지 않았을 때
		isSelected[cnt] = false;
		sub(cnt + 1);

	}

}
