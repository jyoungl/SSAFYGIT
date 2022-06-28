package 기타;

import java.io.*;
import java.util.*;

public class BJ_4796_캠핑 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while (true) {
			++tc;
			int camp = in.nextInt();
			int possibleDay = in.nextInt();
			int holiday = in.nextInt();

			if (camp == 0 && possibleDay == 0 && holiday == 0)
				break;

			if (possibleDay > holiday) {
				sb.append("Case " + tc + ": " + camp + "\n");
				continue;
			}

			int can = holiday / possibleDay;
			int remaining = holiday % possibleDay;
			
			// camp가 remaining 보다 작은 경우가 있을 수 있음
			sb.append("Case " + tc + ": " + (camp * can + Math.min(remaining, camp)) + "\n");
		}
		System.out.println(sb);
	}

}
