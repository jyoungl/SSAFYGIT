package jul07;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_21736_헌내기는친구가필요해_이주영 {
	static char[][] arr;
	static int N,M;
	static int res;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int d=0;d<4;d++) {
				int dx = now[0] + dr[d];
				int dy = now[1] + dc[d];
				
				if(dx<0 || dy<0 ||dx>=N || dy>=M || visited[dx][dy] || arr[dx][dy] == 'X')
					continue;
				
				if(arr[dx][dy] == 'P') {
					res++;
				}
				
				if(arr[dx][dy] == 'P' || arr[dx][dy] == 'O') {
					que.add(new int[] {dx,dy});
					visited[dx][dy] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		int x = 0, y = 0;
		res = 0;
		for(int i=0;i<N;i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				arr[i][j] = str[j];
				if(arr[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x,y);
		
		if(res == 0)
			System.out.println("TT");
		else
			System.out.println(res);
	}

}
