package jan27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_아기상어2_이주영 {
	static int N,M;
	static int[] dr = {0,0,1,-1,1,1,-1,-1};
	static int[] dc = {1,-1,0,0,1,-1,1,-1};
	static int[][] arr;
	public static class Dot {
		int x;
		int y;
		int cost;
		
		public Dot(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Dot> list = new ArrayList<>();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0)
					list.add(new Dot(i,j,0));
			}
		}
		
		int max = 0;
		for(int i=0;i<list.size();i++) {
			max = Math.max(max, bfs(list.get(i).x, list.get(i).y));
		}
		
		System.out.println(max);
	}
	
	public static int bfs(int x, int y) {
		Queue<Dot> que = new LinkedList<>();
		boolean[][] visited = new boolean[50][50];
		visited[x][y] = true;
		que.add(new Dot(x,y,0));
		int ans = Integer.MAX_VALUE;
		while(!que.isEmpty()) {
			Dot now = que.poll();
			
			for(int d=0;d<8;d++) {
				int dx = now.x + dr[d];
				int dy = now.y + dc[d];
				int dc = now.cost+1;

				if(dx<0 || dy<0 ||dx>=N||dy>=M||visited[dx][dy])
					continue;

				if(arr[dx][dy] == 1) {
					ans = Math.min(ans, dc);
				}
				else if(arr[dx][dy] == 0) {
					que.add(new Dot(dx,dy,dc));
				}
				visited[dx][dy] = true;
			}
		}
		return ans;
	}

}
