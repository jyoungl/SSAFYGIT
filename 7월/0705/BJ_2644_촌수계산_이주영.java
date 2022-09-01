package jul05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644_촌수계산_이주영 {
	static int[][] arr;
	static int[] visited;
	static int n, a, b;
	public static void bfs(int x, int y) {
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == y)
				break;
			
			for(int i=1;i<=n;i++) {
				if(arr[now][i] == 1 && visited[i] == 0) {
					visited[i] = visited[now] + 1;
					que.add(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		visited = new int[n+1];
		bfs(a,b);
		
		if(visited[b] == 0)
			System.out.println(-1);
		else
			System.out.println(visited[b]);
	}

}
