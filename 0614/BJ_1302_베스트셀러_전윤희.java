package 기타;

import java.io.*;
import java.util.*;

public class BJ_1302_베스트셀러 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 책의 수

		String[] book = new String[N];
		for (int i = 0; i < N; i++) {
			book[i] = br.readLine();
		}

		Arrays.sort(book);
//		System.out.println(Arrays.toString(book));

		int temp = 0; // 반복체크변수
		int[] cnt = new int[N];
		for (int i = 0; i < N; i++) {
			if (i >= 1) {
				if (book[i - 1].equals(book[i])) {
					++temp;
					if (i == N - 1) {
						cnt[i] = temp;
					}
					continue;
				} else {
					cnt[i - 1] = temp;
					temp = 1;
					continue;
				}
			}
			++temp;
		}

		int max = 0;
		int max_idx = 0;
		for (int i = 0; i < N; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				max_idx = i;
			}
		}

		System.out.println(book[max_idx]);
	}

}
