import java.io.*;
import java.util.*;

public class BOJ_1388_바닥장식 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int count = 0;
		char[][] room = new char[N][M];
		for(int i=0;i<N;i++){
			room[i] = in.readLine().toCharArray();
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if((j==0 || room[i][j-1]=='|') && room[i][j]=='-') count++;
				if((i==0 || room[i-1][j]=='-') && room[i][j]=='|') count++;
			}
		}
		System.out.println(count);
	}
}
