package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_2563_색종이 {
// 2차원 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 색종이 갯수
		int[][] coordinate = new int[100][100]; // 좌표를 2차원 배열로 표현 (칸 = 찍힌 점)

		int area = 0; // 면적

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x 좌표
			int y = Integer.parseInt(st.nextToken()); // y 좌표

			// 세로로 면적을 센다 (기준점에서 10만큼 올라감 : ㅣ)
			for (int x1 = x; x1 < x + 10; x1++) { // 정사각형 색종이 한변의 길이 : 10
				for (int y1 = y; y1 < y + 10; y1++) {
					if (coordinate[x1][y1] == 1) // 겹치는 부분은 이미 한 번 면적으로 count 했으므로 다시 count 하지 않음
						continue; // y 좌표 for문
					coordinate[x1][y1] = 1; 
					++area; 
				}
			}
		}
		System.out.println(area);

	}

}
