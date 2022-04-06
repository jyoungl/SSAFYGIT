import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830_행렬제곱 {
	static int N;
	static int DIV = 1000;
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] A = new int[N][N];	//A가 int이든 long이든 별 차이 없음
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++){
				A[i][j] = Integer.parseInt(st.nextToken())%DIV;//입력받을때부터 DIV로 나눠야함
			}
		}
		
		int[][] result = pow(A,B);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	private static int[][] multiply(int[][] A, int[][] B){
		int[][] result = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				int elem = 0;
				for(int k=0;k<N;k++){
					elem+=(A[i][k]*B[k][j])%DIV;
				}
				result[i][j] = elem%DIV;
			}
		}
		return result;
	}

	private static int[][] pow(int[][] A, long B){
		if(B==1) return A;

		int[][] result = pow(A,B/2);
		result = multiply(result,result);
		return B%2!=0? multiply(result,A):result;
	}
}
