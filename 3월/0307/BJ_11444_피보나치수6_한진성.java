import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11444_피보나치수6 {
	static final int NUM = 1000000007;
	static final int N = 2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(in.readLine());
		
	
		long arr[][] = new long[2][2];
		
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[1][0] = 1;
		arr[1][1] = 0;
		// N번째 수는 위 행렬의 n제곱의 0,1번째 수
		long ans[][] = fpow(arr, N);
		
		System.out.println(ans[0][1]);
		
	}
	
	static long[][] fpow(long[][] c, long n) {
		
		if(n == 1) {
			return c;
		}else {
			long[][] x = fpow(c, n/2);
			long[][] temp = new long[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						temp[i][j] += x[i][k] * x[k][j];
					}
					temp[i][j] %= NUM;
				}
			}
			if(n%2 == 0) {
				return temp;
			}else {
				long temp2[][] = new long[N][N]; 
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						for(int k=0;k<N;k++) {
							temp2[i][j] += temp[i][k] * c[k][j];
						}
						temp2[i][j] %= NUM;
					}
				}
				return temp2;
			}
		}
		
	}

}
