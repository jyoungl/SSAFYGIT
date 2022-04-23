import java.io.*;
import java.util.*;

public class BOJ_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] earth = new int[N+1][N+1];
		int M = Integer.parseInt(st.nextToken());

		int A,B;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			earth[A][B] = earth[B][A] = 1;
		}

		for(int k=1;k<=N;k++){
			for(int i=1;i<=N;i++){
				if(i==k || earth[i][k]==0) continue;
				for(int j=1;j<=N;j++){
					if(j==k || j==i || earth[k][j]==0) continue;
					if(earth[i][j]==0 || earth[i][j]>earth[i][k]+earth[k][j]) earth[i][j] = earth[i][k]+earth[k][j];
				}
			}
		}

		int min = Integer.MAX_VALUE, tmp, kevin=0;
		for(int i=1;i<=N;i++){
			tmp = 0;
			for(int j=1;j<=N;j++){
				if(j==i) continue;
				tmp+=earth[i][j];
			}
			if(min>tmp) {
				min = tmp;
				kevin = i;
			}
		}

		System.out.println(kevin);
	}
}
