package lv20_분할정복;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 행렬 A의 크기 N과 M
 * 2. N개의 줄에 A의 원소 M개
 * 3. 행렬 B의 크기 M과 K
 * 4. M개의 줄에 B의 원소 K개
 * 출력
 * 1. 행렬 A와 B를 곱한 행렬
 * 
 * >> i*j 더해서 구하기
 */
public class b1_2740_행렬곱셈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//A 행렬
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//B 행렬
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[M][K];
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//A*B
		int[][] ans = new int[N][K];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<K; j++) {
				for(int k = 0; k<M; k++) {
					ans[i][j] += A[i][k] * B[k][j];
				}
				sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
