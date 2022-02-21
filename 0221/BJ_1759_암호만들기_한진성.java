import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static int C;
	static int L;
	static char[] chars;
	static char[] answer;
	static StringBuilder sb = new StringBuilder();
	static List<String> strs = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		chars = new char[C];
		answer = new char[L];
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<C;i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		
		perm(0,0,' ');
		Collections.sort(strs);
		
		for(int i=0;i<strs.size();i++) {
			sb.append(strs.get(i)).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void perm(int cnt, int flag, char n) {
		
		if(cnt == L) {
			int mCnt = 0;
			int jCnt = 0;
			for(int i=0;i<L;i++) {
				switch(answer[i]) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					mCnt++;
					break;
				default:
					jCnt++;
				}
			}
			if(mCnt >= 1 && jCnt >= 2) {
				String str = "";
				for(int i=0;i<L;i++) {
					str = str + answer[i];
				}
				strs.add(str);
			}
			return;
		}
			
		
		for(int i=0;i<C;i++) {
			if((flag & 1<<i) != 0) {
				continue;
			}
			answer[cnt] = chars[i];
			// 가지치기 1 현재 알파벳이 다음 알파벳보다 작을 경우에만 재귀,
			if(n < answer[cnt]) {
				perm(cnt+1,flag | 1<<i, answer[cnt]);
			}
		}
		
	}

}
