package 기타;

import java.io.*;
import java.util.*;

public class BJ_10819_차이를최대로 {

	static int N; // (3 ≤ N ≤ 8) => 브루트포스로 풀어라 : 모든 수들을 순서를 고려하여 나열
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;

	static int result;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();

		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = in.nextInt();
		}
		Arrays.sort(input);

		numbers = new int[N];
		isSelected = new boolean[N];

		result = 0;

		Permutation(0);
		System.out.println(result);
	}

	private static void Permutation(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(numbers[i] - numbers[i + 1]);
			}
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}

			isSelected[i] = true;
			numbers[cnt] = input[i];

			Permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
}
