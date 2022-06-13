package 기타;

import java.io.*;
import java.util.*;

public class BJ_1326_대칭차집합 {

	public static void main(String[] args) throws Exception {
//		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		int A = in.nextInt();
//		int B = in.nextInt();
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int union = 0;
		int[] arrA = new int[A];
		int[] arrB = new int[B];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
			union++;
		}
		Arrays.sort(arrA);

		int cnt = 0; // 중복카운팅변수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (Arrays.binarySearch(arrA, x) >= 0) {
				cnt++;
				continue;
			}
			union++;
			// arrB[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(union - cnt);

	}

}
