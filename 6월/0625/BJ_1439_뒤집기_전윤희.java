package 기타;

import java.io.*;
import java.util.*;

public class BJ_1439_뒤집기 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String[] s = in.next().split("");
		int zero = 0, one = 0;

		// 반복문이 i=1에서부터 시작하므로 처음문자는 따로 처리한다
		if (s[0].equals("0")) {
			zero++;
		} else {
			one++;
		}

		for (int i = 1; i < s.length; i++) {
			if (!s[i - 1].equals(s[i])) { // 다음문자와 같지않으면
				if (s[i].equals("0"))
					zero++;
				else
					one++;
			}
		}
		System.out.println(Math.min(zero, one));
	}

}
