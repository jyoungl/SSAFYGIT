package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 종이의 세로 N 가로 M
 * 2. 종이에 쓰여 있는 수
 * 출력
 * 1. 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값
 * 조건
 * 1. 테트로미노 하나만 놓아야 함
 * 
 * >> ㅗ 모양 빼고 전부 dfs
 */
public class g5_14500_테트로미노 {
	static int N, M, max, arr[][];
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				int sum = 0;
				dfs(i, j, 0, sum);
				sum = arr[i][j] + arr[i+1][j] + arr[i-1][j] + arr[i][j+1] + arr[i][j-1];
				h(i, j, sum);
			}
		}
		
		System.out.println(max);

	}    

	private static void h(int i, int j, int sum) {
		for(int k = 0; k<4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			int tmp = sum - arr[x][y];
			
			max = Math.max(tmp, max);
		}
		
	}

	private static void dfs(int i, int j, int cnt, int sum) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int k = 0; k<4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			if(x<=0 || x>N || y<=0 || y>M || visited[x][y]) continue;
			
			visited[x][y] = true;
			dfs(x, y, cnt+1, sum+arr[x][y]);
			visited[x][y] = false;
		}
		
	}
	
	

}
