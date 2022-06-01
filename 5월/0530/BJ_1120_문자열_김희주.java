import java.io.*;
import java.util.*;

public class BOJ_1120_문자열 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		int ans = A.length();//최대값
		int cnt;
		for(int i=0;i<B.length()-A.length()+1;i++){
			cnt = 0;
			for(int j=0;j<A.length();j++){
				if(A.charAt(j) != B.charAt(i+j)) cnt++;
			}
			if(cnt<ans) ans = cnt;
		}

		System.out.println(ans);

	}
}
