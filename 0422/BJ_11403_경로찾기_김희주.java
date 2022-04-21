import java.io.*;
import java.util.*;

public class BOJ_11403_경로찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;

		boolean[][] matrix = new boolean[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = st.nextToken().equals("1");
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(matrix[i][j]) continue;
					matrix[i][j] = matrix[i][k] & matrix[k][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				if(matrix[i][j]) sb.append("1 ");
				else sb.append("0 ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}
}
