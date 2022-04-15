package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 배열의 크기 N, M, 회전 연산의 개수 K
 * 2. 배열
 * 3. 회전 연산의 정보 r, c, s
 * 출력
 * 1. 배열 A의 값의 최솟값
 * 조건
 * 1. 행에 있는 모든 수의 합 중 최솟값
 * 2. r-s, c-s부터 r+s, c+s를 시계 방향으로 한 칸씩 돌림(정사각형)
 * 3. 회전 연산은 임의로 순서를 변경할 수 있음
 * 
 * >> 순열
 */
public class g4_17406_배열돌리기4 {
	static int N, M, K, min, arr[][], rotation[][];
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation = new int[K][3];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rotation[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[K];
		isSelected = new boolean[K];
		min = Integer.MAX_VALUE;
		
		Permutation(0);
		
		System.out.println(min);
		
	}

	private static void Permutation(int cnt) {
		if(cnt == K) {
			int[][] tmp = new int[N][M];
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			
			for(int i = 0; i<K; i++) {
				int x1 = rotation[numbers[i]][0] - rotation[numbers[i]][2] - 1;
				int y1 = rotation[numbers[i]][1] - rotation[numbers[i]][2] - 1;
				int x2 = rotation[numbers[i]][0] + rotation[numbers[i]][2] - 1;
				int y2 = rotation[numbers[i]][1] + rotation[numbers[i]][2] - 1;

				Rotate(x1, y1, x2, y2, tmp);
			}
			
			Min(tmp);
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			Permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}

	private static void Rotate(int x1, int y1, int x2, int y2, int[][] tmp) {
        if(x1 == x2 && y1 == y2) {
            return;
        }
        
        int[] ver = new int[3];
        ver[0] = tmp[x1][y2];
        ver[1] = tmp[x2][y2];
        ver[2] = tmp[x2][y1];
        
        for(int i = y2; i > y1; i--) {
            tmp[x1][i] = tmp[x1][i - 1];
        }

        for(int i = x2; i > x1; i--) {
            if(i == x1 + 1) tmp[i][y2] = ver[0];
            else tmp[i][y2] = tmp[i - 1][y2];
        }

        for(int i = y1; i < y2; i++) {
            if(i == y2 - 1) tmp[x2][i] = ver[1];
            else tmp[x2][i] = tmp[x2][i + 1];
        }

        for(int i = x1; i < x2; i++) {
            if(i == x2 - 1) tmp[i][y1] = ver[2];
            else tmp[i][y1] = tmp[i + 1][y1];
        }    
        
        Rotate(x1 + 1, y1 + 1, x2 - 1, y2 - 1, tmp);
    }
	
	private static void Min(int[][] tmp) {
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += tmp[i][j];
			}
			
			min = Math.min(min, sum);
		}
	}
}
