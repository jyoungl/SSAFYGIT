package im형필수문제;

import java.io.*;
import java.util.*;

/*
 * 입력
 * 1. 문자열 S
 * 출력
 * 1. 문자열 S 뒤집기
 * 조건
 * 1. <>는 태그이며 문자가 아니다
 * 
 * >> char로 받아서 stack에 넣기
 */
public class s3_17413_단어뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		char[] ch = new char[str.length()];
		ch = str.toCharArray();
		
		//태그가 아닌 글자를 담아 줄 스택
		Stack<Character> word = new Stack<>();
		
		for(int i = 0; i<ch.length; i++) { 
			//글자가 <인 경우
			if(ch[i]=='<') {
				//<그대로 출력
				sb.append('<');
				while(true) {
					i++;
					sb.append(ch[i]);
					//>가 나올 때까지 그 안에 있는 글자 그대로 출력
					if(ch[i]=='>') break;
				}
			}
			
			//글자가 공백인 경우 그대로 출력
			else if(ch[i]==' ') sb.append(" ");
			
			//글자가 <도 공백도 아닌 문자일 경우
			else {
				while(true) {
					//배열을 벗어나면 break
					if(i >= ch.length) break;
					
					//<나 공백을 만나면 break
					else if(ch[i]=='<') {
						i--;
						break;
					}
					else if(ch[i]==' ') {
						i--;
						break;
					}
					
					//글자를 stack에 추가함
					word.push(ch[i]);
					i++;
				}
				//word.size 계속 변하니까 size로 고정시켜 줘야 함
				int size = word.size();
				
				//while문에서 벗어나면(글자가 끝나거나, <를 만나거나, 공백을 만났을 때)
				for(int j = 0; j<size; j++) {
					//반대로 출력
					sb.append(word.pop());
				}
			}
		}
		
		System.out.println(sb);
	}

}
