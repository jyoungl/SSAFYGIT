package com.ssafy.im;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 아홉 개의 정수가 공백으로 구분 >> 규영이가 내는 카드
 * 출력
 * 1. "#" + tc + " " + win + " " + lose
 * 
 * >> 높은 수가 적힌 사람이 두 카드에 적힌 수의 합만큼 점수 얻음
 * >> 18개의 카드 중 9개를 빼고 남은 9개가 인영이의 카드
 * >> 순열로 계산하기 >> 9P9=9!
 */
public class D3_6808_규영이와인영이의카드게임 {

	static int[] A;
	static int[] B;
	static int[] result;
	static boolean[] card;
	static boolean[] isSelected;
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		File file = new File("D3_6808_규영이와인영이의카드게임.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			A = new int[9];
			B = new int[9];
			result = new int[9];
			card = new boolean[19];
			isSelected = new boolean[9];
			
			win = 0;
			lose = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				card[A[i]] = true; //18장의 카드 중 A가 고른 것은 선택하지 못하게 함
			}

			int idx = 0;
			for(int i = 1; i <= 18; i++) {
				if(card[i]) continue; //A가 고른 것은 빼기
				B[idx++] = i;
			}

			match(0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	
	//순열 9P9=9!
	private static void match(int cnt) {
		if(cnt == 9) {
			int score1 = 0;
			int score2 = 0;
			
			for(int i = 0; i<9; i++) {
				if(result[i] < A[i]) score1 += result[i] + A[i]; //A가 이겼을 때 점수 다 가지고 가기
				else if(result[i] > A[i]) score2 += result[i] + A[i];
			}
			
			if(score1 > score2) win++; //총점이 높으면 이김
			if(score1 < score2) lose++;
			return;
		}
		
		for(int i = 0; i<9; i++) {
			if(isSelected[i]) continue;
			result[cnt] = B[i];
			isSelected[i] = true;
			match(cnt+1);
			isSelected[i] = false;	
		}	
	}
}
