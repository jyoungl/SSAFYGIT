package feb13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_1339_단어수학_이주영 {
	static int[] word = new int[26];
	static boolean[] visited = new boolean[10];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			char[] ch = br.readLine().toCharArray();
			
			for(int j=0;j<ch.length;j++) {
				int x = ch[j]-'A';
				word[x] += (int) Math.pow(10, ch.length-1-j);
			}
		}
		
		Arrays.sort(word);
		int ans = 0;
		for(int i=25;i>=0;i--) {
			if(word[i] == 0)
				break;
			
			for(int j=9;j>=1;j--) {
				if(visited[j])
					continue;
				
				ans += (word[i]*j);
				visited[j] = true;
				break;
			}
		}
		System.out.println(ans);
	}

}
