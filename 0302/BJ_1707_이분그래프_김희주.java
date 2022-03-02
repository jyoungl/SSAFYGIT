import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1707_이분그래프 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			List<Integer>[] edges = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				edges[u].add(v);
				edges[v].add(u);
			}

			boolean result = true;
			int[] vertex = new int[V + 1];
			Queue<int[]> queue = new LinkedList<>();
			find:
			for (int v = 1; v <= V; v++) {
				if (vertex[v] != 0) continue;
				queue.offer(new int[]{v, 1});
				vertex[v] = 1;
				while (!queue.isEmpty()) {
					int[] vv = queue.poll();
					for (int nv : edges[vv[0]]) {
						if (vertex[nv] == vv[1]) {
							result = false;
							break find;

						} else if (vertex[nv] == -vv[1]) continue;

						vertex[nv] = -vv[1];
						queue.offer(new int[]{nv, vertex[nv]});

					}
				}
			}

			if (result) sb.append("YES\n");
			else sb.append("NO\n");

		}

		System.out.print(sb);
	}
}
