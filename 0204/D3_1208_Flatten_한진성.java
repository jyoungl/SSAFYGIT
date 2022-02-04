package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1차원 배열에서
 * 가장 높은 값의 인덱스를 구해 --하고
 * 가장 낮은 값의 인덱스를 구해 ++
 * 이것을 덤프 수 만큼 반복
 * 그 후 가장 높은 값 - 가장 낮은 값 하면 끝 
 * 최고점과 최저점의 차가 0또는 1이라면 break?
 */
public class IM_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_1208.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int arrlength = 100;
		for(int tc = 1;tc<=10;tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[arrlength];
			String[] str = in.readLine().split(" ");
			for(int i=0;i<arrlength;i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			for(int i=0;i<N;i++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxindex=0;
				int minindex=0;
				for(int j=0;j<arrlength;j++) {
					if(arr[j] > max) {
						max = arr[j];
						maxindex = j;
					}
					if(arr[j] < min) {
						min = arr[j];
						minindex = j;
					}
				}
				arr[maxindex]--;
				arr[minindex]++;
				if(max - min == 0 || max - min == 1) {
					break;
				}
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j=0;j<arrlength;j++) {
				if(arr[j] > max) {
					max = arr[j];
				}
				if(arr[j] < min) {
					min = arr[j];
				}
			}
			int answer = max - min;
			
			// -- 출력부
			System.out.printf("#%d %d\n",tc,answer);
		}
		
	}

}
