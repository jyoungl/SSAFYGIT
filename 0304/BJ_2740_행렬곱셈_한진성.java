import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740_행렬곱셈 {
	static int N,M,K, A[][], B[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(in.readLine()," ");
			for(int j=0;j<M;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st= new StringTokenizer(in.readLine()," ");
		st.nextToken();
		K = Integer.parseInt(st.nextToken());
		
		B = new int[M][K];
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(in.readLine()," ");
			for(int j=0;j<K;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] C = new int[N][K];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<K;j++) {
				
				for(int k=0;k<M;k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
