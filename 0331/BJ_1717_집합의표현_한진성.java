import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {

	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		makeSet(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int command = parseInt(st.nextToken());
			if (command == 0) {
				union(parseInt(st.nextToken()), parseInt(st.nextToken()));
			} else if (command == 1) {
				if (findSet(parseInt(st.nextToken())) != findSet(parseInt(st.nextToken()))) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}

	static int parseInt(String str) {
		return Integer.parseInt(str);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}

	static int findSet(int a) {

		if (a == parents[a]) {
			return a;
		} else {
			return parents[a] = findSet(parents[a]);
		}
	}

	public static void makeSet(int N) {
		parents = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

	}
}
