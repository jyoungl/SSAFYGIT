package 문제풀이;

import java.io.*;
import java.util.*;

public class B1_1157_단어공부 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
        
		String str = br.readLine();
 
		for (int i = 0; i < str.length(); i++) {
			if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') arr[str.charAt(i) - 'a']++;
			else arr[str.charAt(i) - 'A']++;
		}
		
		int max = Integer.MIN_VALUE;
		char ans = 0;
		
		for (int i = 0; i < 26; i++) {
			if(arr[i] == 0) continue;
			if (arr[i] > max) {
				max = arr[i];
				ans = (char) (i + 'A');
			} else if (arr[i] == max) {
				ans = '?';
			}
		}
		
		System.out.print(ans);
	}

}
