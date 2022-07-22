import java.io.*;
import java.util.*;

public class BOJ_2004_조합0의개수 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		int two = 0, five = 0;

		for(long i=2;i<=N;i*=2) {
			if(N!=0) two += N/i;
			if(M!=0 && i<=M) two -= M/i;
			if(N-M != 0 && i<=N-M) two -= (N-M)/i;
		}
		for(long i=5;i<=N;i*=5) {
			if(N!=0) five += N/i;
			if(M!=0 && i<=M) five -= M/i;
			if(N-M != 0 && i<=N-M) five -= (N-M)/i;
		}

		System.out.println(Math.min(two,five));
	}
}
