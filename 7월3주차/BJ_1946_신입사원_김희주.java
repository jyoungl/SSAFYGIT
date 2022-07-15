import java.io.*;
import java.util.*;

public class BOJ_1946_신입사원 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(T-->0){
			int N = Integer.parseInt(in.readLine());
			Score[] scores = new Score[N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(in.readLine());
				scores[i] = new Score(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(scores);
			int count = 1;
			int prev = scores[0].interview;
			for(int i=1;i<N;i++){
				if(scores[i].interview < prev) {
					prev = scores[i].interview;
					count++;
				}
			}

			sb.append(count).append('\n');
		}
		System.out.print(sb);
	}
	private static class Score implements Comparable<Score>{
		int document;
		int interview;
		Score(int document, int interview){
			this.document = document;
			this.interview = interview;
		}

		@Override
		public int compareTo(Score o) {
			return this.document-o.document;
		}
	}
}
