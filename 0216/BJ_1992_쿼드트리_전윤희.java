package com.ssafy.im;

import java.util.*;
import java.io.*;

// 쿼드 트리(Quad Tree)는 쉽게 말해서 자식 노드가 4개인 트리 자료구조
public class BJ_1992_쿼드트리 {

	static int[][] arr;
	static char[][] charArr; // 정수형 배열 만들기 위해 선언한 임시 문자형 배열 변수
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new FileReader("input_BJ_1992_쿼드트리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 8 × 8
		arr = new int[N][N];
		charArr = new char[N][N];

		// 배열 초기화
		for (int i = 0; i < N; i++) {
			charArr[i] = br.readLine().toCharArray();
		}

		// 출력 확인
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(charArr[i][j]+" ");
//			}
//			System.out.println();
//		}

		// 정수로 변환 완료
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = charArr[i][j] - 48 ;
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.println(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		quadTree(0, 0, N);
		System.out.println(sb);
	}

	public static void quadTree(int x, int y, int size) {

		// 기저조건
		// 압축 가능시
		// 그 격자의 대표 수 출력
		if (compressTrue(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}

		// 유도파트
		// 압출 불가시
		// 사이즈 반으로 나눠서 재귀 탄다
		int newSize = size / 2;

		sb.append('('); // 쪼개지면 괄호가 추가된다

		quadTree(x, y, newSize); // 왼쪽 위
		quadTree(x, y + newSize, newSize); // 오른쪽 위
		quadTree(x + newSize, y, newSize); // 왼쪽 아래
		quadTree(x + newSize, y + newSize, newSize); // 오른쪽 아래

		sb.append(')');

	}

	// 압축이 가능한지 해당 공간을 체크해주는 함수
	public static boolean compressTrue(int x, int y, int size) {
		int init = arr[x][y];

		// 숫자가 전부 같은지 체크하는 반복문
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (init != arr[i][j]) { // 숫자가 달라지면 false 출력
					return false;
				}
			}
		}
		return true;
	}

}
