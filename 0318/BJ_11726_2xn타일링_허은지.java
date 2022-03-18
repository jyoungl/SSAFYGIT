package A형대비;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. n
 * 출력
 * 1. 2xn 크기의 직사각형을 채우는 방법의 수를 10007로 나눈 나머지
 * 조건
 * 1. 1x2, 2x1로만 채워야 함
 *
 * >> 1 2 3 5 8 13...
 */
public class s3_11726_2xn타일링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[1000];
		
		DP[0] = 1;
		DP[1] = 2;
		
		for(int i = 2; i<N; i++) {
			DP[i] = (DP[i-1] + DP[i-2])%10007;
		}
		
		System.out.println(DP[N-1]);

	}

}
