package com.im.baekjoon;

import java.util.*;
import java.io.*;

public class BJ_2491_수열 {

	static int length;
	static int[] sequence;

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		length = in.nextInt(); // 9
		sequence = new int[length];

		// 배열 초기화
		for (int i = 0; i < length; i++) {
			sequence[i] = in.nextInt(); // 1 2 2 4 4 5 7 7 2
		}

		int upCount = 0; // 수열 커질때 최댓값 세는 변수
		int downCount = 0; // 수열 작아질때 최댓값 세는 변수
		// 오류 이유 : print 찍어보니 잘 카운팅 되다가 초기화 부분 만나서 이상해짐
		int temp1 = 0;
		int temp2 = 0;
		// 커지거나
		for (int i = 0; i < length - 1; i++) {
			if (sequence[i] <= sequence[i + 1])
				upCount++;
			else
				upCount = 0; // 초기화
			
			//System.out.println(upCount);
			if(temp1<upCount)
				temp1 = upCount;
		}
		
		// 작아지거나
		for (int i = 0; i < length - 1; i++) {
			if (sequence[i] >= sequence[i + 1])
				downCount++;
			else
				downCount = 0; // 초기화
			if(temp2<downCount)
				temp2 = downCount;
		}

		int result; // 수열 커질/작아질 때 max값 저장변수
		//result = Math.max(upCount, downCount);
		result = Math.max(temp1, temp2);
		System.out.println(result + 1); // +1 하는 이유는 간격이 필요한게 아니라 갯수가 필요하기 때문
				
	}

}
