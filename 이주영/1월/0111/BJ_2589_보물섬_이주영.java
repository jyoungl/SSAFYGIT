package jan11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int dis;
	
	public Pos(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}

public class BJ_2589_보물섬_이주영 {
	static char[][] arr;
	static int L,W;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>();
		arr = new char[L][W];
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			char[] c = st.nextToken().toCharArray();
			for(int j=0;j<W;j++) {
				arr[i][j] = c[j];
				if(c[j] == 'L') {
					list.add(new int[] {i,j});
				}
			}
		}
		
		int ans = 0;
		for(int i=0;i<list.size();i++) {
			int[] p = list.get(i);
			int x = bfs(p[0], p[1]);
			ans = (ans<x ? x:ans);
		}
		
		System.out.println(ans+1);
	}
	
	public static int bfs(int x, int y) {
		Queue<Pos>que = new LinkedList<>();
		visited = new boolean[L][W];
		que.add(new Pos(x,y,0));
		visited[x][y] = true;
		int max = Integer.MIN_VALUE;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();

			for(int d=0;d<4;d++) {
				int dx = p.x + dr[d];
				int dy = p.y + dc[d];
				
				if(dx<0 || dx>=L || dy<0 || dy>=W)
					continue;
				
				if(!visited[dx][dy] && arr[dx][dy] == 'L') {
					que.add(new Pos(dx,dy,p.dis+1));
					max = (max<p.dis ? p.dis : max);
					visited[dx][dy] = true;
				}		
			}
		}
		
		return max;
	}
}
