package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 1. 학생 수 N 한 방에 배정할 수 있는 최대 인원 수 K
 * 2. 학생의 성별 S(여 0 남 1) 학년 Y(1~6)
 * 3. 출력: 최소한의 방 개수
 * 4. 같은 성별, 같은 학년과 함께 방 배정
 * 
 * >> [2][6] 2차원 배열 만들어서 값 넣기
 */
public class b2_13300_방배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] student = new int[2][6];
		int room = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			student[S][Y-1] += 1; //학생들을 그룹으로 나눔
		}
		
		for(int i = 0; i<2; i++) {
			for(int j = 0; j<6; j++) {
				if(student[i][j]!=0) room++;
				if(student[i][j]>K) { //한 방에 K명이 넘어가면
					room += student[i][j] / K; //해당 인원수를 K명으로 나눠 방 배정(나머지 있는 것까지 고려)
					if(student[i][j]%K==0) room--; //해당 학생이 최대 인원의 배수일 경우 방 하나를 빼야 함(나머지가 없기 때문)
				}
			}
		}
		System.out.println(room);
	}
}
