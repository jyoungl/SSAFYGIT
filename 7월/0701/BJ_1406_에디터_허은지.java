package 문제풀이;

import java.io.*;
import java.util.*;

public class S2_1406_에디터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> word = new Stack<>();
		Stack<Character> tmp = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			word.add(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char code = st.nextToken().charAt(0);
			switch(code) {
			case 'P':
				word.add(st.nextToken().charAt(0));
				break;
			case 'L':
				if(word.size()!=0) tmp.add(word.pop());
				break;
			case 'D':
				if(tmp.size()!=0) word.add(tmp.pop());
				break;
			case 'B':
				if(word.size()!=0) word.pop();
				break;
			}
		}
		
		for (int i = 0; i < word.size(); i++) {
			sb.append(word.get(i));
		}
		
		for (int i = tmp.size()-1; i >= 0; i--) {
			sb.append(tmp.get(i));
		}
		
		System.out.println(sb);

	}

}
