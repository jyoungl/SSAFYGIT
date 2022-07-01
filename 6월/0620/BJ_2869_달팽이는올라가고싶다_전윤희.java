package 기타;

import java.io.*;
import java.util.*;

public class BJ_2869_달팽이는올라가고싶다 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		long up = in.nextLong();
		long down = in.nextLong();
		long tree = in.nextLong();

		// 도달해야 하는 값에서 하루에 전진하는 거리를 나눠보자
		// up에서 다시 내려가는 down값을 빼줘야 최대 하루 도달거리(하루 전진거리)
		long day = (tree - down) / (up - down);
		if ((tree - down) % (up - down) != 0) {
			++day;
		}
		System.out.println(day);
	}
}
