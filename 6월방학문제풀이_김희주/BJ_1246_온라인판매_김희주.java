import java.io.*;
import java.util.*;

public class BOJ_1246_온라인판매 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] P = new int[M];
		for(int i=0;i<M;i++) P[i] = Integer.parseInt(in.readLine());
		Arrays.sort(P);

		int price = 0;
		int idx = 0;
		int total = 0;
		int tmpTotal;
		for(int p=P[0];p<=P[M-1];p++){
			while (idx<M && p >P[idx]) {
				idx++;
			}
			if(total<(tmpTotal = p*Math.min(N,M-idx))){
				total = tmpTotal;
				price = p;
			}
		}

		System.out.println(price+" "+total);
	}
}
