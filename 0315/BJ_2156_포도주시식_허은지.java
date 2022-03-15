package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 포도주 잔의 개수 n
 * 2. 포도주 잔에 있는 포도주의 양
 * 3. 1000 이하의 양의 정수
 * 출력
 * 1. 최대로 마실 수 있는 포도주의 양
 * 조건
 * 1. 포도주 잔을 선택하면 그 잔에 들어 있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 놓아야 함
 * 2. 연속으로 3잔 모두 마실 수 없음
 * 
 * >> 계단오르기 문제
 * >> 마지막 칸 밟는거 빼고 다 같음
 */
public class s1_2156_포도주시식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 
		int[] DP = new int[N + 1];
		int[] arr = new int[N + 1];
 
 
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
 

		DP[1] = arr[1];
		
		if (N >= 2) {
			DP[2] = arr[1] + arr[2];
		}
 
		for (int i = 3; i <= N; i++) {
			DP[i] = Math.max(DP[i - 1] , Math.max(DP[i - 2] + arr[i], DP[i - 3] + arr[i - 1] + arr[i]));
		}
 
		System.out.println(DP[N]);

	}

}
