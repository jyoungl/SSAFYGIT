// 초기풀이
package 기타;

import java.io.*;
import java.util.*;

public class BJ_1676_팩토리얼0의개수 {
	static long ans;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		long N = in.nextLong();

		long res = factorial(N);
		System.out.println(res);

		int cnt = 0; // 0개수체크변수
		String temp = String.valueOf(res);
		/* temp.length 주의: java.lang.StringIndexOutOfBoundsException */
		for (int i = temp.length() - 1; i >= 0; i--) {
			if (temp.charAt(i) != '0')
				break;
			cnt++;
		}

		System.out.println(cnt);

	}

	private static long factorial(long N) {
		if (N == 1)
			return 1;
		ans = N * factorial(N - 1);
		return ans;
	}

}

// 구글링
package 구글링;

import java.io.*;
import java.util.*;

public class BJ_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int count = 0;

		while (N >= 5) {
			count += N / 5;
			System.out.println(count);
			N /= 5;
		}
		System.out.println(count);

	}
}
