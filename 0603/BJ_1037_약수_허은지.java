package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_1037_약수 {

//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		 
//		int N = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int[] num = new int[N];
//		
//		for (int i = 0; i < N; i++) {
//			num[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(num);
//		
//		System.out.println(num[0]*num[N-1]);
//
//	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		System.out.println(min*max);

	}

}
