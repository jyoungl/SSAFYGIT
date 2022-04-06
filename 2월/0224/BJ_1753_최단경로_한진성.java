import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int from;
	int wei;
	
	public Node( int from, int wei) {
		super();
		this.from = from;
		this.wei = wei;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.wei, o.wei);
	}
	
}

public class BOJ_1753_최단경로2 {
	static int V,E,K;
	static ArrayList<ArrayList<Node>> map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(in.readLine());
		
		map = new ArrayList<ArrayList<Node>>();
		
		
		for(int i=0;i<=V;i++) {
			map.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(in.readLine()," ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			map.get(from).add(new Node(to,wei));
		}
		
		int[] answer = dijkstra(K);
		
		for(int i=1;i<=V;i++) {
			if(answer[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(answer[i]);
			}
		}
	}
	
	public static int[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 시작노드 최단경로 0으로 설정 큐에 삽입
		pq.offer(new Node(start,0));
		
		int[] distance = new int[V+1];
		
		// 우선순위 큐 사용하면 이거 필요없음
//		boolean[] visited = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		// 큐가 비어있지 않는 동안 반복
		while(!pq.isEmpty()) {
			// 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
			Node node = pq.poll();
			
			int dist = node.wei;
			int now = node.from;
			
			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시 - 방문처리 대체
			if(distance[now] < dist) {
				continue;
			}
			
			// 현재 노드와 연결된 다른 인접한 노드들 확인
			
			for(int i=0,n=map.get(now).size();i<n;i++) {
				// 현재 최단거리 + 현재 연결된 노드의 거리
				int current = distance[now] + map.get(now).get(i).wei;
				
				
				if(current < distance[map.get(now).get(i).from]) {
					distance[map.get(now).get(i).from] = current;
					pq.offer(new Node(map.get(now).get(i).from, current));
				}
			}
		}
		
		return distance;
	}

}
