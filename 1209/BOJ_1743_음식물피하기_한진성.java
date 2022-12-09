import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기_한진성 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int ans = 0;
		boolean[][] visited = new boolean[N+1][M+1];
		int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				if (arr[i][j] == 1 && !visited[i][j]) {
					Queue<int[]> queue = new LinkedList<int[]>();
					int cnt = 0;
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						
						int[] temp = queue.poll();
						cnt++;
						for(int d=0;d<4;d++) {
							int dx = temp[0]+dir[d][0];
							int dy = temp[1]+dir[d][1];
							
							if(dx <= 0 || dx > N || dy <= 0 || dy > M) {
								continue;
							}
							
							if(arr[dx][dy] == 1 && !visited[dx][dy]) {
								queue.offer(new int[] {dx,dy});
								visited[dx][dy] = true;
							}
							
						}
						
					}
					ans = Math.max(ans, cnt);
					
				}

			}
		}
		System.out.println(ans);

	}

}
