package 기타;

import java.io.*;
import java.util.*;

public class BJ_1037_약수 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		if(n==1) {
			// n이 1이면 제곱수라는 의미
			int a = in.nextInt();
			System.out.println((int)Math.pow(a, 2));
			
			// 더 이상 입력이 주어지지 않게 됐을 때
			// 아래 if 문이 끝나고 nextInt를 호출하지만 입력이 없으므로
			// NoSuchElement 에러를 낸다.
			System.exit(0);
			// return;
		}

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr);
		System.out.println(arr[0] * arr[n - 1]);
	}

}
