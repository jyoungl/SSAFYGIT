package feb14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1062_가르침_이주영 {
	public static boolean[] alpha = new boolean[26];
	static int N,M,ans;
	static String[] word;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//a n t i c
		//r , r
		//x
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		word = new String[N];
		if(M<5) {
			System.out.println(0);
			return;
		}
		else if(M==26) {
			System.out.println(N);
			return;
		}
		
//		int ans = 0;
//		int cnt = M-5;
//		alpha['a'-'a'] = alpha['i'-'a'] = alpha['n'-'a'] = alpha['t'-'a'] = alpha['c'-'a'] = true;
//		for(int i=0;i<N;i++) {
//			char[] word = br.readLine().toCharArray();
//			boolean b = false;
//			for(int j=4;j<word.length-4;j++) {
//				if(alpha[word[j]-'a'])
//					continue;
//				else {
//					if(cnt<=0) {
//						b = true;
//						break;
//					}
//					cnt--;
//					alpha[word[j] - 'a'] = true;
//				}
//			}
//			
//			if(!b)
//				ans++;
//		}
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			word[i] = str.substring(4, str.length()-4);
		}
		ans=0;
		alpha['a'-'a'] = alpha['i'-'a'] = alpha['n'-'a'] = alpha['t'-'a'] = alpha['c'-'a'] = true;
		combi(0,0);
		System.out.println(ans);
	}
	public static void combi(int idx, int start) {
		if(idx==M-5) {
			int count = 0;
			
			for(int i=0;i<N;i++) {
				boolean b = true;
				for(int j=0;j<word[i].length();j++) {
					if(!alpha[word[i].charAt(j)-'a']) {
						b = false;
						break;
					}
				}
				if(b)
					count++;
			}
			ans = Math.max(ans, count);
			return;
		}
		
		for(int i=start;i<26;i++) {
			if(alpha[i])
				continue;
			
			alpha[i] = true;
			combi(idx+1,i+1);
			alpha[i] = false;
		}
	}

}
