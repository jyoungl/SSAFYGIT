package com.ssafy.im;

import java.util.*;
import java.io.*;

public class SW_5644_무선충전 {

	static int T; // 테스트케이스
	static int M, bcCount; // 이동시간, BC 개수
	static int[][] bc; // BC에 대한 정보를 저장하는 배열변수(x, y, 충전범위, 성능)

	static int[] A, B; // 사용자 A와 B 좌표정보를 나타내기 위해 배열변수
	static int[] pathA, pathB; // 사용자 A와 B의 이동정보를 나타내기 위한 배열변수

	// 제자리 - 상 - 우 - 하 - 좌
	// output이 계속 잘못나왔던 이유 : 배열은 오른쪽으로 가면 열부분+1이지만, 좌표는 x가 +1 임
	// 따라서 변화량을(dx, dy) 후에 좌표값에 더해줄때 switch 되어야 함
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_모의SW역량테스트_5644_무선충전.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		// 사용자(A, B) 좌표정보를 나타내기위해 배열변수 생성
		A = new int[2]; // (x,y)
		B = new int[2]; // (x,y)

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 이동시간
			bcCount = Integer.parseInt(st.nextToken()); // BC 개수

			// System.out.println(M+" "+bcCount); // 확인차 출력

			// 사용자 A의 좌표 (1,1) 초기화
			A[0] = 1;
			A[1] = 1;
			// 사용자 B의 좌표 (10,10) 초기화
			B[0] = 10;
			B[1] = 10;

			// 사용자 A의 경로
			pathA = new int[M + 1]; // M번 이동할 때, 처음 위치를 포함하므로 이동칸수는 M+1
			// 사용자 B의 경로
			pathB = new int[M + 1]; // M번 이동할 때, 처음 위치를 포함하므로 이동칸수는 M+1

			bc = new int[bcCount][4]; // BC 정보 [4] -> x좌표, y좌표, 충전범위, 성능

			// 사용자 A의 이동정보 배열 초기화
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < M + 1; i++) { // i=0은 시작칸
				pathA[i] = Integer.parseInt(st.nextToken());
			}
			// 사용자 B의 이동정보 배열 초기화
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < M + 1; i++) { // i=0은 시작칸
				pathB[i] = Integer.parseInt(st.nextToken());
			}

			// BC 정보 배열 초기화
			for (int i = 0; i < bcCount; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + tc + " " + totalMaxCharge());
		}

	}

	// totalMaxCharge() : 모든 사용자가 충전한 양의 합의 최댓값(총)
	// How? answer) 둘이 충전할 수 있는 조합 중 합이 최대가 되는 경우 : maxCharge()
	private static int totalMaxCharge() {
		int total = 0;

		// 매 시간마다 각 위치에서 두 사용자의 최대 충전량을 더한다
		for (int i = 0; i < M + 1; i++) { // 각 네모칸(초기 위치(0초)부터 충전을 할 수 있다고 했으므로, i=0인 제자리부터 시작), 시간에 따라 위치 변경
			A[0] = A[0] + dy[pathA[i]];
			A[1] = A[1] + dx[pathA[i]];
			B[0] = B[0] + dy[pathB[i]];
			B[1] = B[1] + dx[pathB[i]];

			// 총 최대 충전량
			total = total + maxCharge();
		}
		return total;
	}

	// maxCharge() : 시간에 따라 A와 B의 위치가 변하는데, 각 시간에 따라 나올 수 있는 최대 충전량
	private static int maxCharge() {
		int max = 0;
		for (int a = 0; a < bcCount; a++) { // 사용자 A의 BC
			for (int b = 0; b < bcCount; b++) { // 사용자 B의 BC
				int sum = 0;

				// 이중포문을 돌면서 모든 경우의 수를 검사함
				// 현 위치(네모칸)에서 최대 충전량
				// 0, 1 -> x, y
				// 각 사용자가 선택한 충전기(사실은 전부 체크함)에서 (x,y)까지의 거리가 충전할 수 있는 거리(D, 충전범위)라면 충전량을 보내주고,
				// 충전을 못한다면 0 리턴
				int aCharge = Math.abs(bc[a][0] - A[0]) + Math.abs(bc[a][1] - A[1]) <= bc[a][2] ? bc[a][3] : 0;
				int bCharge = Math.abs(bc[b][0] - B[0]) + Math.abs(bc[b][1] - B[1]) <= bc[b][2] ? bc[b][3] : 0;

				if (a != b) { // 충전소가 다르면
					sum = aCharge + bCharge; // 충전량 나눌 필요 없이 그냥 더하면 되고
				} else { // 충전소가 같으면
					//sum = aCharge;
					//sum = bCharge;
					sum = Math.max(aCharge, bCharge); // 둘 중에 큰 값 (나누기 2와 같은 효과)
				}

				if (max < sum)
					max = sum;
			}
		}
		return max;
	}

}
