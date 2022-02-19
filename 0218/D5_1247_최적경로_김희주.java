import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {
	static Points[] clients;
	static int N, MIN;
	static Points home;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			clients = new Points[N];
			MIN = Integer.MAX_VALUE;

			st = new StringTokenizer(in.readLine());

			Points company = new Points(st.nextToken(), st.nextToken());
			home = new Points(st.nextToken(), st.nextToken());
			for (int i = 0; i < N; i++) clients[i] = new Points(st.nextToken(), st.nextToken());

			dfs(0, company, 0, 0);

			sb.append("#").append(tc).append(" ").append(MIN).append("\n");
		}

		System.out.print(sb);

	}

	private static void dfs(int cnt, Points prev, int sum, int flag) {
		if (sum >= MIN) return;

		if (cnt == N) {
			MIN = Math.min(MIN, sum + home.getDistance(prev));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue;
			dfs(cnt + 1, clients[i], sum + prev.getDistance(clients[i]), flag | 1 << i);
		}
	}
}

class Points {
	int x;
	int y;

	Points(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}

	int getDistance(Points o) {
		return Math.abs(this.x - o.x) + Math.abs(this.y - o.y);
	}
}