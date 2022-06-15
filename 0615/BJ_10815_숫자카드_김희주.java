import java.io.*;
import java.util.*;

public class BOJ_10815_숫자카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] cards = new int[N];
		for(int i=0;i<N;i++) cards[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(cards);
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			if(Arrays.binarySearch(cards,Integer.parseInt(st.nextToken()))<0) sb.append("0 ");
			else sb.append("1 ");
		}

		System.out.println(sb);
	}
}
