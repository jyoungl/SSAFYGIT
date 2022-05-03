package 구현;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 세로 H 가로 W
 * 2. 블록이 쌓인 높이 H
 * 출력
 * 1. 고이는 빗물의 총량/고이지 않을 경우 0
 */
public class g5_14719_빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		int height = 0;
		int tmp = 0;
		int sum = 0;
		
		for (int i = 0; i < W; i++) {
			if(height > arr[i]) tmp += height-arr[i];
			else {
				sum += tmp;
				height = arr[i];
				tmp = 0;
			}
		}

		height = 0;
		tmp = 0;
		
		for (int i = W-1; i >= 0; i--) {
			if(height > arr[i]) tmp += height-arr[i];
			else {
				sum += tmp;
				height = arr[i];
				tmp = 0;
			}
			if(arr[i]==max) break;
		}

		System.out.println(sum);
		
	}

}
