package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_1388_바닥장식 {
	static int N, M;
	static char[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(arr[i][j] == '-') dfs(i, j, true);
				else dfs(i, j, false);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	private static void dfs(int i, int j, boolean row) {
		visited[i][j] = true;
		if(row) {
			j++;
			if(j<M && arr[i][j] == '-') dfs(i, j, true);
		}
		else {
			i++;
			if(i<N && arr[i][j] != '-') dfs(i, j, false);
		}
	
	}

}
