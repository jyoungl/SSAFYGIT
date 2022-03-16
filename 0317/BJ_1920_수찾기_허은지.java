package lv21_이분탐색;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 자연수 N
 * 2. N개의 정수
 * 3. 자연수 M
 * 4. M개의 정수
 * 출력
 * 1. M개의 줄에 답을 출력 존재하면 1, 존재하지 않으면 0
 * 조건
 * 1. N안에 M이 존재하는지 보는 것
 * 
 * >> collection.binarysearch
 */
public class s4_1920_수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(Arrays.binarySearch(arr, num) < 0) sb.append(0).append("\n");
			else sb.append(1).append("\n");
		}
		
		System.out.println(sb);

	}

}
