package feb03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1543_문서검색_이주영 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] docu = br.readLine().toCharArray();
		boolean[] visited = new boolean[docu.length];
		char[] word = br.readLine().toCharArray();
		int ans = 0;

		for(int i=0;i<docu.length;i++) {
			if(!visited[i]) {
				int idx = i;
				boolean b = true;
				for(int j=0;j<word.length;j++) {
					if(idx>=docu.length) {
						b = false;
						break;
					}
					if(docu[idx++] != word[j])
						b = false;
				}
				
				if(b) {
					ans++;
					for(int j=i;j<i+word.length;j++) {
						visited[j] =  true;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
