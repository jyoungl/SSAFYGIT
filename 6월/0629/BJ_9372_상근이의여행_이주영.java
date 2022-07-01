package jun29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9372_상근이의여행_이주영 {
	static int[][] arr;
	static boolean[] visited;
	static int N,M,res;
	public static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		visited[1] = true;
		
		while(!que.isEmpty()) {
			res++;
			int now = que.poll();
			for(int i=1;i<=N;i++) {
				if(arr[now][i] != 0 && !visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = 0;
			arr = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
				arr[b][a] = 1;
			}
			bfs();
			sb.append(res-1+"\n");
		}
		System.out.println(sb);
	}

}
