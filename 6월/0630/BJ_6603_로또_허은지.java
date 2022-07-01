package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_6603_로또 {
	static int k;
	static int[] S, numbers;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			S = new int[k]; // input
			numbers = new int[6];
			
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(0, 0);
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);

	}

	private static void combi(int cnt, int start) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < k; i++) {
			numbers[cnt] = S[i];
			combi(cnt+1, i+1);
		}
		
	}

}
