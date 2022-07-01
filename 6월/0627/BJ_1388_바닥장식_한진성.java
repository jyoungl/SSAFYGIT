import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1388_바닥장식 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		
		boolean[][] visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<M;j++) {
				if(visited[i][j] == true) {
					continue;
				}
				
				switch(arr[i][j]) {
				case '-':
					for(int k=j;k<M;k++) {
						if(arr[i][k] == arr[i][j]) {
							visited[i][k] = true;
						}else {
							break;
						}
					}
					break;
					
				case '|':
					for(int k=i;k<N;k++) {
						if(arr[k][j] == arr[i][j]) {
							visited[k][j] = true;
						}else {
							break;
						}
					}
					break;
				}
				cnt++;
				
			}
			
		}
		
		System.out.println(cnt);
		
	}

}
