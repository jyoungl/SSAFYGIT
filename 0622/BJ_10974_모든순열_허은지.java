package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_10974_모든순열 {
	static int N;
	static int[] input, numbers;
	static boolean[] isSelected;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		P(0);
		
		System.out.println(sb);

	}

	private static void P(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			P(cnt+1);
			isSelected[i] = false;
		}
		
	}

}
