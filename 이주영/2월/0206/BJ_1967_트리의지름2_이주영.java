package feb06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1967_트리의지름2_이주영 {
	public static class Node {
		int n;
		int cost;
		
		public Node(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}
	
	static int N;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int ans, midx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		StringTokenizer st;
		
		for(int i=0;i<=N;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(e,c));
			list[e].add(new Node(s,c));
		}
		
		find(1);
		find(midx);
		System.out.println(ans);
	}
	
	public static void find(int x) {
		visited = new boolean[N+1];
		visited[x] = true;
		dfs(x,0);
	}
	
	public static void dfs(int idx, int cnt) {
		if(ans < cnt) {
			ans = cnt;
			midx = idx;
		}
		
		for(Node node : list[idx]) {
			if(!visited[node.n]) {
				visited[node.n] = true;
				dfs(node.n, cnt+node.cost);
			}
		}
	}

}
