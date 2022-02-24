import java.io.*;
import java.util.*;

public class JO_1681_해밀턴순환회로 {
	static int N, MIN = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find(1, 0, 0, 1);

		System.out.println(MIN);

	}

	private static void find(int cnt, int prev, int sum, int flag) {
		if (cnt == N) {
			if (map[prev][0] == 0) return;
			sum += map[prev][0];
			MIN = Math.min(MIN, sum);
			return;
		}

		for (int i = 1; i < N; i++) {
			if ((flag & 1 << i) != 0 || map[prev][i] == 0 || sum + map[prev][i] > MIN) continue;
			find(cnt + 1, i, sum + map[prev][i], flag | 1 << i);
		}
	}
}
