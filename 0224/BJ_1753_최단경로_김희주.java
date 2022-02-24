import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
//	static List<int[]>[] adj;
	static List<Node>[] adj;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine()) - 1;

		//꼭 ArrayList로 할 것 -> LinkedList는 순서대로 조회할 때 시간이 너무 많이 듦
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

//			adj[u].add(new int[]{v,w});
			adj[u].add(new Node(v,w));
		}

		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[K] = 0;

//		PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
//		pQueue.offer(new int[]{K,distance[K]});
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(K,distance[K]));

		while (!pQueue.isEmpty()) {
			Node current = pQueue.poll();
			if(visited[current.v]) continue;
			visited[current.v] = true;

			for(int i=0,size = adj[current.v].size();i<size;i++){
				int v = adj[current.v].get(i).v;
				int w = adj[current.v].get(i).w;
				if(!visited[v] && distance[v]>current.w+w){
					distance[v] = current.w+w;
					pQueue.offer(new Node(v,distance[v]));
				}
			}
//			int[] current = pQueue.poll();
//			if(visited[current[0]]) continue;
//			visited[current[0]] = true;
//			for(int i=0,size = adj[current[0]].size();i<size;i++){
//				int v = adj[current[0]].get(i)[0];
//				int w = adj[current[0]].get(i)[1];
//				if(!visited[v] && distance[v]>current[1]+w){
//					distance[v] = current[1]+w;
//					pQueue.offer(new int[]{v,distance[v]});
//				}
//			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i=0;i<V;i++) {
			if (visited[i]) sb.append(distance[i]);
			else sb.append("INF");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static class Node implements Comparable<Node>{
		int v,w;
		private Node(int v, int w){
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
}