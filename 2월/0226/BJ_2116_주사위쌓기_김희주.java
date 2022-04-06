import java.io.*;
import java.util.*;

public class BOJ_2116_주사위쌓기 {
	static int[][] dice;
	static int N;
	static int[] pair = {5, 3, 4, 1, 2, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//첫번째 주사위는 모든 경우를 다 돌려볼 수 있음.
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= 6; i++) {
			max = Math.max(max, stackDice(0, i, 0));
		}

		System.out.println(max);
	}

	private static int stackDice(int cnt, int bottom, int sum) {
		if (cnt == N) return sum;

		int max = 0;
		int nBottom = 0;
		for (int i = 0; i < 6; i++) {
			if (bottom == dice[cnt][i]) continue;
			if (bottom == dice[cnt][pair[i]]) {
				nBottom = i;
				continue;
			}
			max = Math.max(max, dice[cnt][i]);
		}

		return stackDice(cnt + 1, dice[cnt][nBottom], sum + max);
	}

}
