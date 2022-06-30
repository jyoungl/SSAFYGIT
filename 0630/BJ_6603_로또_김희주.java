import java.io.*;
import java.util.*;

public class BOJ_6603_로또 {
	static int K;
	static int[] S,pick;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringTokenizer st;
		while(!(line = in.readLine()).equals("0")){
			st = new StringTokenizer(line);
			K = Integer.parseInt(st.nextToken());
			S = new int[K];
			pick = new int[6];
			for(int i=0;i<K;i++) S[i] = Integer.parseInt(st.nextToken());
			Combination(0,0);
			sb.append('\n');
		}

		System.out.print(sb);
	}
	private static void Combination(int cnt, int start){
		if(cnt==6){
			for(int i=0;i<6;i++) sb.append(pick[i]).append(' ');
			sb.append('\n');
			return;
		}
		for(int i=start;i<K;i++){
			pick[cnt] = S[i];
			Combination(cnt+1,i+1);
		}
	}
}
