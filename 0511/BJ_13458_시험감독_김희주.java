import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] test = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) test[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long count = 0;
		for(int i=0;i<N;i++){
			count++;
			if((test[i]-=B)>0) {
				count += Math.ceil((test[i])/(double)C);
			}
		}
		System.out.println(count);

	}
}
