package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_1302_베스트셀러2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		String[] book = new String[N];
		
		for (int i = 0; i < N; i++) {
			book[i] = br.readLine();
		}
		
		Arrays.sort(book);
		
		int cnt = 1;
		int max = Integer.MIN_VALUE;
		String title = book[0];
		String ans = book[0];
		
		for (int i = 1; i < book.length; i++) {
			if(book[i].equals(title)) cnt++;
			else {
				if(cnt > max) {
					max = cnt;
					ans = title;
				} else {
					title = book[i];
					cnt = 1;
				}
				
			}
			
		}
		
		if(cnt > max) ans = title;
		
		System.out.println(ans);

	}

}
