import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/11724
public class BOJ_11724_연결요소의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node[] head = new Node[N+1];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			head[u] = new Node(v,head[u]);
			head[v] = new Node(u,head[v]);
		}

		//bfs
		int count = 0;
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1;i<=N;i++){
			if(visited[i]) continue;
			queue.offer(i);
			count++;

			while(!queue.isEmpty()){
				for(Node node = head[queue.poll()]; node!=null; node = node.link){
					if(visited[node.data]) continue;
					visited[node.data] = true;
					queue.offer(node.data);
				}
			}
		}

		System.out.println(count);
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
