package day_221130;

import java.io.*;
import java.util.*;

// 총총이에 꽂히지말고(첫번째를 특별화하지말고 전체를) 일반화 시킬 것
// 1. 총총이를 set에 넣고
// 2. set에 있는 동물과 만나면 다시 set에 넣어주고 - contain
// 3. 반복
public class BJ_26069_붙임성좋은총총이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		HashSet<String> hs = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		// 1. 총총이를 set에 넣기
		hs.add("ChongChong");

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();

			if (hs.contains(s1)) {
				hs.add(s2);
			} else if (hs.contains(s2)) {
				hs.add(s1);
			}

		}

		System.out.println(hs.size());

	}

}
