package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 1. 색장이의 장수를 나타내는 정수 N
 * 2. 색종이에 관한 입력 왼쪽 가장 아래칸의 번호 x, y 너비, 높이
 * 3. 출력: 각 색종이가 보이는 면적
 * 4. 평면은 가로 1001 세로 1001
 * 
 * >> 배열 안에 색종이를 차례대로 1, 2, 3, 4... 으로 넣고 마지막에 개수 세서 출력
 */
public class b1_10163_색종이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[1001][1001];
		int x, y, width, height;
		
		for(int n = 1; n<=N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			for(int i = x; i<x+width; i++) {
				for(int j = y; j<y+height; j++) {
					arr[i][j] = n; //원래라면 1000-j 해야할것 같지만 어차피 면적만 구하는 거니까 안 함
				}
			}
		}
		
		for(int n = 1; n<=N; n++) {
			int result = 0;
			for(int i = 0; i<1001; i++) {
				for(int j = 0; j<1001; j++) {
					if(arr[i][j]==n) result++;
				}
			}
			System.out.println(result);
		}
	}
}
