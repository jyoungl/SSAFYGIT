package com.im.baekjoon;

import java.util.*;
import java.io.*;

//8시 ~ 8시 40분
//이후로 계속 오류 고침

public class BJ_2578_빙고 {

	static int[][] board = new int[5][5]; // 내 빙고판
	static boolean[][] visited = new boolean[5][5]; // 사회자가 부른 수와 내 빙고판의 숫자가 일치할 시 체크하는 빙고판

	//static int bingoCount = 0;

	public static void main(String[] args) throws Exception {
		// Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileInputStream("input.txt"));

		// 나의 빙고판 작성
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = in.nextInt();
			}
		}

		// 사회자가 부르는 숫자(1~25)와 나의 빙고판을 비교
		// 그 때의 인덱스를 추출하여 visited 배열 수정
		out: for (int n = 1; n <= 15; n++) { // 25개의 숫자(순서) 호명
			int speak = in.nextInt();
			// System.out.println(speak);

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == speak) {
						// System.out.println(i+" "+j);
						visited[i][j] = true;

						// 선이 세 개 이상 그어지는 순간 >> 빙고
						// 3개의 빙고가 나왔을 때, 숫자 부르는 것 멈추고 그 때의 숫자(순서) 출력
						if (bingo() >= 3) {
							System.out.println(n);
							break out;
						}

					}
				}
			} // 사회자가 부르는 숫자와 나의 빙고판을 비교하여, 일치할 때 visited 배열 수정
		}

	} // main

	private static int bingo() {
		
		int bingoCount = 0; // static 변수로 선언하면 출력 다른 값 나옴. 이유는 모르겠음
		// 가로
		for (int i = 0; i < 5; i++) {
			int trueCount_row = 0;
			for (int j = 0; j < 5; j++) {
				if (visited[i][j] == true)
					trueCount_row++;
			}
			if (trueCount_row == 5)
				bingoCount++;
		}

		// 세로
		for (int i = 0; i < 5; i++) {
			int trueCount_column = 0;
			for (int j = 0; j < 5; j++) {
				if (visited[j][i] == true)
					trueCount_column++;
			}
			if (trueCount_column == 5)
				bingoCount++;
		}

		// 우상향 대각선 보기
		int trueCount_diagonal = 0;
		for (int i = 4; i >= 0; i--) {

			if (visited[4 - i][i] == true)
				trueCount_diagonal++;
			if (trueCount_diagonal == 5)
				bingoCount++;
		}

		// 우하향대각선
		trueCount_diagonal = 0;
		for (int i = 0; i < 5; i++) {
			if (visited[i][i] == true)
				trueCount_diagonal++;
			if (trueCount_diagonal == 5)
				bingoCount++;
		}
		return bingoCount;
	} // bingo()
} // class
