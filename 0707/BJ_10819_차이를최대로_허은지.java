package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_10819_차이를최대로 {
	static int N, ans;
	static int[] input, numbers;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		numbers = new int[N];
		selected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		p(0);
		
		System.out.println(ans);

	}

	private static void p(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(numbers[i]-numbers[i+1]);
			}
			
			ans = Math.max(ans, sum);
		}
		
		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			numbers[cnt] = input[i];
			selected[i] = true;
			p(cnt+1);
			selected[i] = false;
		}
		
	}

}
