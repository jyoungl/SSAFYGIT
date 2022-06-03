package 문제풀이;

import java.io.*;
import java.util.*;

public class B1_1032_명령프롬포트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		char[] file = new char[str.length()];
		for (int j = 0; j < str.length(); j++) {
			file[j] = str.charAt(j);
		}
		
		for (int i = 0; i < N-1; i++) {
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if(file[j] == '?') continue;
				if(file[j] != str.charAt(j)) file[j] = '?';
			}
		}

		for (int j = 0; j < str.length(); j++) {
			System.out.print(file[j]);
		}
		
	}

}
