package 기타;

import java.io.*;
import java.util.*;

public class BJ_7785_회사에있는사람 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		HashMap<String, String> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String atWork = st.nextToken();
			// 아래 st.nextToken() 오류나서 위에서 이름을 지정해주고 들어갔음
//			hm.put(st.nextToken(), st.nextToken());
			hm.put(name, atWork);
		}

		ArrayList<String> person = new ArrayList<>();
		for (String name : hm.keySet()) {
			if (hm.get(name).equals("enter")) {
				person.add(name);
			}
		}

		Collections.sort(person, Collections.reverseOrder());
		for (String p : person) {
			sb.append(p + "\n");
		}
		System.out.println(sb);
	}

}
