import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {

	static int R, C, K, ans;
	static char[][] arr;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());

		C = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(st.nextToken());

		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			arr[i] = in.readLine().toCharArray();
		}

		int x = R - 1;
		int y = 0;
		ans = 0;
		visited = new boolean[R][C];
		visited[x][y] = true;
		dfs(x, y, 1);
		System.out.println(ans);
	}

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void dfs(int x, int y, int depth) {

		if (x == 0 && y == C - 1) {
//			System.out.println(depth);
			if (depth == K) {
				ans++;
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			
			if(dx < 0 || dx >= R || dy < 0 || dy >= C || visited[dx][dy] || arr[dx][dy] == 'T') {
				continue;
			}
			visited[dx][dy] = true;
			dfs(dx,dy,depth+1);
			visited[dx][dy] = false;
			
		}

	}

}
