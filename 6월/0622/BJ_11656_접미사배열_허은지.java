package 문제풀이;

import java.io.*;
import java.util.*;

public class S4_11656_접미사배열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine();
		
		String[] str = new String[word.length()];
		
		for (int i = 0; i < str.length; i++) {
			str[i] = word.substring(i);
		}
		
		Arrays.sort(str);
		
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i] + "\n");
		}
		
		System.out.println(sb);

	}

}
