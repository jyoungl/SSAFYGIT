import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로_이주영 {
	static ArrayList[] adjList;
	static int [] distance;
	
	static class Edge implements Comparable<Edge>{
		int id, cost;
		
		public Edge(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	public static void dijkstra(int start) {
		//1. 출발지 비용은 0으로 하고, 출발지를 우선순위큐에 넣고 시작
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.add(new Edge(start,0)); //start에서 시작해 start에서 돌아와 가중치가 0
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			//만약 특정 목적지에 도착하는 문제라면, 목적지에 도착했을 시 break문 추가해야함
			
			//2. 더 큰 가중치로 도착한 경우 패스 == 더 비표율적인 경로
			if(now.cost > distance[now.id]) continue;
			
			//3. 현재 위치에 연결된 간선 탐색
			int len = adjList[now.id].size();
			for(int i=0;i<len;i++) {
				Edge next = (Edge)adjList[now.id].get(i);
				
				//4. cost가 더 작다면 갱신하고 우선순위 큐에 넣음
				if(distance[next.id] > now.cost + next.cost) {
					distance[next.id] = now.cost + next.cost;
					pq.add(new Edge(next.id, distance[next.id]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		//1.거리배열 초기화
		distance = new int[V+1];
		for(int i=1;i<=V;i++)
			distance[i] = Integer.MAX_VALUE;
		
		//2. 인접리스트 초기화
		adjList = new ArrayList[V+1];
		for(int i=1;i<=V;i++)
			adjList[i] = new ArrayList<Edge>();
		
		//3. 방향간선 인접리스트 정보 입력
		for(int i=1;i<=E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()); //출발 정점
			int y = Integer.parseInt(st.nextToken()); //도착 정점
			int z = Integer.parseInt(st.nextToken()); //가중치
			
			//x 정점에서 시작해 y(id)로 도착, 가중치 z 입력
			adjList[x].add(new Edge(y,z));
		}
		
		//4. 출발지부터 다익스르타 진행
		dijkstra(K);
		
		//5. 결과값 전체 출력
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else {
				sb.append(distance[i]+"\n");
			}
		}
		
		System.out.println(sb);
	}

}
