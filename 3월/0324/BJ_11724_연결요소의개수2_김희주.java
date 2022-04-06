import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/11724
public class BOJ_11724_연결요소의개수2 {
	static boolean[] visited;
	static Node[] head;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		head = new Node[N+1];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			head[u] = new Node(v,head[u]);
			head[v] = new Node(u,head[v]);
		}

		int count = 0;
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++){
			if(visited[i]) continue;
			dfs(i);
			count ++;
		}

		System.out.println(count);

	}

	private static void dfs(int data) {
		for(Node node = head[data];node!=null;node = node.link){
			if(visited[node.data]) continue;
			visited[node.data] = true;
			dfs(node.data);
		}
	}

	private static class Node{
		int data;
		Node link;
		private Node(int data, Node link){
			this.data = data;
			this.link = link;
		}
	}
}
