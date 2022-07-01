package 기타;

import java.io.*;
import java.util.*;

public class BJ_1026_보물 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = in.nextInt();
		}
		Arrays.sort(A); // A를 오름차순으로 정렬

		Integer[] B = new Integer[N];
		for (int i = 0; i < N; i++) {
			B[i] = in.nextInt();
		}
		// B를 재배열 하면 안된다고 했지만, 어차피 결과값만 나오면 되므로 상관 없다
		Arrays.sort(B, Collections.reverseOrder()); // B를 내림차순으로 정렬

		int res = 0;
		// A의 가장 작은 값과 B의 가장 큰 값을 곱해서 더하므로 자동적으로 최솟값
		for (int i = 0; i < N; i++) {
			res += A[i] * B[i];
		}

		System.out.println(res);
	}

}
