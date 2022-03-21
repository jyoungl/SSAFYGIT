package lv21_이분탐색;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 나무의 수 N 상근이가 가져가려고 하는 나무의 길이 M
 * 2. 나무의높이
 * 출력
 * 1. 절단기에 설정할 수 잇는 높이의 최댓값
 * 조건
 * 1. 위를 자른다
 */
public class s3_2805_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long[] tree = new long[N];
		long max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		//max++;
		long min = 0;
		long mid = 0;
		
//		if(max<M) {
//			System.out.println(0);
//			System.exit(0);
//		}
		
		while(min<max) {
			mid = (max+min)/2;
			long len = 0;
			
			System.out.println(mid + " 최대 " + max + " 최소 " + min);
			
			for(int i = 0; i<N; i++) {
				if(tree[i] - mid > 0) len += tree[i] - mid;
				System.out.println("길이 " + len);
			}
			
			if(len>=M) min = mid+1;
			else max = mid;
		}
		
		System.out.println(max-1);
		

	}

}
