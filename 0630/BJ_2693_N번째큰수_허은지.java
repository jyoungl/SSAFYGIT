package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_2693_N번째큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int[] A = new int[10];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			
			sb.append(A[7] + "\n");
			
		}
		
		System.out.println(sb);

	}

}
