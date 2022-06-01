package 기타;

import java.util.*;

public class BJ_1120_문자열 {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);

		String a = in.next();
		String b = in.next();

		int result = a.length(); // 모든 알파벳이 다를 때

		for (int i = 0; i < (b.length()-a.length()) + 1; i++) { // 비교 횟수이므로 +1
			int check = 0;
			for (int j = 0; j < a.length(); j++) {
				// A의 앞에 아무 알파벳이나 추가한 경우
				if (a.charAt(j) != b.charAt(j + i)) { 
					check++;
				}
				/**
				// A의 뒤에 아무 알파벳이나 추가한 경우는 고려 X
				// 어차피 A, B 차이의 최소를 구하는 것이기 때문에
				// 뒤에 붙일 땐 같은 문자를 붙이므로 문자열의 칸이동이 일어나지 않는다
				**/

			}
			
			if (check < result) {
				result = check;
			}
		}

		System.out.println(result);
	}
}
