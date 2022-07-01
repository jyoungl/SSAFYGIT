package 기타;

import java.io.*;
import java.util.*;

public class BJ_11051_이항계수2_DP {
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		long K = in.nextLong();

		dp = new long[(int)N + 1][(int)K + 1];
		System.out.println(paskal(N, K));
	}

	private static long paskal(long n, long k) {
		// 이미 구해놓은 값이 있을 때
		if (dp[(int)n][(int)k] > 0) {
			return dp[(int)n][(int)k];
		}

		// 삼각형의 옆 변에 존재할 때
		if (k == 0 || n == k) {
			return dp[(int)n][(int)k] = 1;
		}
		
		/** 왜 여기서 나누면 맞고, sysout 문에서 나누면 틀리지 : overflow 때문에 나눠주고 가야한다 **/
//		return dp[(int)n][(int)k] = paskal(n - 1, k - 1) + paskal(n - 1, k);
		return dp[(int)n][(int)k] = (paskal(n - 1, k - 1) + paskal(n - 1, k))%10007;
	}

}
