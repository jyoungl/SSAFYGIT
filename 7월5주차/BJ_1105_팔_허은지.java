package 문제풀이;

import java.io.*;
import java.util.*;

public class S1_1105_팔 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String strL = st.nextToken();
		String strR = st.nextToken();
		
		int cnt = 0;
		
		if(strL.length() == strR.length()) {
			for(int i=0; i<strL.length(); i++) {
				if(strL.charAt(i) == strR.charAt(i)) {
					if(strL.charAt(i) == '8') cnt++;
				} else break;
			}
		}
		
		System.out.println(cnt);

	}

}
