package jan16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1439_뒤집기_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		int zero = 0;
		int one = 0;
		
		if(s[0] == '0')
			zero++;
		else
			one++;
		
		for(int i=1;i<s.length;i++) {
			if(s[i] != s[i-1]) {
				if(s[i] == '0')
					zero++;
				else 
					one++;
			}
		}
		
		System.out.println(Math.min(zero, one));
	}

}
