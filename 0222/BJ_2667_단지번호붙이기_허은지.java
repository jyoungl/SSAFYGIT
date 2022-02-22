package lv24_DFS와BFS;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 지도의 크기 N
 * 2. 지도 모양
 * 출력
 * 1. 총 단지 수
 * 2. 단지내 집 수 오름차순
 * 
 * >> dfs, 사방탐색
 */
public class s1_2667_단지번호붙이기 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
			
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] count = new int[N*N]; //단지의 개수 계산을 해보면 N*N개보다 적게 나오는게 정상임
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		} // 집 위치 넣기
		
		int ans = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j]==1 && !visited[i][j]) { // 집이 있고 방문한 적 없으면 탐색
					ans++; // 새로운 단지 시작
					dfs(arr, visited, count, ans, i, j);
				}
			}
			
		}
		
		Arrays.sort(count); // 오름차순으로 출력
		System.out.println(ans); // 총 단지 수
		for(int i = 0; i<count.length; i++) {
			if(count[i]!=0)
			System.out.println(count[i]);
		}

	}//main
	
	private static void dfs(int[][] arr, boolean[][] visited, int[] cnt, int ans, int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		visited[x][y] = true;
		cnt[ans]++;

		for(int i = 0; i<4; i++) {
			int r = x + dx[i];
			int c = y + dy[i];
			if(r<0 || r>=N || c<0 || c>=N) continue;
			if(arr[r][c]==1 && !visited[r][c]) {
				dfs(arr, visited, cnt, ans, r, c);
			}
		}

	}//dfs

}
