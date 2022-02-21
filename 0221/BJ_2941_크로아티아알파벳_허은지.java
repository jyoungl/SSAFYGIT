package im형필수문제;

import java.util.*;
import java.io.*;

/*
 * 입력
 * 알파벳 소문자와 -, =
 * 출력
 * 몇 개의 단어가 크로아티아 알파벳인지
 * 
 * >> if else
 */
public class s5_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		int count = str.length();
		
		for(int i = 0; i < str.length()-1; i++) {
			char c = str.charAt(i);
			if(c=='c') {
				if(str.charAt(i+1) =='=') count--;
				else if(str.charAt(i+1) == '-') count--;
			}
			else if(c=='d') {
				if(str.charAt(i+1)=='-') count--;
				else if(str.charAt(i+1)=='z' && i<str.length()-2 && str.charAt(i+2)=='=') count-=2;
			}
			else if(c=='l' || c=='n') {
				if(str.charAt(i+1)=='j') count--;
			}
			else if(c=='s') {
				if(str.charAt(i+1)=='=') count--;
			}
			else if(c=='z') {
				if(i>=1 && str.charAt(i-1)=='d') continue;
				else if(str.charAt(i+1)=='=') count--;
			}
			
		}

		System.out.println(count);
	}

}
