package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 1. 종이의 가로N와 세로M의 길이
 * 2. 칼로 잘라야 하는 점선의 개수 K
 * 3. 가로0, 세로1과 점선 번호
 * 4. 출력: 가장 큰 종이 조각의 넓이
 * 
 * >> 2차원 배열에 숫자 넣기
 * >> 잘린 줄에 1 넣기
 * >> 0을 세다가 1이 나오면
 * 
 * >> 가로(세로) 길이에서 가로(세로)로 자르는 숫자를 빼서 선 세 개 구하기
 * >> 선 세 개 중 가장 큰 값 구해서 곱하기
 * 
 * >> 리스트 써서 가로 길이와 세로 길이 각각 넣기
 * >> 리스트 크기만큼 for문 돌려서 인덱스+1 - 인덱스 값 계산하기 => 선의 길이 구하기
 * >> 선 길이 중 가장 큰 것 구해서 곱하기
 * 
 * >> 배열 써서 하기
 */
public class s5_2628_종이자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int[] nNum = new int[K+1];
		int[] mNum = new int[K+1];
		
		int nMax = 0;
		int mMax = 0;

		nNum[0] = N;
		mNum[0] = M;
		
		for(int i = 1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(dir == 1) {
				nNum[i] = num;
			} else {
				mNum[i] = num;
			}
		}
		
		Arrays.sort(nNum);
		Arrays.sort(mNum);

		for(int i = 1; i<nNum.length; i++) {
			int len = nNum[i] - nNum[i-1];
			nMax = Math.max(nMax, len);
		}
		for(int i = 1; i<mNum.length; i++) {
			int len = mNum[i] - mNum[i-1];
			mMax = Math.max(mMax, len);
		}
		System.out.println(nMax*mMax);
	}
}
