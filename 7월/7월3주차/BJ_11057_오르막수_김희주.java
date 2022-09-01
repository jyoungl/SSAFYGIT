import java.io.*;

public class BOJ_11057_오르막수 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int DIV = 10007;

		int[][] result = new int[N+2][10];
		for(int i=0;i<10;i++) {
			result[1][i] = 1;
			result[2][i] = i+1;
		}

		for(int i=3;i<=N;i++){
			result[i][0] = 1;
			for(int j=1;j<10;j++){
				result[i][j] = (result[i][j-1]+result[i-1][j])%DIV;
			}
		}

		int sum = 0;
		for(int i=0;i<10;i++){
			sum = (sum+result[N][i])%DIV;
		}
		System.out.println(sum);
	}
}
