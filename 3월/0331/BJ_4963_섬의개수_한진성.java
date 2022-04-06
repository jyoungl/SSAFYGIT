import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {

	static int N, M, arr[][];
	
	static boolean visited[][];

	static int dir[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());

			N = Integer.parseInt(st.nextToken());

			if (M == 0 && N == 0) {
				return;
			}
			arr = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && visited[i][j] == false) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}

	}

	public static void bfs(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{x,y});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int d=0;d<8;d++) {
				
				int dx = temp[0]+dir[d][0];
				int dy = temp[1]+dir[d][1];
				
				if(dx >= 0 && dx < N && dy >= 0 && dy < M && visited[dx][dy] == false && arr[dx][dy] == 1) {
					
					visited[dx][dy] = true;
					queue.offer(new int[]{dx, dy});
					
				}
				
			}
			
		}
		
		
		
		
	}

}
