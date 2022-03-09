import java.io.*;

public class BOJ_9641_파도반수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] P = new long[101];

		int T = Integer.parseInt(in.readLine());
		while(--T>=0){
			int N = Integer.parseInt(in.readLine());

			if(P[N]==0) {
				for(int i=1;i<=N;i++){
					if(P[i]!=0) continue;
					if(i<=3) P[i] = 1;
					else P[i] = P[i-2]+P[i-3];
				}
			}

			sb.append(P[N]).append("\n");
		}

		System.out.print(sb);
	}
}
