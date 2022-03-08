import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int R = 0, G = 1, B = 2;
		int N = Integer.parseInt(in.readLine());

		int[][] color = new int[N][3];
		int[][] cost = new int[N][3];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());

			color[i][R] = Integer.parseInt(st.nextToken());
			color[i][G] = Integer.parseInt(st.nextToken());
			color[i][B] = Integer.parseInt(st.nextToken());

			if(i==0) {
				cost[0] = color[0];
				continue;
			}

			cost[i][R] = Math.min(cost[i-1][G],cost[i-1][B])+color[i][R];
			cost[i][G] = Math.min(cost[i-1][R],cost[i-1][B])+color[i][G];
			cost[i][B] = Math.min(cost[i-1][R],cost[i-1][G])+color[i][B];

		}

		System.out.println(cost[N-1][0]>cost[N-1][1]? Math.min(cost[N-1][1], cost[N-1][2]):Math.min(cost[N-1][0],cost[N-1][2]));
	}
}
