package com.ssafy.im;

import java.io.*;
import java.util.*;
//스택 사용

public class BJ_2493_탑_스택사용 {

	// <왼큰수 : 본인 기준 왼쪽에 있는 숫자들 중에서 본인보다 크면서 제일 본인 위치와 가깝게 있는 수> 라고 정의하자.
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] number;
	static int index;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		number = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 초기화
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		// 시작할 때 수열의 가장 뒷 수의 인덱스를 스택의 넣고 시작한다.
		// n-1인 이유는 수열이 0부터 시작하므로
		stack.push(n - 1);

		// 수들을 모두 확인하면 진행
		for (int i = n - 2; i >= 0; i--) { // n-1이 가장 끝수이므로, n-2번째와 비교해야 한다

			// 스택이 비어있지 않다면 현재 number과 스택 내의 수들을 비교한다.
			// 스택 안의 수들과 비교하다가 현재 number이 더 작으면 break, 크면 해당 인덱스 수를 현재 number으로 바꿈
			// peek()해서 나온 인덱스가 i보다 (순서상으로 볼때) 이후 것임
			while (!stack.isEmpty()) {
				if (number[i] < number[stack.peek()]) {
					break;
				} else {// number[i] > number[stack.peek()]
					index = i + 1; // 배열은 0부터 시작하는데, 순서는 1부터 시작하므로
					number[stack.pop()] = index;

				}
			}
			stack.push(i);
		}

		// 스택에 남아있는 인덱스에 해당하는 수들을 0으로 갱신
		while (!stack.isEmpty()) {
			number[stack.pop()] = 0;
		}

		for (int i = 0; i < n; i++) {
			bw.write(number[i] + " ");
		}

		bw.flush();
		bw.close();

	}

}
