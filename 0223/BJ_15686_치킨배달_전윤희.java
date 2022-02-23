package com.ssafy.im;

import java.util.*;
import java.io.*;

public class BJ_15686_치킨배달 {

	static int N, M; // N×N 동네크기, 살아남는 치킨집 수
	static int result = Integer.MAX_VALUE;

	static boolean[] check;
	static List<int[]> home, chicken;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//System.out.println(N+" "+M);
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();

		// List를 활용해서 위치 추가(초기화)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				switch (Integer.parseInt(st.nextToken())) {
				case 1: // 집
					home.add(new int[] { i, j }); // 집 좌표
					break;
				case 2: // 치킨집
					chicken.add(new int[] { i, j }); // 치킨집 좌표
					break;
				}
		}
		//System.out.println(home.get(0)[0]+" "+home.get(0)[1]);
		
		check = new boolean[chicken.size()]; // 조합시 선택된 치킨집을 보여주는 배열변수

		// 치킨집 선택시 순서는 상관 없으므로 조합(교수님 추천)
		combination(0, 0);

		System.out.println(result);
	}

	static void combination(int start, int cnt) {
		// 기저조건
		if (cnt == M) {
			//System.out.println(Arrays.toString(check));
			int distance = 0;

			for (int[] h : home) {
				int temp = Integer.MAX_VALUE;
				for (int i = 0; i < check.length; i++) {
					if (check[i]) // 치킨거리 구하기
						temp = Math.min(temp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
				}
				distance += temp;
			}
			result = Math.min(result, distance);
			return;
		}

		// 유도파트(조합)
		for (int i = start; i < check.length; i++) {
			check[i] = true;
			combination(i + 1, cnt + 1);
			check[i] = false;
		}
	}
}
