package com.ssafy.im;

import java.io.*;
import java.util.*;

public class BJ_16935_배열돌리기3 {

	static int R, C;
	static int rotate; // 수행해야하는 연산의 수
	static int arr[][];
	static int command[];
	static int temp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] condition = br.readLine().split(" ");
		R = Integer.parseInt(condition[0]);
		C = Integer.parseInt(condition[1]);
		rotate = Integer.parseInt(condition[2]);

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}

		command = new int[rotate]; // 수행해야하는 연산 번호
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < rotate; i++) {
			command[i] = Integer.parseInt(line[0]); // 똑같은 command를 여러개(rotate 횟수)만큼 만들기
		}

		for (int k = 0; k < rotate; k++) {
			switch (command[k]) {
			case 1: // 상하반전
				temp = new int[R][C]; // 원본 건드리기 싫어서 배열 조작시 임시로 쓸 배열 하나 만들자
				for (int i = 0; i < R; i++)
					temp[i] = arr[R - 1 - i]; // 2차원 배열이므로 행(row)만 쏙 뽑아옴
				arr = temp;
				break;

			case 2: // 좌우반전
				temp = new int[R][C];
				for (int i = 0; i < R; i++)
					for (int j = 0; j < C; j++)
						temp[i][j] = arr[i][C - 1 - j];
				arr = temp;
				break;

			case 3: // 오른쪽으로 90도 회전
				temp = new int[C][R]; // 변의 길이가 change 되므로
				for (int i = 0; i < C; i++)
					for (int j = 0; j < R; j++)
						temp[i][j] = arr[R - 1 - j][i];
				arr = temp;
				
				int tmp1 = R;
				R = C;
				C = tmp1;
				break;

			case 4: // 왼쪽으로 90도 회전
				temp = new int[C][R];
				for (int i = 0; i < C; i++)
					for (int j = 0; j < R; j++)
						temp[i][j] = arr[j][C - 1 - i];
				arr = temp;
				
				int tmp2 = R;
				R = C;
				C = tmp2;
				break;

			case 5: // 부분배열 시계방향 회전
				temp = new int[R][C];
				for (int i = 0; i < R / 2; i++)
					for (int j = C / 2; j < C; j++)
						temp[i][j] = arr[i][j - C / 2];
				for (int i = R / 2; i < R; i++)
					for (int j = C / 2; j < C; j++)
						temp[i][j] = arr[i - R / 2][j];
				for (int i = R / 2; i < R; i++)
					for (int j = 0; j < C / 2; j++)
						temp[i][j] = arr[i][C / 2 + j];
				for (int i = 0; i < R / 2; i++)
					for (int j = 0; j < C / 2; j++)
						temp[i][j] = arr[R / 2 + i][j];
				arr = temp;
				break;

			case 6: // 부분배열 반시계방향 회전
				temp = new int[R][C];
				for (int i = R / 2; i < R; i++)
					for (int j = 0; j < C / 2; j++)
						temp[i][j] = arr[i - R / 2][j];
				for (int i = R / 2; i < R; i++)
					for (int j = C / 2; j < C; j++)
						temp[i][j] = arr[i][j - C / 2];
				for (int i = 0; i < R / 2; i++)
					for (int j = C / 2; j < C; j++)
						temp[i][j] = arr[i + R / 2][j];
				for (int i = 0; i < R / 2; i++)
					for (int j = 0; j < C / 2; j++)
						temp[i][j] = arr[i][C / 2 + j];
				arr = temp;
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
