package day_0326;

import java.io.*;
import java.util.*;

public class BJ_1337_올바른배열 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] num = new int[N];

		HashSet<Integer> hs = new HashSet<>();

		// 1. 숫자 배열 입력받은 후 오름차순 정렬
		for (int i = 0; i < N; i++) {
			num[i] = in.nextInt();
			hs.add(num[i]);
		}

		// 2. HashSet을 이용하여 중복 체크
		int min = 4;
		for (int i = 0; i < N - 1; i++) {
			int cnt = 1; // 기준 숫자 : num[i]
			for (int j = num[i] + 1; j < num[i] + 5; j++) {
				if (hs.contains(j)) // 해시맵에 이미 그 숫자가 존재한다면 카운트
					cnt++;
			}
			min = Math.min(min, 5 - cnt);
		}
		
		System.out.println(min);
	}
}
