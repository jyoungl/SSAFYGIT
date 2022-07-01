import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int N, max, arr[][], cnt;
	static boolean visited[][]; 
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		
		arr= new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int ans = 0;
		for(int l=0;l<max;l++) {
			cnt = 0;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					
					if(arr[i][j] <= l) {
						continue;
					}
					
					if(visited[i][j]) {
						continue;
					}
					
					bfs(l,i,j);
					cnt++;
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void bfs(int l, int x, int y) {
		
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			
			int[] temp = queue.poll();
			
			for(int d=0;d<4;d++) {
				
				int dx = temp[0] + dir[d][0];
				int dy = temp[1] + dir[d][1];
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= N || arr[dx][dy] <= l || visited[dx][dy]) {
					continue;
				}
				visited[dx][dy] = true;
				queue.offer(new int[] {dx,dy});
			}
			
		}

		
		
	}

}
