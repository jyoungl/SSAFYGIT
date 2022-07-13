package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_1449_수리공항승 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] leak = new int[N];
		boolean[] tape = new boolean[1001];
		
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			leak[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(leak);
		
		for (int i = 0; i < N; i++) {
			int n = leak[i];
			if(!tape[n]) {
				for (int j = n; j < L+n; j++) {
					if(j >= 1001) break;
					tape[j] = true;
				}
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
