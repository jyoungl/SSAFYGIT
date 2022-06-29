package jun29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기_이주영 {
	static int M,N,cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int x, int y) {
		cnt++;
		visited[x][y] = true;
		
		for(int d=0;d<4;d++) {
			int dx = x + dr[d];
			int dy = y + dc[d];
			
			if(dx<0 || dy<0 ||dx>=N || dy>=M || arr[dx][dy]==1)
				continue;
			
			if(!visited[dx][dy])
				dfs(dx,dy);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int x=x1;x<x2;x++) {
				for(int y=y1;y<y2;y++) {
					arr[x][y] = 1;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]!=1 && !visited[i][j]) {
					cnt = 0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
			sb.append(list.get(i)+" ");
		System.out.println(sb);
	}

}
