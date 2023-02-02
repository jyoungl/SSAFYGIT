package feb02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BJ_1213_팰린드롬만들기2_이주영 {	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] name = br.readLine().toCharArray();
		int len = name.length;
		int[] alpha = new int[26];
		
		for(int i=0;i<len;i++) {
			int idx = name[i] - 'A';
			alpha[idx]++;
		}
			
		char[] ans = new char[len];
		int p = 0;
		int idx = 0;
		for(int i=0;i<alpha.length;i++) {
			int x = alpha[i];
			if(x%2 == 1) {
				p++;
				if(p>=2) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				
				ans[len/2] = (char)(i+65);
			}
			
			for(int j=0;j<x/2;j++) {
				ans[idx] = (char)(i+65);
				ans[len-idx-1] = (char)(i+65);
				idx++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++)
			sb.append(ans[i]);
		
		System.out.println(sb);
	}

}
