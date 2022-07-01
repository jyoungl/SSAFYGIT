package 기타;

import java.io.*;
import java.util.*;

public class BJ_6603_로또 {
	static StringBuilder sb = new StringBuilder();

	// 서로다른 N개, 6개 뽑음, 중복 허용X, 순서상관X => 조합
	static int N;
	static int[] input;
	static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;

			// split() : String[] - String
			String[] lottoString = s.split(" ");

			N = Integer.parseInt(lottoString[0]);

			input = new int[N];
			numbers = new int[6];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(lottoString[i + 1]);
			}

			Arrays.sort(input);

			combination(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		// 기저 조건
		if (cnt == 6) {
			sb.append(Arrays.toString(numbers).replace("[", "").replace(", ", " ").replace("]", ""));
			sb.append("\n");
			return;
		}

		// 유도 파트
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}

	}

}
