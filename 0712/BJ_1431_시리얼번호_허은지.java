package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_1431_시리얼번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					int n1 = sum(o1);
					int n2 = sum(o2);
					if(n1 == n2) return o1.compareTo(o2);
					else return n1 - n2;
				} else {
					return o1.length() - o2.length();
				}
			}

			private int sum(String str) {
				int sum = 0;
				for (int i = 0; i < str.length(); i++) {
					int num = str.charAt(i) - '0';
					if(num >= 0 && num <= 9) sum += num;
				}
				return sum;
			}
			
		});
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.println(sb);

	}

}
