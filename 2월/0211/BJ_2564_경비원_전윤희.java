package com.im.baekjoon;

import java.util.*;
import java.io.*;

public class BJ_2564_경비원 {

	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 색종이 문제처럼 좌표로 접근하다가 아래꼴 남
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());// 가로 길이
		int C = Integer.parseInt(st.nextToken());// 세로 길이
		map = new int[R][C];

		int shopNum = Integer.parseInt(br.readLine());// 상점 갯수

		// 2차원 배열로 접근하다가 못풀어서 이렇게 풀었음
		int[] line = new int[shopNum + 1];// 각 위치별 거리(하나의 직선으로생각)

		for (int i = 0; i < shopNum + 1; ++i) { // 상점 개수(shopNum) + 동근이 경비실(1)
			st = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken()); // 방향
			int position = Integer.parseInt(st.nextToken()); // 값

			int distance = 0; // 임시 거리 변수
			if (dir == 1)
				distance = position;// 북
			else if (dir == 2)
				distance = 2 * R + C - position; // 남
			else if (dir == 3)
				distance = 2 * (R + C) - position;// 서
			else if (dir == 4)
				distance = R + position;// 동
			line[i] = distance;// 각 상점마다 일반화된 거리 입력 완료
		}

		int donggeun = line[shopNum];// 내 거리값을 저장
		int sum = 0; // 거리 합 저장
		
		// 시계방향과 반시계방향 중 최솟값
		for (int i = 0; i < shopNum; ++i) {
			int clockwise = Math.abs(donggeun - line[i]);// 시계 방향의 거리값
			sum = sum + Math.min(clockwise, 2 * (R + C) - clockwise);// 반시계랑 비교해서 더 작은 값을 더함
		}
		System.out.println(sum);
	}

}
