

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 삼각형의 크기 n
 * 2. 정수 삼각형
 * 출력
 * 1. 합이 최대가 되는 경로에 있는 수의 합
 * 조건
 * 1. 아래층으로 내려오기
 * 2. 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택 가능
 */
public class BJ_1932_정수삼각형_허은지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] num = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<=i; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 1; i<n; i++) {
			for(int j = 0; j<=i; j++) {
				if(j>i-1) num[i][j] += num[i-1][j-1];
				else if(j==0) num[i][j] += num[i-1][j];
				else num[i][j] += Math.max(num[i-1][j], num[i-1][j-1]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			max = Math.max(max, num[n-1][i]);
		}
		
		System.out.println(max);
		
	}

}
