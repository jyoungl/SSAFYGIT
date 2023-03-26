import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		//컴퓨터 수 N(1<=N<=1000)
		//연결 선의 수 M(1<=M<=100,000)
		//MST : 최소신장트리(크루스칼 or 프림)
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		parent = new int[N+1];
		for(int i=1;i<=N;i++) parent[i] = i;

		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);//오름차순
		StringTokenizer st;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			queue.offer(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}

		int[] now;
		int cost = 0;
		while(!queue.isEmpty()){
			now = queue.poll();
			int a = find(now[0]);
			int b = find(now[1]);
			if(a==b) continue;
			cost += now[2];
			union(a,b);
		}

		System.out.println(cost);

	}
	private static int find(int x){
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	private static void union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		parent[rootB] = rootA;
	}
}
