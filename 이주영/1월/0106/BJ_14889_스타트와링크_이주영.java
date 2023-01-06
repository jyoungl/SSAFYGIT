package jan06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크_이주영 {
	static int[][] arr;
	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];

		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(0,1);
		System.out.println(min);
	}

	public static void check(int cnt, int a) {
		if(cnt == N/2) {
/*			int sum = 0;
			int sum2 = 0;
			char[] ch = team.toCharArray();
			int[] ch2 = new int[N/2];
			int x = 0;
			
			for(int i=1;i<=N;i++) {
				if(!visited[i])
					ch2[x++] = i;
			}
			
			for(int i=0;i<N/2;i++) {
				for(int j=i+1;j<N/2;j++) {
					int z = ch[i] - '0';
					int y = ch[j] - '0';
					sum += (arr[z][y]+arr[y][z]);
					sum2 += (arr[ch2[i]][ch2[j]]+arr[ch2[j]][ch2[i]]);
				}
			}
			
			int ans =Math.abs(sum-sum2);
			if(ans == 0) {
				System.out.println(ans);
				System.exit(0);
			}
			min = (min<ans ? min : ans);
			return;*/
			diff();
		}
		
		for(int i=a;i<=N;i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			check(cnt+1, i+1);
			visited[i] = false;
		}
	}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		for(int i=1;i<N;i++) {
			for(int j=i+1;j<=N;j++) {
				if(visited[i]==true && visited[j]==true) {
					start += (arr[i][j] + arr[j][i]);
				}
				else if(visited[i]==false && visited[j]==false) {
					link += (arr[i][j] + arr[j][i]);
				}
			}
		}
		
		int val = Math.abs(start - link);
		
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min=Math.min(min,val);
	}
}
