package com.ssafy.im;

import java.util.*;
import java.io.*;

// 완전이진트리 (complete binary tree)
/**
 * 트리가 완전이진트리 형식
 * 따라서, 트리가 갖는 정점의 총 수를 N이라 했을 때 N/2 정점까지는 자식 노드를 가짐
 * 리프노드는 모두 숫자를 가져야 하고, 그 외의 경우에는 연산자를 가지고 있어야 유효한 식이 됨
 */

public class D4_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D4_1233_사칙연산유효성검사.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine()); // 171
			
			// 트리구조 배열에 저장
			char[] cbTree = new char[T + 1]; // 배열 인덱스(0부터 시작)랑 순서(1부터 시작) 맞추자
			for (int i = 1; i <= T; i++) {
				st = new StringTokenizer(br.readLine());
				 
				st.nextToken(); // 앞에 붙은 순서 번호(노드 번호) 버리고
				cbTree[i] = st.nextToken().charAt(0);  // 정점 저장
			}
			
			// 유효하지 않은 경우
			// 정점 번호가 N/2 이하일 때, 연산자가 아닌 숫자를 가지는 경우
			// 정점 번호가 N/2보다 클 때, 숫자가 아닌 연산자를 가지는 경우
			boolean flag = true;
			for (int i = 1; i <= T; i++) {
				if ((i <= T / 2 && (cbTree[i] >= '0' && cbTree[i] <= '9'))
						|| (i > T / 2 && (cbTree[i] < '0' || cbTree[i] > '9'))) {
					flag = false;
					break;
				}
			}
			System.out.printf("#%d ", tc);
			System.out.println(flag ? 1 : 0); // true면 1, false면 0 출력
		}
	}

}
