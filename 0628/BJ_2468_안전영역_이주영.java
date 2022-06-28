package jun28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_안전영역_이주영 {
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void dfs(int x, int y, int h) {
		visit[x][y] = true;
		
		for(int d=0;d<4;d++) {
			int dx = x + dr[d];
			int dy = y + dc[d];
			
			if(dx<0 || dy<0 || dx>=N || dy>=N || visit[dx][dy])
				continue;
			
			if(arr[x][y]>h)
				dfs(dx,dy,h);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[N][N];
		int maxh = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxh = Math.max(maxh, arr[i][j]);
			}
		}
		
		int res = 0;
		for(int h=0;h<maxh+1;h++) {
			visit = new boolean[N][N];
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					if(!visit[i][j] && arr[i][j]>h) {
						dfs(i,j,h);
						cnt++;
					}
			}
			res = Math.max(res, cnt);
		}
		System.out.println(res);
	}
}
