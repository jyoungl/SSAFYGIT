package dec16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수_이주영 {
	static boolean[] visit;
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		arr = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		int res = 0;
		
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				bfs(i);
				res++;
			}
		}
		System.out.println(res);
	}
	
	public static void bfs(int a) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(a);
		visit[a] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int i=1;i<=N;i++) {
				if(arr[now][i] == 1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
