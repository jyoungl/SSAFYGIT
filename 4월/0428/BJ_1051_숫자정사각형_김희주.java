import java.io.*;
import java.util.*;

public class BOJ_1051_숫자정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] input = new int[N][M];
		String line;
		for(int i=0;i<N;i++){
			line = in.readLine();
			for(int j=0;j<M;j++){
				input[i][j] = line.charAt(j)-'0';
			}
		}

		int max = 1;
		int l;
		//다른 방법 : k부터 설정하는게 더 빠름. 찾으면 바로 return

		//한칸 한칸 보면서 j+max까지만 돌림
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				for(int k=M-1;k>=j+max;k--){
					if((l=i+(k-j))>=N) continue;
					if(input[i][j]==input[i][k] && input[i][j]==input[l][j] && input[i][k]==input[l][k]){
						max = Math.max(max,k-j+1);
					}
				}
			}

		}

		System.out.println(max*max);
	}
}
