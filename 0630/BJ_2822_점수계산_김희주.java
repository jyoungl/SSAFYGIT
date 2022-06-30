import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_2822_점수계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Score[] input = new Score[8];
		for(int i=0;i<8;i++){
			input[i] = new Score(i+1,Integer.parseInt(in.readLine()));
		}
		Arrays.sort(input);
		int[] idx = new int[5];
		int sum = 0;
		for(int i=0;i<5;i++){
			sum += input[i].score;
			idx[i] = input[i].num;
		}
		Arrays.sort(idx);
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append('\n');
		for(int i=0;i<5;i++) sb.append(idx[i]).append(' ');
		System.out.println(sb);
	}
	private static class Score implements Comparable<Score>{
		int num, score;
		Score(int num, int score){
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Score o) {
			return o.score - this.score;
		}
	}
}
