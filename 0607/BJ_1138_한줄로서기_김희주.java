import java.io.*;
import java.util.*;

public class BOJ_1138_한줄로서기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] people = new int[N];
		int order, count;

		for (int i = 1; i <= N; i++) {
			count = 0;
			order = Integer.parseInt(st.nextToken())+1;
			for(int j=0;j<N;j++){
				if(people[j]==0) count++;
				if(count==order) {
					people[j] = i;
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(people[i]).append(' ');
		}
		System.out.print(sb);

	}
}
