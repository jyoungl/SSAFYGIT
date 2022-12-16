import java.beans.ConstructorProperties;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195_친구네트워크_한진성 {

	static class Friend {

		int index;
		String name;

		public Friend(int index, String name) {
			this.index = index;
			this.name = name;
		}

		public int makeIndex(String name, int index) {
			if (this.name != name) {
				return index;
			} else {
				return -1;
			}
		}

	}

	static int[] parents;
	static int[] depth;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int F = Integer.parseInt(in.readLine());

			parents = new int[200001];
			depth = new int[200001];
			for (int i = 0; i < 200001; i++) {
				parents[i] = i;
				depth[i] = 1;
			}

			int index = 0;

			Map<String, Integer> map = new HashMap<>();

			StringTokenizer st;
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				String s1 = st.nextToken();
				String s2 = st.nextToken();


				map.putIfAbsent(s1, index++);

				map.putIfAbsent(s2, index++);


				sb.append((union(map.get(s1), map.get(s2)))).append("\n");

			}
			
		}
		System.out.println(sb);
	}

	static int union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) {
			
			return depth[aRoot];
		}
		parents[bRoot] = aRoot;
		depth[aRoot] += depth[bRoot];
		depth[bRoot] = 1;
		return depth[aRoot];
	}

	static int findSet(int a) {

		if (a == parents[a]) {
			return a;
		} else {
			return parents[a] = findSet(parents[a]);
		}
	}

}
