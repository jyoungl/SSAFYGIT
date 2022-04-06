import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static char[][] paints;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		paints = new char[N][N];

		for (int i = 0; i < N; i++) {
			paints[i] = in.readLine().toCharArray();
		}

		int rgb = bfs(true);    //적록색약X
		int gb = bfs(false);    //적록색약O

		System.out.println(rgb + " " + gb);

	}

	private static int bfs(boolean rgb) {
		int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();	//다음에 방문할 인덱스값
		Queue<int[]> area = new LinkedList<>();		//색칠할 인덱스 값
		int cnt = 0;

		int[] v = {0, 0};
		queue.offer(v);

		while (!queue.isEmpty()) {
			v = queue.poll();
			if (visited[v[0]][v[1]]) continue;    //이미 색칠된 적 있다면 넘어감

			cnt++;                                //구역 추가
			visited[v[0]][v[1]] = true;           //색칠함

			area.offer(v);
			while (!area.isEmpty()) {
				v = area.poll();

				for (int d = 0; d < 4; d++) {
					int ny = v[0] + deltas[d][0];
					int nx = v[1] + deltas[d][1];

					//범위를 벗어났거나 이미 색칠된 적 있다면 넘어감
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;

					//다음 위치의 색과 현 위치의 색이 같거나, 적록색약인경우(!rgb) R일때 G, G일때 R인 경우
					//색칠하고 area 큐에 값 넣음(이어서 색칠)
					//아니라면 queue에 넣음(새로 색칠)
					if (paints[ny][nx] == paints[v[0]][v[1]]
							|| (!rgb && paints[ny][nx] == 'R' && paints[v[0]][v[1]] == 'G')
							|| (!rgb && paints[ny][nx] == 'G' && paints[v[0]][v[1]] == 'R')) {
						visited[ny][nx] = true;
						area.offer(new int[]{ny, nx});
					} else queue.offer(new int[]{ny, nx});
				}
			}
		}

		return cnt;
	}


}
