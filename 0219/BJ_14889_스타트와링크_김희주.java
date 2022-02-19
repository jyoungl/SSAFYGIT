import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int N, MIN = Integer.MAX_VALUE;
	static int[][] ability;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		ability = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pick(1, 1, 1);

		System.out.println(MIN);
	}

	private static void pick(int cnt, int start, int flag) {
		if (cnt == N / 2) {
			int first = 0, second = 0;
			for (int i = 0; i < N - 1; i++) {
				boolean tmp = (flag & 1 << i) != 0;
				for (int j = i + 1; j < N; j++) {
					if (tmp && (flag & 1 << j) != 0) first += (ability[i][j] + ability[j][i]);
					else if (!tmp && (flag & 1 << j) == 0) second += (ability[i][j] + ability[j][i]);
				}
			}
			MIN = Math.min(MIN, Math.abs(first - second));
			return;
		}

		for (int i = start; i < N; i++) {
			pick(cnt + 1, i+1, flag | 1 << i);
		}
	}
}
