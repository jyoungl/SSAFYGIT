package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스의 개수 T
 * 2. 숫자 N
 * 출력
 * 1. P(N)
 * 조건
 * 1. 나선에서 가장 긴 변에 그 길이만큼의 정삼각형을 추가한다
 * 
 * >> 1 1 1 2 2 3 4 5 7 9 12 16 21
 * >> P(N) = P(N-1) + P(N-5)
 */
public class s3_9461_파도반수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			long[] P = new long[101];
			
			P[1] = 1;
			P[2] = 1;
			P[3] = 1;
			P[4] = 2;
			P[5] = 2;
			
			for(int j = 6; j<=N; j++) {
				P[j] = P[j-1] + P[j-5];
			}
			
			sb.append(P[N]).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
