package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_1015_수열정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = A[i];
		}
		
		Arrays.sort(B);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(A[i] == B[j]) {
					sb.append(j + " ");
					B[j] = -1;
					break;
				}
			}
		}
		
		System.out.println(sb);

	}

}
