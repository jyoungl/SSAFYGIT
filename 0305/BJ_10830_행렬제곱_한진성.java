import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830_행렬제곱 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		
		long B = Long.parseLong(st.nextToken());
		
		long[][] arr = new long[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] =  Long.parseLong(st.nextToken());
			}
		}
		long ans[][] = fpow(arr, B);

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(ans[i][j]%1000 + " ");
			}
			System.out.println();
		}

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
					temp[i][j] %= 1000;
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
						temp2[i][j] %= 1000;
					}
				}
				return temp2;
			}
		}
		
	}
}
