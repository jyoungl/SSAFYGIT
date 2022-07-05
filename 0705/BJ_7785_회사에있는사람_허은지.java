package 문제풀이;

import java.io.*;
import java.util.*;

public class S5_7785_회사에있는사람 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			if(log.equals("enter")) set.add(name);
			else set.remove(name);
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.println(sb);

	}

}
