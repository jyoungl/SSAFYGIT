import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1004_어린왕자 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] start, end;
		int[][] star;
		int N;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

			N = Integer.parseInt(in.readLine());
			star = new int[N][];
			int count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				star[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
				if ((long)(start[0] - star[i][0])*(start[0] - star[i][0]) + (long)(start[1] - star[i][1])*(start[1] - star[i][1]) < (long)star[i][2]*star[i][2]
						!= (long)(end[0] - star[i][0])*(end[0] - star[i][0]) + (long)(end[1] - star[i][1])*(end[1] - star[i][1]) < (long)star[i][2]*star[i][2])
					count++;
			}

			sb.append(count).append('\n');

		}
		System.out.print(sb);
	}
}
