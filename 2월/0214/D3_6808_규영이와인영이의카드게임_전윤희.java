package com.ssafy.im;

import java.util.*;

public class D3_6808_규영이와인영이의카드게임 {

	static int win;
	static int loss;
	static int[] gyuyeong = new int[9];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			loss = 0;
			boolean[] check = new boolean[19]; // 순서와 인덱스가 동일하게 하기 위함

			for (int i = 0; i < 9; i++) {
				gyuyeong[i] = sc.nextInt();
				check[gyuyeong[i]] = true; // 규영이가 가진 카드번호는 true 처리
			}

			permutation(0, new int[9], check);
			System.out.println("#" + tc + " " + win + " " + loss);
		}

	}

	// 9! = 362,880
	private static void permutation(int selectCnt, int[] inyeong, boolean[] selected) {
		// 기저조건
		if (selectCnt == 9) {
			int winScore = 0;
			int loseScore = 0;
			for (int i = 0; i < 9; i++) {
				if (gyuyeong[i] > inyeong[i]) // 규영이가 이겼으므로 규영이가 점수를 얻고
					winScore = winScore + (gyuyeong[i] + inyeong[i]);
				else if (gyuyeong[i] < inyeong[i]) // 규영이가 졌으므로 인영이가 점수를 얻는다
					loseScore = loseScore + (gyuyeong[i] + inyeong[i]);
			}

			if (winScore > loseScore)
				win++;
			else if (winScore < loseScore)
				loss++;

			return;
		}

		// 유도파트
		for (int i = 1; i <= 18; i++) {
			if (!selected[i]) { // 규영이가 뽑지않은 숫자는 인영이의 숫자
				selected[i] = true;
				inyeong[selectCnt] = i;
				permutation(selectCnt + 1, inyeong, selected);
				selected[i] = false;
			}
		}
	}

}
