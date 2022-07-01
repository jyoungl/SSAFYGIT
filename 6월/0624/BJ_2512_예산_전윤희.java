import java.io.*;
import java.util.*;

// 이분탐색: 구글링
public class BJ_2512_예산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 구역 수
		int[] spot = new int[n]; // 구역별 예산
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			spot[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(spot);
		long cost = Integer.parseInt(br.readLine()); // 총 예산
		long answer = 0;
		
		long left = 0;
		long right = spot[n - 1];
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0; // 모든 구역의 세금 합
			for (int money : spot) {
				if (money >= mid)
					sum = sum + mid; // 예산을 초과하여 상한액만 지급
				else
					sum = sum + money; // 예산 미만이라 요청한 금액만 지급
			}
			if (sum > cost) { // 최종 계획한 세금보다 많이 걷어진 경우,
				right = mid - 1; // 범위를 좁혀서 세금을 줄여본다
			} else {// 최종 계획한 세금보다 적게 걷어진 경우,
				left = mid + 1; // 범위를 좁혀서 세금을 더 높게 걷는다
				answer = Math.max(answer, mid);
			}
		}
		
		System.out.println(answer);
	}

}
