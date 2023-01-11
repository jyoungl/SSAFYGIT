package dec09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1743_음식물피하기_이주영 {
	static int N,M,K;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;			
			arr[x][y] = 1;
		}
		
		int res = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				int cnt = 0;
				if(arr[i][j] == 1 && !visited[i][j]) {
					cnt = bfs(i,j);
					res = Math.max(cnt, res);
				}
			}
		}
		System.out.println(res);
	}

	public static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		int cnt = 0;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			if(visited[now[0]][now[1]])
				continue;
			
			if(arr[now[0]][now[1]] == 1) {
				visited[now[0]][now[1]] = true;
				cnt++;
				for(int i=0;i<4;i++) {
					int dx = now[0] + dr[i];
					int dy = now[1] + dc[i];
					if(dx>=0 && dy>=0 && dx<N && dy<M)
						que.add(new int[] {dx,dy});
				}
			}
		}
		
		return cnt;
	}
}
