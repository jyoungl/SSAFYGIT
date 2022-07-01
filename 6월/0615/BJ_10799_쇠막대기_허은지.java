package 문제풀이;

import java.io.*;
import java.util.*;

public class S3_10799_쇠막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        char[] c = br.readLine().toCharArray(); 
        Stack<Character> stack = new Stack<>();
        int ans = 0; 
         
        for(int i = 0; i < c.length; i++) {
 
            if(c[i] == '(') stack.push(c[i]);
            else {
                if(c[i-1]=='(') {stack.pop(); ans += stack.size();}
                else {stack.pop(); ans++;}
            }
        }
        
        System.out.println(ans);
    }
}