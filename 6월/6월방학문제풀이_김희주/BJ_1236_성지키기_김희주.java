import java.io.*;
import java.util.*;

public class BOJ_1236_성지키기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] row = new boolean[N];
		boolean[] col = new boolean[M];

		String line;
		for(int i=0;i<N;i++){
			line = in.readLine();
			for(int j=0;j<M;j++){
				if(line.charAt(j)=='X'){
					row[i] = true;
					col[j] = true;
				}
			}
		}

		int r = 0;
		for(int i=0;i<N;i++){
			if(!row[i]) r++;
		}

		int c=0;
		for(int j=0;j<M;j++){
			if(!col[j]) c++;
		}

		System.out.println(Math.max(r,c));

	}
}
