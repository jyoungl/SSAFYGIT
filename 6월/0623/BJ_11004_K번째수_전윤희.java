package 기타;

import java.io.*;
import java.util.*;

/**
 * 퀵 정렬은 분할 정복 알고리즘 중 하나이며 정렬속도 매우 빠름 
 * 최선, 평균 = O(N log N) / 최악 = O(N^2)의 시간복잡도를 가짐 
 * <방법> 
 * 1. 배열의 정 가운데 요소를 피벗으로 정한다 
 * 2. 왼쪽부터 L커서가 피벗보다 큰 값을 탐색, 오른쪽부터 R커서가 피벗보다 작은값 탐색 
 * 3. 발견시 L과 R 교환
 */
public class BJ_11004_K번째수_퀵소트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		quickSort(arr, 0, arr.length - 1);

		System.out.println(arr[K - 1]);

	}

	/**
	 * 이때 L 기준으로 파티션을 나누면
	 * 왼쪽은 L 보다 작은 값들이 있고, 오른쪽은 큰 값들이 있다
	 * 각 파티션의 요소가 한 개가 될 때까지 퀵정렬을 진행하면 모두 정렬이 되어있다
	 */
	private static void quickSort(int[] arr, int L, int R) {
		// 파티션 나누고 오른쪽 값 첫번째 값을 받아옴
		int part2 = partition(arr, L, R);

		// 왼쪽 파티션의 요소가 하나 이상
		if (L < part2 - 1)
			quickSort(arr, L, part2 - 1);
		// 오른쪽 파티션의 요소가 하나 이상
		if (part2 < R)
			quickSort(arr, part2, R);
	}

	private static int partition(int[] arr, int L, int R) {
		int pivot = arr[(L + R) / 2];
		while (L <= R) {
			while (arr[L] < pivot)
				L++;
			while (arr[R] > pivot)
				R--;
			if (L <= R) {
				swap(arr, L, R);
				L++;
				R--;
			}
		}
		return L;
	}

	private static void swap(int[] arr, int L, int R) {
		int temp = arr[L];
		arr[L] = arr[R];
		arr[R] = temp;
	}

}
