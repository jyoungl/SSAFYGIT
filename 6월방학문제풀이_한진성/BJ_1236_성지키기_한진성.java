import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1236_성지키기 {

	int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++) {

			arr[i] = in.readLine().toCharArray();

		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean check = false;
				int x = i;
				int y = j;
				
				for(int k=x;k>=0;k--) {
					if(arr[k][y] == 'X') {
						check = true;
					}
				}
				for(int k=x;k<N;k++) {
					if(arr[k][y] == 'X') {
						check = true;
					}
				}
				for(int k=y;k>=0;k--) {
					if(arr[x][k] == 'X') {
						check = true;
					}
				}
				for(int k=y;k<M;k++) {
					if(arr[x][k] == 'X') {
						check = true;
					}
				}
				
				if(!check) {
					arr[x][y] = 'X';
					cnt++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			boolean check = false;
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 'X') {
					check = true;
				}
			}
			if(!check) {
				arr[i][0] = 'X';
				cnt++;
			}
		}
		
		for(int i=0;i<M;i++) {
			boolean check = false;
			for(int j=0;j<N;j++) {
				if(arr[j][i] == 'X') {
					check = true;
				}
			}
			if(!check) {
				arr[0][i] = 'X';
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}
