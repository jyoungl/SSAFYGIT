import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS_이주영 {
	static int N;
	static int M;
	static int V;
	static int[][] arr;
	static boolean dvisit[];
	static StringBuilder Bsb = new StringBuilder();
	static StringBuilder Dsb = new StringBuilder();
	
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		
		que.offer(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			Bsb.append(now+" ");
			
			for(int i=1;i<=N;i++) {
				if(!visited[i] && arr[now][i] != 0) {
					visited[i] = true;
					que.offer(i);
				}
			}
		}
	}

	
	public static void dfs(int start) {
		dvisit[start] = true;
		Dsb.append(start+" ");
		
		for(int i=1;i<=N;i++) {
			if(arr[start][i] == 1 && !dvisit[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점개수
		M = Integer.parseInt(st.nextToken()); //간선개수
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1]; //from -> to
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //from
			int y = Integer.parseInt(st.nextToken()); //to
			
			arr[x][y] = arr[y][x] = 1;
		}
		
		dvisit = new boolean[N+1];
		dfs(V);
	
		bfs(V);
		System.out.println(Dsb);
		System.out.println(Bsb);
	}

}
