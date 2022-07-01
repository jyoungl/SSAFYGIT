package 기타;

import java.io.*;
import java.util.*;

public class BJ_10815_숫자카드 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = in.nextInt();

		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			hashSet.add(in.nextInt());
		}

		int M = in.nextInt();
		for (int i = 0; i < M; i++) {
			sb.append(hashSet.contains(in.nextInt()) ? 1 : 0).append(" ");
		}

		System.out.println(sb.toString().trim());
	}

}
