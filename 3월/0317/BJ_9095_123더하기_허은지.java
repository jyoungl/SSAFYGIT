package A형대비;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 정수 n
 * 출력
 * 1. n을 1,2,3의 합으로 나타내는 방법의 수
 * 
 * >> 순서까지 따져야 함
 * >> 1 2 4 7 13 24 44
 * >>  1 2 3 6  9  20
 */
public class s3_9095_123더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			if(N == 1) {
				sb.append(1).append("\n");
				continue;
			}
			
			arr[0] = 1;
			
			if(N == 2) {
				sb.append(2).append("\n");
				continue;
			}
			
			arr[1] = 2;
			
			if(N == 3) {
				sb.append(4).append("\n");
				continue;
			}
			
			arr[2] = 4;
			
			for(int i = 3; i<N; i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			
			sb.append(arr[N-1]).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
