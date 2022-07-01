package jun03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1032_명령프롬프트_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		
		for(int i=0;i<n;i++) {
			str[i] = br.readLine();
		}
		
		char[] ans = str[0].toCharArray();
		char[] s = str[0].toCharArray();
		for(int i=1;i<n;i++) {
			char[] temp = str[i].toCharArray();
			
			for(int j=0;j<s.length;j++) {
				if(s[j] != temp[j]) {
					ans[j] = '?';
				}
			}
		}
		
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]);
	}

}
