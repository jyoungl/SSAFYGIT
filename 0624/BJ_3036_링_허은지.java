package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_3036_링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] circle = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			circle[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			int min = Math.min(circle[0], circle[i]);
			int max = 0;
			for (int j = 1; j <= min; j++) {
				if(circle[0]%j==0 && circle[i]%j==0) max = j;
			}
			sb.append(circle[0]/max).append("/").append(circle[i]/max).append("\n");
		}
		
		System.out.println(sb);
	}

}
