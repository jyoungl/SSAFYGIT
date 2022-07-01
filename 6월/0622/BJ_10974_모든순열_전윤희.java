package 기타;

import java.io.*;
import java.util.*;

public class BJ_10974_모든순열 {
	static int N;
	static int[] input, numbers; // input:입력수배열, numbers:선택수배열
	static boolean[] isSelected;
	static int cnt;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		permutation(0);
	}

	private static void permutation(int cnt) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers).replace("[", "").replace("]", "").replace(", ", " "));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]==true) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}

}
