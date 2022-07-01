import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11051_이항계수2 {

	static int N;
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] str = in.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		//(p(N) * ((p(N-K)*p(K)%10007,10007-2))%10007
		System.out.println((p(N) * fpow((p(N-K)*p(K))%10007, 10007-2))%10007);

	}

	static int p(int N) {

		if (N <= 1) {
			return 1;
		}

		return (N * p(N - 1)) % 10007;
	}

	static long fpow(long c, long n) {
		
		if(n == 0) {
			return 1;
		}else {
			long x = fpow(c, n/2);
			if(n%2 == 0) {
				return x*x%10007;
			}else {
				return (x*x%10007)*c%10007;
			}
		}
		
	}

}
