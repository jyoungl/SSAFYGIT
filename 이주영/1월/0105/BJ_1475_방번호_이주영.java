package jan05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1475_방번호_이주영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		int[] visited = new int[10];
		int ans = 0;
		
		for(int i=0;i<c.length;i++) {
			int x = c[i] - '0';
			
			visited[x]++;
		}
		
		visited[6] += visited[9];
		visited[6] = (visited[6]/2 + visited[6]%2);
		
		for(int i=0;i<9;i++) {
			ans = (ans>visited[i] ? ans : visited[i]);
		}
		
		System.out.println(ans);
	}

}
