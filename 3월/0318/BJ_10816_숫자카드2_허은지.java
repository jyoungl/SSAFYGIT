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
 * >> 이분 탐색으로 탐색
 * >> 
 */
public class s4_10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int start = Arrays.binarySearch(card, num);
			if(start>=0) {
				int cnt = 1;
				for(int j = start+1; j<N; j++) {
					if(card[j]>num) break;
					cnt++;
				}
				for(int k = start-1; k>=0; k--) {
					if(card[k]<num) break;
					cnt++;
				}
				bw.append(cnt+ " ");
			} else bw.append("0 ");
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
