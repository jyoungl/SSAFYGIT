package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_9613_GCD합 {
	static int n;
	static long sum;
	static int[] input, numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			input = new int[n];
			numbers = new int[2];

			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			sum = 0;
			combi(0, 0);
			
			sb.append(sum + "\n");
			
		}
		
		System.out.println(sb);

	}

	private static void combi(int cnt, int start) {
		if(cnt==2) {
			int min = Math.min(numbers[0], numbers[1]);
			int max = 0;
			
			
			for (int i = min; i >= 1; i--) {
				if(numbers[0]%i==0 && numbers[1]%i==0) {
					max = i;
					break;
				}
			}
			
			sum += max;
			
			return;
		}
		
//		if(cnt==2) {
//		int n1 = numbers[0];
//		int n2 = numbers[1];
//		
//		while(true) {
//			int tmp = n1%n2;
//			if(tmp!=0) {
//				n1 = n2;
//				n2 = tmp;
//				continue;
//			} else {
//				sum += n2;
//				return;
//			}
//			
//		}
//	}
		
		for (int i = start; i < n; i++) {
			numbers[cnt] = input[i];
			combi(cnt+1, i+1);
		}
		
	}

}
