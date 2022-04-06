package lv21_이분탐색;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 숫자 카드의 개수 N
 * 2. N개의 숫자 카드
 * 3. M
 * 4. 상근이가 구해야 할 숫자 M개
 * 출력
 * 1. 주어진 M개의 수에 대해서 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는 출력
 * 
 * >> 인덱스 배열을 만들고 입력받은 숫자에 해당되는 배열의 index 값에 1씩 추가해 개수를 구한다
 */
public class s4_10816_숫자카드2_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cnt[num + 10000000]++;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(cnt[num + 10000000]).append(" ");
			
		}
		
		System.out.println(sb);

	}

}
