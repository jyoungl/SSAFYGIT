package 기타;

import java.io.*;
import java.util.*;

public class BJ_11728_배열합치기 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); // 배열 A의 크기 N
		int M = in.nextInt(); // 배열 B의 크기 M

		int[] Array1 = new int[N];
		int[] Array2 = new int[M];
		int[] concatArray = new int[N + M];

		for (int i = 0; i < N; i++) {
			Array1[i] = in.nextInt();
		}
		for (int i = 0; i < M; i++) {
			Array2[i] = in.nextInt();
		}

		// System.arraycopy(원본배열, 원본배열에서 복사할 항목의 시작인덱스, 새배열, 새배열에서 붙여넣을 시작인덱스, 원본시작인덱스부터 복사개수);

		System.arraycopy(Array1, 0, concatArray, 0, Array1.length);
		System.arraycopy(Array2, 0, concatArray, N, Array2.length);
		//System.out.println("Concat Array: " + Arrays.toString(concatArray));
		
		Arrays.sort(concatArray);
		System.out.println(Arrays.toString(concatArray).replace("[", "").replace("]", "").replace(", ", " "));

	}

}
