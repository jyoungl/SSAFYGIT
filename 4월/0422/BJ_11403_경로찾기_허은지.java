package 플로이드와샬;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 정점의 개수 N
 * 2. 그래프의 인접 행렬
 * 출력
 * 1. i에서 j로 가는 경로가 있으면 1 없으면 0
 */
public class s1_11403_경로찾기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < N; k++) {
//					if(arr[i][k]==1 && arr[k][j]==1) arr[i][j] = 1;
//				}
//			}
//		}

		for (int k = 0; k < N; k++) {	
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][k]==1 && arr[k][j]==1) arr[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
