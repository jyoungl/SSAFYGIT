package 기타;

import java.io.*;
import java.util.*;

public class BJ_15657_N과M8 {
	static int N, R;
	static int[] input, numbers;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		R = in.nextInt();

		input = new int[N]; // 입력수 배열
		numbers = new int[R]; // 뽑은 수 배열

		for (int i = 0; i < N; i++) {
			input[i] = in.nextInt();
		}
		Arrays.sort(input);

		// 중복조합
		H(0, 0);

	}

	private static void H(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", "").replace(", ", " "));
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			H(cnt + 1, i);
		}
	}

}
