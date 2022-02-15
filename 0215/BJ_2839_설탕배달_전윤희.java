package com.ssafy.im;

import java.util.*;
import java.io.*;

class BJ_2839_설탕배달 {

	static int N; // 배달해야 할 설탕 총 무게
	static int[] sugar; // 각 무게별 최소 봉지의 개수를 저장할 배열 변수
	//sugar[1] = 2 : 1kg 봉지 2개

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		sugar = new int[5001]; // 최대 5000kg 배달가능하고, 인덱스 0번은 버림

		// 배열 초기화
		for (int i = 0; i < sugar.length; i++) {
			sugar[i] = Integer.MAX_VALUE - 1; 
			// 자꾸 인덱스 에러나길래 짜증나서 최대한 크게 잡아버림
			// -1을 한 이유는 아래 for문에서 i번째 무게는 최솟값 + 1인데 max_value에 +1 하면 오류날까봐
		}
		
		sugar[3] = sugar[5] = 1; // 3kg, 5kg 봉지 각각 1개

		// 3 <= N <= 5000 이므로 3, 5kg은 위에서 1개로 지정해줬으므로 고려할 필요가 없고
		// 4kg인 경우엔 -1을 출력하도록 했으니 
		// 6kg 이상부터 고려해준다
		for (int i = 6; i <= N; i++) { // 6kg 부터 고려한다
			sugar[i] = Math.min(sugar[i - 3], sugar[i - 5]) + 1;
			// sugar[6] 부터 차례로 저장
			// i번째 무게는 3칸전 or 5칸전 중 더 작은 값(Math.min)임
			// 따라서, i번째 무게는 3칸후, 5칸후가 될테니까 +1
		}

		// N 무게를 만들 수 없을 때 -1 출력
		if (sugar[N] >= Integer.MAX_VALUE - 1) {
			System.out.println(-1);
		} else {
			System.out.println(sugar[N]);
		}

	}

}
