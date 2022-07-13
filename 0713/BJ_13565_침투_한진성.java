import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13565_침투 {
	
	static int N, M;
	static char[][] arr;
	static boolean visited[][];
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		for(int i=0;i<M;i++) {
			bfs(0,i);
		}
		String str = "NO";
		for(int i=0;i<M;i++) {
			if(visited[N-1][i]) {
				str = "YES";
			}
		}
		
		System.out.println(str);
	}
	static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {x,y});
		
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			
			int[] temp = queue.poll();
			
			for(int d=0;d<4;d++) {
				
				int dx = temp[0] + dir[d][0];
				int dy = temp[1] + dir[d][1];
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= M || visited[dx][dy] || arr[dx][dy] == '1') {
					continue;
				}
				
				visited[dx][dy] = true;
				queue.offer(new int[] {dx,dy});
				
			}
			
		}
	}
	
}
