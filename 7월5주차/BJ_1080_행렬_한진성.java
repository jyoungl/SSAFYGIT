import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1080_행렬 {
	static char[][] arr1;
	static char[][] arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());
		
		arr1 = new char[N][M];
		arr2 = new char[N][M];
		
		for(int i=0;i<N;i++) {
			arr1[i] = in.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			arr2[i] = in.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i=0;i<N-2;i++) {
			for(int j=0;j<M-1;j++) {
				
				if(arr2[i][j] != arr2[i][j]) {
					reverse(i,j);
					cnt++;
				}
				
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr1[i][j] != arr2[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);
	}

	static void reverse(int x, int y) {
		
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				
				if(arr1[i][j] == '1') {
					arr1[i][j] = '0';
				}else {
					arr1[i][j] = '1';
				}
				
			}
		}
		
	}
	
}
