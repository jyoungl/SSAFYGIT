import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740_행렬곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++){
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());
		st.nextToken();
		int K = Integer.parseInt(st.nextToken());

		int[][] B = new int[M][K];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<K;j++){
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0;i<N;i++){
			for(int j=0;j<K;j++){
				int elem = 0;
				for(int m=0;m<M;m++){
					elem+=(A[i][m]*B[m][j]);
				}
				sb.append(elem).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
