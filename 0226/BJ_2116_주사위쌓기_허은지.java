package com.ssafy.boj;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 주사위의 개수
 * 2. 주사위의 종류
 * 출력
 * 1. 한 옆면의 숫자 합이 가장 큰 값
 * 조건
 * 1. 아래 있는 주사위와 위에 있는 주사위가 같은 숫자로 맞붙어야 한다
 * 2. 쌓은 채로 돌려서 큰 합을 구한다
 * 3. 주사위는 보통의 것과 다르게 생김
 * 
 * >> 재귀로 최댓값 구하기
 */
public class g4_2116_주사위쌓기 {
	static int N, top, sum;
	static int[][] dice;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//주사위의 개수
		N = Integer.parseInt(br.readLine());
		
		dice = new int[N][6];
		check = new boolean[7];
		
		//주사위의 종류
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		//시작 숫자 1부터 6까지 고르기
		for(int i = 1; i<=6; i++) {
			sum = 0;
			//제일 바닥 숫자 방문 체크
			check[i]=true;
			dice(0, i);
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

	private static void dice(int cnt, int bottom) {
		//옆면에서 더할 숫자
		int num = 0;
		
		//cnt가 N이면 방문 체크 초기화하고 return
		if(cnt==N) {
			check[bottom] = false;
			return;
		}
		
		//윗면 숫자 구하기
		for(int i = 0; i<6; i++) {
			//바닥 숫자의 index 구하기
			if(bottom == dice[cnt][i]) {
				//a-f b-d c-e 0-5 1-3 2-4
				//if 여섯개 쓰면 오래 걸릴 것 같아서 나눔(최대 세 번)
				//위에서부터 0~5 순서
				if(i<3) {
					if(i<2) {
						if(i==0) top = dice[cnt][5];
						else top = dice[cnt][3];
					} else top = dice[cnt][4];
				} else {
					if(i<5) {
						if(i==3) top = dice[cnt][1];
						else top = dice[cnt][2];
					} else top = dice[cnt][0];
				}
			}
		}
		
		//윗면 숫자 방문 체크
		check[top] = true;
		
		//아랫면와 윗면에 있는 숫자를 제외한 옆면 중에 가장 큰 수 더하기
		for(int i = 0; i<6; i++) {
			//윗면과 아랫면 제외
			if(check[dice[cnt][i]]) continue;
			//남은 숫자들 중에 큰 값 저장
			else num = Math.max(dice[cnt][i], num);
		}
		
		//sum에 저장
		sum += num;
		//아랫면 더는 사용하지 않기 때문에 방문 체크 초기화
		check[bottom] = false;
		//윗면이 바닥으로 간 상태로 다음 주사위 탐색
		dice(cnt+1, top);
		
	}

}
