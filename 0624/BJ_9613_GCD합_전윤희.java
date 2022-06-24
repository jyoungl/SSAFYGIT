package 기타;

import java.io.*;
import java.util.*;

public class BJ_9613_GCD합 {
	static int[] arr;
	static long sum = 0;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(GCD(arr)).append("\n");
		}
		System.out.println(sb);
	}

	private static Object GCD(int[] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				sum = sum + getGCD(arr[i],arr[j]);
			}
		}
		return sum;
	}

	private static int getGCD(int num1, int num2) {
		if (num1 % num2 == 0) {
            return num2;
        }
		return getGCD(num2, num1%num2);
	}
}
