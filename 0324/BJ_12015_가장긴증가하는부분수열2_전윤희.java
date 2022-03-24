package com.ssafy;

import java.io.*;
import java.util.*;

// 저번에 설명들은것대로 풀어봄

public class BJ_12015_가장긴증가하는부분수열2 {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); // 6 (수열의 크기)
		int[] arr = new int[N]; // 수열을 저장하는 배열 변수

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		// 수열이 제대로 배열에 저장되었는지 디버그
		// System.out.println(Arrays.toString(arr));
		// 10 20 10 30 20 50
		// 0 1 2 3 4 5

		List<Integer> list = new ArrayList<>();
		list.add(arr[0]); // 10
		// System.out.println(list.size());

		for (int i = 1; i < N; i++) {
			if (list.get(list.size() - 1) < arr[i]) { // 다음 수가 앞의 수보다 크다면, list 뒤에 가서 붙는다
				list.add(arr[i]);
				continue;
			} // if end

			// 다음수가 앞의 수보다 작다면, (-(insertion point) - 1)에 해당하는 값을 리턴
			int index = Collections.binarySearch(list, arr[i]); // (-(insertion point) - 1)
			index = -index - 1;

//			int index = i;
//			index = -index;

			if (index >= 0) {
				list.set(index, arr[i]); // 값 변경
			}
		} // for end

		System.out.println(list.size());
	}
}