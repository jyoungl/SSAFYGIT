import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기 {

	static int N, arr[][];
	static int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
	// A는 가로, B는 세로, C는 대각선
	static final int A = 9, B = 8, C = 7;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr[0][1] = A;
		dfs(0, 1, arr);

		System.out.println(ans);
	}

	public static void dfs(int x, int y, int[][] arr) {

		if (x == N - 1 && y == N - 1) {
			ans++;
			return;
		}

		for (int d = 0; d < 3; d++) {
			int dx = x + dir[d][0];
			int dy = y + dir[d][1];
			if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
				// 오른쪽으로 이동할 수 있을 때
				if (d == 0 && (arr[x][y] == A || arr[x][y] == C) && arr[dx][dy] == 0) {
					int temp = arr[x][y];
					arr[x][y] = 0;
					arr[dx][dy] = A;
					dfs(dx, dy, arr);
					arr[dx][dy] = 0;
					arr[x][y] = temp;
				}
				// 아래로 이동할 수 있을 때
				if (d == 2 && (arr[x][y] == C || arr[x][y] == B) && arr[dx][dy] == 0) {
					int temp = arr[x][y];
					arr[x][y] = 0;
					arr[dx][dy] = B;
					dfs(dx, dy, arr);
					arr[dx][dy] = 0;
					arr[x][y] = temp;
				}
				// 대각선으로 이동할 수 있을 때
				if (d == 1 && arr[dx][dy] == 0 && arr[dx][dy - 1] == 0 && arr[dx - 1][dy] == 0) {
					int temp = arr[x][y];
					arr[x][y] = 0;
					arr[dx][dy] = C;
					dfs(dx, dy, arr);
					arr[dx][dy] = 0;
					arr[x][y] = temp;

				}
			}
			
		}

	}

}
