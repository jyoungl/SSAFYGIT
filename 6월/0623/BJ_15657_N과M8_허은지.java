package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_15657_N과M8 {
	static StringBuilder sb;
	static int N, M;
	static int[] input, numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		P(0, 0);
		
		System.out.println(sb);

	}

	private static void P(int cnt, int start) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			P(cnt+1, i);
		}
		
	}

}
