package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		outer: for (int i = 0; i < N; i++) {
			int sum = A[i];
			if(sum > M) continue;
			else if(sum == M) {
				cnt++;
				continue;
			}
			for (int j = i+1; j < N; j++) {
				sum += A[j];
				if(sum > M) continue outer;
				else if(sum == M) {
					cnt++;
					continue;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
