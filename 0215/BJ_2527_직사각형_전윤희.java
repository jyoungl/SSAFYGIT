package com.im.baekjoon;

import java.util.*;
import java.io.*;

public class BJ_2527_직사각형 {

	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileInputStream("input.txt"));

		for (int i = 0; i < 4; i++) {
			// 첫번째 직사각형
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int p1 = in.nextInt();
			int q1 = in.nextInt();

			// 두번째 직사각형
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int p2 = in.nextInt();
			int q2 = in.nextInt();

			if (x1 < x2) {// 기준 사각형 오른쪽에 위치
				// 공통부분 없음
//				if((x2 > p1 && y2 > q1) || (x2> p1 && q2 > y1)) {
//					System.out.println("d");
//				}
				if (x2 > p1) {
					System.out.println("d");
				}
				// 점
				else if ((x2 == p1 && y2 == q1) || (x2 == p1 && q2 == y1)) {
					System.out.println("c");
				}
				// 직선
				else if ((x1 <= x2 && x2 < p1 && y2 == q1) || (y1 <= y2 && y2 < q1 && p1 == x2)
						|| (x1 <= x2 && x2 < p1 && q2 == y1) || (y1 < q2 && q2 <= q1 && x2 == p1)) {
					System.out.println("b");
				}
				// 직사각형
				else
					System.out.println("a");
			} else { // 기준 사각형 왼쪽에 위치
				// 공통부분 없음
				if (p2 < x1) {
					System.out.println("d");
				}
				// 점
				else if ((p2 == x1 && y2 == q1) || (p2 == x1 && q2 == y1)) {
					System.out.println("c");
				}
				// 직선
				else if ((x1 < p2 && p2 <= p1 && y2 == q1) || (y1 <= y2 && y2 < q1 && p2 == x1)
						|| (x1 < p2 && p2 <= p1 && q2 == y1) || (y1 < q2 && q2 <= q1 && x1 == p2)) {
					System.out.println("b");
				}
				// 직사각형
				else
					System.out.println("a");
			}
		}

	}

}
