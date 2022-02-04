import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2805_농작물수확하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int[][] farm = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String line = in.readLine();
				for(int j=0;j<N;j++) {
					farm[i][j] = line.charAt(j)-'0';
				}
			}
			
			int profit = 0;
			
			int space = N/2;
			for (int i = 0; i < N; i++) {
				for(int j=0;j<N;j++) {
					if(j>=space && j<N-space) {
						profit += farm[i][j];
					}
				}
				if (i >= N / 2)	space++;
				else space--;

			}
			
			sb.append("#").append(tc).append(" ").append(profit).append("\n");
		}
		
		in.close();
		
		System.out.print(sb);
	}

}
