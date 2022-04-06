package com.ssafy.im;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//import java.io.InputStreamReader;

public class D3_1228_암호문1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input_D3_1228_암호문1.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 인서트(insert) 기능만 있으므로, 후에 덮어쓰면 됨 (각 케이스마다 암호문 길이가 다르므로 동적으로 크기가 조절되는 배열 필요)
		List<Integer> password = new ArrayList<>();

		for (int tc = 1; tc <= 10; tc++) {

			// 원본 암호문의 길이
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");
			// 원본 암호문 읽어와서 배열리스트에 저장
			for (int i = 0; i < N; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어의 갯수
			int command = Integer.parseInt(br.readLine());
			//System.out.println(command);

			st = new StringTokenizer(br.readLine(), " ");
			// 명령어를 명령어의 갯수만큼 읽어와서 처리
			for (int i = 0; i < command; i++) {
				//st = new StringTokenizer(br.readLine(), " "); : 여기에 넣으면 오류남
				
				String str = st.nextToken(); // 명령어
				int index = Integer.parseInt(st.nextToken()); // index 위치
				int changeCount = Integer.parseInt(st.nextToken()); // 새 문자열 갯수

				for (int j = 0; j < changeCount; j++) {
					int insertNum = Integer.parseInt(st.nextToken()); // 새 문자열
					password.add(index + j, insertNum); // 배열 시작 인덱스는 0 임을 기억하자
				}
			}

			System.out.print("#" + tc + " ");

			for (int i = 0; i < 10; i++) {
				System.out.print(password.remove(0) + " ");
			}
			System.out.println();
			password.clear();
		}
	}

}
