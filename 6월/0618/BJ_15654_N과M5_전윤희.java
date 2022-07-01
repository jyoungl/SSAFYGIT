package 기타;

import java.io.*;
import java.util.*;

public class BJ_15654_N과M5_조합아니고순열이다 {
	static int N, R;
	static int[] input, numbers; // input: 입력수, numbers: 선택수
	static boolean[] isSelected;
	int cnt;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		R = in.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = in.nextInt();
		}
		Arrays.sort(input);
		permutation(0);
//		System.out.println(sb.toString().trim());
	}
//	private static void combination(int cnt, int start) {
	private static void permutation(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", "").replace(", ", " "));
//			for (int i = 0; i < R; i++) {
//				sb.append(numbers[i]+" ");
//			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]==true) continue;
			numbers[cnt] = input[i];
			isSelected[i]=true;
			
			permutation(cnt+1);
			isSelected[i]=false;
		}
//		for (int i = start; i < N; i++) {
//			numbers[cnt] = input[i];
//			combination(cnt + 1, start);
//		}

	}

}
