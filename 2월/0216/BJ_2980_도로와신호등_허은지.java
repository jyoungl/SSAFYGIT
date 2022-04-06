package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 1. 신호등의 개수 N 도로의 길이 L
 * 2. 신호등의 정보 D위치, R빨간불, G파란불
 * 출력
 * 도로의 끝까지 이동하는 데 걸리는 시간
 * 
 * >> 더한 뒤 나머지 사용
 */
public class s4_2980_도로와신호등 {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int N = Integer.parseInt(st.nextToken());
		 int L = Integer.parseInt(st.nextToken());
		 
		 int[][] load = new int[2][L];
		 
		 for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int D = Integer.parseInt(st.nextToken());
			 int R = Integer.parseInt(st.nextToken());
			 int G = Integer.parseInt(st.nextToken());
			 load[0][D] = R;
			 load[1][D] = R+G;
		 }
		 
		 int time = 0;
		 
		 for(int i = 0; i<L; i++) {
			 if(load[0][i]==0) time++;
			 else if(load[0][i]!=0 && time%load[1][i] < load[0][i]) {
				 time += load[0][i] - time%load[1][i] + 1;
			 } else if(load[0][i]!=0 && time%load[1][i] >= load[0][i]) time++;
			
		 }
		 System.out.println(time);
	}

}
