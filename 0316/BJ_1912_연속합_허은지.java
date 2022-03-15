package lv15_동적계획법1;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 정수 n
 * 2. n개의 정수로 이루어진 수열
 * 출력
 * 1. 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합
 */
public class s2_1912_연속합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] DP = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[0] = arr[0];
		
		//int max = Integer.MIN_VALUE;
		//max를 단순히 Integer.MIN_VALUE 값으로 지정하게 되면 아래 for문에서 arr[0]을 포함하지 못한다
		//max를 arr[0]으로 받아 비교해야 한다
		int max = arr[0];
		
		for(int i = 1; i<N; i++) {
			DP[i] = Math.max(arr[i], DP[i-1]+arr[i]);
			//DP[N-1]이 아닌 max를 구하는 이유
			//포도주 시식이나 계단 오르기 등에서는 arr[i]가 아닌 DP[i-1] 값과 DP[i-2]+α를 비교해서 이전 값을 전달받는다
			//때문에 중간에 값을 건너뛰어도 계속 값을 누적한다
			//이 문제에서는 연속된 수의 합만 구해야 하기 때문에 그때그때 max값을 구해 줘야 한다
			max = Math.max(DP[i], max);
		}
		
		System.out.println(max);

	}

}
