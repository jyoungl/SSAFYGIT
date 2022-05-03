package algorithm;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 이닝 수 N
 * 2. 이닝에서 얻는 결과 안타1 2루타2 3루타3 홈런4 아웃0
 * 출력
 * 1. 아인타팀이 얻을 수 있는 최대 점수
 * 조건
 * 1. n루타는 모든 주자가 n루씩 진루
 * 2. 1번 선수는 무조건 4번 타자
 * 
 * >> 순열
 */
public class g5_17281_야구공 {
	static int N, max, lineup[], result[][];
	static boolean isSelected[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		result = new int[N+1][10];
		lineup = new int[10];
		isSelected = new boolean[10];
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		lineup[4] = 1;
		isSelected[4] = true;
		
		Permutation(2);
		
		System.out.println(max);

	}
	
	public static void Permutation(int playerNum) {
		if(playerNum==10) {
			playBall();
			return;
		}
		
		for (int i = 1; i <= 9; i++) { 
			if(isSelected[i]) continue;
			lineup[i] = playerNum;
			isSelected[i] = true;
			Permutation(playerNum+1);
			isSelected[i] = false;
		}
	}


	private static void playBall() {
		int player = 1;
		int score = 0;
		
		for(int inning = 1; inning<=N; inning++) {
			int outCount = 0;
			int[] base = new int[4];

			while(outCount < 3) {	
				switch(result[inning][lineup[player]]) {
					case 0:
						outCount++;
						break;
					case 1:
						for(int i = 3; i>=1; i--) {
							if(base[i]==1) {
								if(i+1>3) score++;
								else base[i+1] = 1;
								base[i] = 0;
							}
						}
						base[1] = 1;
						break;
					case 2:
						for(int i = 3; i>=1; i--) {
							if(base[i]==1) {
								if(i+2>3) score++;
								else base[i+2] = 1;
								base[i] = 0;
							}
						}
						base[2] = 1;
						break;
					case 3:
						for(int i = 3; i>=1; i--) {
							if(base[i]==1) {
								score++;
								base[i] = 0;
							}
						}
						base[3] = 1;
						break;
					case 4:
						for(int i = 3; i>=1; i--) {
							if(base[i]==1) {
								score++;
								base[i] = 0;
							}
						}
						score++;
						break;	
				}
				
				player++;
				if(player==10) player=1;
			}
		}

		max = Math.max(max, score);

	}

}
