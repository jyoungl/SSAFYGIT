import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken())-1;

		int[][] res = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 3; j++) {
				res[num-1][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 1;
		for (int i = 0; i < N; i++) {
			if (compare(res[K], res[i]) > 0) ans++;
		}

		System.out.println(ans);
	}

	private static int compare(int[] o1, int[] o2) {
		if (o1[0] != o2[0]) return o2[0] - o1[0];
		else if (o1[1] != o2[1]) return o2[1] - o1[1];
		else return o2[2] - o1[2];
	}
}
