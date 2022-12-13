import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결_한진성 {

	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int N = parseInt(in.readLine());
		int M = parseInt(in.readLine());

		makeSet(N);
		int[][] arr = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			// A
			arr[i][0] = Integer.parseInt(st.nextToken());
			// B
			arr[i][1] = Integer.parseInt(st.nextToken());
			// 가중치
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		int cost = 0;
		for(int i=0;i<M;i++) {
			if(findSet(arr[i][0]-1) != findSet(arr[i][1]-1)) {
				union(arr[i][0]-1, arr[i][1]-1);
				cost += arr[i][2];
			}
		}
		
		System.out.println(cost);
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