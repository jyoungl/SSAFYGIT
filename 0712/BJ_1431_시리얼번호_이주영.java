package jul12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_1431_시리얼번호_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] str = new String[N];
		for(int i=0;i<N;i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					int x = 0; int y = 0;
					for(int i=0;i<o1.length();i++) {
						if(o1.charAt(i)<='9' && o1.charAt(i)>='0') {
							x += Integer.parseInt(String.valueOf(o1.charAt(i)));
						}
					}
					
					for(int i=0;i<o2.length();i++) {
						if(o2.charAt(i)<='9' && o2.charAt(i)>='0') {
							y += Integer.parseInt(String.valueOf(o2.charAt(i)));
						}
					}
					
					if(x == y)
						return o1.compareTo(o2);
					else
						return x-y;
					
				}
				else
					return o1.length() - o2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++)
			sb.append(str[i]+"\n");
		System.out.println(sb);
	}

}
