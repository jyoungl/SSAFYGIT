package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 사람의 수 N
 * 2. 돈을 인출하는 데 걸리는 시간 Pi
 * 출력
 * 필요한 시간의 합의 최솟값
 * 조건
 * 1. 앞 사람이 기다린 시간을 더해야 함
 * 
 * >> 정렬 후 더하기
 */
public class s3_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				sum += time[j];
			}
		}
		
		System.out.println(sum);
	}

}
