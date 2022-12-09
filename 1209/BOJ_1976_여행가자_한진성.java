import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자_한진성 {
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		makeSet(N);
		StringTokenizer st = null;
		int arr[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					union(i,j);
				}
			}

			
		}

		st = new StringTokenizer(in.readLine());
		int current = findSet(Integer.parseInt(st.nextToken()));
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(findSet(num) != current) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
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
