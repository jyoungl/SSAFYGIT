package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 테스트 케이스 T
 * 2. 하루에 배달되는 사료의 양 N
 * 3. 1 2 3 4 5 6번 돼지가 첫날에 먹었던 식사의 양
 * 
 * 출력
 * 요구를 들어줄 수 없게 되는 날
 * 
 * >> 첫날+양쪽+건너편 돼지가 먹은 양만큼 둘째날에 줘야 함
 * >> 다 더한 값이 N보다 작아야 함
 * >> 전체 더한 값의 4배만큼 다음 날에 줘야 함
 */
public class s5_3060_욕심쟁이돼지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int cnt = 1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<6; i++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			while(sum<=N) {
				sum *= 4;
				cnt++;
			}
			
			System.out.println(cnt);
		}

	}

}
