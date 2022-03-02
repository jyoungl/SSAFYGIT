import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int[][] deltas = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

		for (int tc = 0; tc < T; tc++) {
			int I = Integer.parseInt(in.readLine());
			int[][] visited = new int[I][I];
			st = new StringTokenizer(in.readLine());
			int[] night = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),1};
			st = new StringTokenizer(in.readLine());
			int[] last = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

			Queue<int[]> queue = new LinkedList<>();
			queue.offer(night);
			visited[night[0]][night[1]] = 1;

			while (!queue.isEmpty()) {
				night = queue.poll();

				for (int d = 0; d < 8; d++) {
					int ni = night[0] + deltas[d][0];
					int nj = night[1] + deltas[d][1];
					if (ni < 0 || ni >= I || nj < 0 || nj >= I || visited[ni][nj] != 0) continue;
					visited[ni][nj] = night[2]+1;
					queue.offer(new int[]{ni,nj,night[2]+1});
					if(ni==last[0] && nj==last[1]) {
						queue.clear();
						break;
					}
				}
			}

			sb.append(visited[last[0]][last[1]]-1).append("\n");
		}

		System.out.print(sb);
	}
}
