import java.io.*;
import java.util.*;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] cards = new int[20000001];

		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) cards[Integer.parseInt(st.nextToken())+10000000]++;

		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) sb.append(cards[Integer.parseInt(st.nextToken())+10000000]).append(" ");

		System.out.println(sb);
	}
}