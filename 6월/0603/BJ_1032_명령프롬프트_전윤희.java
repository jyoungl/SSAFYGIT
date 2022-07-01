package 기타;

import java.util.*;

public class BJ_1032_명령프롬프트 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		// 문자열을 저장하는 배열변수
		String[] s = new String[N];

		// 문자열 한개씩 저장
		for (int i = 0; i < N; i++) {
			/** 숫자와 문자가 섞여있을 때 Scanner 주의. 신경쓰기 싫으면 BufferedReader */
			// s[i] = in.nextLine();
			s[i] = in.next();
		}

		StringBuilder sb = new StringBuilder();

		// 단어 일치 여부 체크 변수
		boolean flag = true;
		for (int i = 0; i < s[0].length(); i++) {
			char c = s[0].charAt(i);

			flag = true;
			for (int j = 1; j < N; j++) {
				if (c != s[j].charAt(i)) {
					flag = false;
					break;
				}
			}

			if (flag == true) {
				sb.append(c);
			} else {
				sb.append('?');
			}
		}
		System.out.println(sb.toString());

	}

}
