package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_1080_행렬 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 배열 받기
		boolean[][] A = new boolean[N][M];
		boolean[][] B = new boolean[N][M];
		
		// A 배열
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='1') A[i][j] = true;
			}
		}
		
		// B 배열
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='1') B[i][j] = true;
			}
		}
		
		// 3*3 단위로만 뒤집을 수 있기 때문에 3*3보다 작을 경우는 두 배열이 같으면 0을, 다르면 -1을 출력한다
		// 가로와 세로 둘 중 하나만 3보다 작을 경우도 이에 포함된다
		if(N < 3 || M < 3) {
			if(isSame(A, B)) System.out.println(0);
			else System.out.println(-1);
			System.exit(0);
		}
		
		int ans = 0;
		
		// 3*3 단위로만 뒤집을 수 있기 때문에 N-2, M-2 이후로는 볼 필요가 없다
		// A와 B 배열의 요소가 다르면 A 배열을 뒤집은 뒤 횟수를 더한다
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if(A[i][j] != B[i][j]) {
					reverseMatrix(A, i, j);
					ans++;
				}
			}
		}
		
		// 전부 뒤집었을 때 A와 B 배열이 같을 경우 뒤집은 횟수를, 다를 경우 -1을 출력한다
		if(isSame(A, B)) System.out.println(ans);
		else System.out.println(-1);

	}
	
	// 현재 위치에서 3*3만큼을 전부 뒤집는 함수
	private static void reverseMatrix(boolean[][] a, int x, int y) {
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				a[i][j] = !a[i][j];
			}
		}
	}
	
	// 두 배열이 같은지 다른지 확인해서 반환하는 함수
	private static boolean isSame(boolean[][] a, boolean[][] b) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}

}
