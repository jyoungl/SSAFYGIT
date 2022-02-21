package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2606_바이러스_이주영 {
	static int com;
	static int cpair;
	static int[][] arr;
	static boolean[] visited;
	static int cnt;
	
	public static void dfs(int start) {
		visited[start] = true;
		cnt++;
		
		for(int i=1;i<=com;i++) {
			if(arr[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		com = Integer.parseInt(br.readLine());
		cpair = Integer.parseInt(br.readLine());
		arr = new int[com+1][com+1];
		for(int i=0;i<cpair;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = arr[y][x] = 1;
		}
		
		cnt = 0;
		visited = new boolean[com+1];
		dfs(1);
		System.out.println(cnt-1);
	}

}
