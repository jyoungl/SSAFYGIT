package 기타;

import java.io.*;
import java.util.*;

public class BJ_1431_시리얼번호 {
	public static int total(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sum = sum + s.charAt(i) - 48;
//				sum = sum + s.charAt(i) - '0';
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 기타의 개수
		String[] serial = new String[N];
		for (int i = 0; i < N; i++) {
			serial[i] = br.readLine();
		}

		Arrays.sort(serial, new Comparator<String>() { // <> 에 대해 오름차순 정렬(default)
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) { // 길이: 오름차순 정렬 (1st)
					return o1.length() - o2.length();
				} else { // 길이가 같다면(if-else)
					// 각자리 숫자합 오름차순 정렬
					if (total(o1) == total(o2)) {
						return o1.compareTo(o2); // (3rd)
					} else {
						return Integer.compare(total(o1), total(o2)); // (2nd)
					}
				}
			}

		});

		for (int i = 0; i < N; i++) {
			sb.append(serial[i] + "\n");
		}
		System.out.println(sb);
	}

}
