import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16173_점프왕쩰리 {

	static int N, arr[][];

	static int[][] dir = { { 1, 0 }, { 0, 1 } };
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		bfs(0,0);
		
	}
	
	static void bfs(int x, int y) {
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			
			int[] temp = queue.poll();
			int curr = arr[temp[0]][temp[1]];
			
			if(temp[0] == N-1 && temp[1] == N-1) {
				System.out.println("HaruHaru");
				return;
			}
			
			for(int d=0;d<2;d++) {
				
				int dx = temp[0] + dir[d][0]*curr;
				int dy = temp[1] + dir[d][1]*curr;
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= N || arr[temp[0]][temp[1]] == 0) {
					continue;
				}
				
				visited[dx][dy] = true;
				queue.offer(new int[] {dx,dy});
				
				
			}
			
		}
		
		System.out.println("Hing");
		
		
		
	}

}
