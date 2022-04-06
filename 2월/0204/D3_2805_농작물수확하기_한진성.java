package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 첫 번째 줄의 중앙 좌표를 기준으로
 * 아래로 한 칸 내려갈 때마다 양옆으로 1칸씩 증가
 * 한 가운데 줄에 도착하면
 * 아래로 한 칸 내려갈 때마다 양 옆으로 1칸씩 감소
 * 별찍기 하듯이 풀지만 좌표를 명확히 할 것
 */
public class IM_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_2805.txt"));
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int arr[][] = new int[N][N];
			
			for(int i=0;i<N;i++) {
				char[] chars = in.readLine().toCharArray(); 
				for(int j=0;j<N;j++) {
					arr[i][j] = chars[j]-'0';
				}
			}
			
			/* 
			 * 마름모를 2개의 삼각형으로 나누어 푸는 방법, i가 1 증가할 때마다 j를 양옆으로 1씩 +시켜준다.
			 * 먼저 0 ~ N/2까지 삼각형 그리기
			 */
			int y = N/2;
			int sum = 0;
			for(int i=0;i<=N/2;i++) {
				for(int j=y-i;j<=y+i;j++) {
					sum = sum + arr[i][j];
				}
			}
			/*
			 * 이후 N-1부터 N/2+1까지 역삼각형 그리기
			 */
			int x = 0;
			for(int i=N-1;i>N/2;i--) {
				for(int j=y-x;j<=y+x;j++) {
					sum = sum + arr[i][j];
				}
				x++;
			}		

			/*
			 * 중간지점을 찾아 증감하는 값을 조절하도록 조건문을 넣는 방법
			 */
//			int start = N/2;
//			int end = N/2;
//			for(int i=0;i<=N;i++) {
//				for(int j=start;j<=end;j++) {
//					sum = sum + arr[i][j];
//				}
//				
//				if(i<N/2) {
//					start--;
//					end++;
//				}else
//				{
//					start++;
//					end--;
//				}
//			}		
			
			
			
			// -- 출력부
			System.out.printf("#%d %d\n",tc,sum);
		}
	}

}
