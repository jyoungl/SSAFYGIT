package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색_이주영 {
	static int[][] arr;
	static int N;
	static int M;
	static boolean[][] check;
	static int[] dr = {1, -1, 0, 0}; //아래, 위, 오른쪽, 왼쪽
	static int[] dc = {0, 0, 1, -1};
	static int cnt;
	
	public static void dfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
	    Queue<Integer> queue2 = new LinkedList<Integer>();
	    
	    queue.offer(0); //저장
	    queue2.offer(0);
	    
	    check[0][0] = true;
	    
	    while(!queue.isEmpty()) {
	      int a = queue.poll();
	      int b = queue2.poll();
	      
	      //상하좌우 확인
	      for(int k = 0; k < 4;k++) {
	        int da = a + dr[k];
	        int db = b + dc[k];
	        
	        //유효한 범위인지 확인
	        if(da >= 0 && db >= 0 && da < N && db < M && arr[da][db] == 1 && !check[da][db]) {      
	           queue.offer(da);
	           queue2.offer(db);
	            
	           check[da][db] = true;
	            
	           arr[da][db] = arr[a][b] + 1; //이동횟수
	        }
	        
	      }
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		cnt = 0;
		
		for(int i=0;i<N;i++) {
			char[] ch = br.readLine().toCharArray();
			
			for(int j=0;j<M;j++) {
				arr[i][j] = ch[j] - '0';
			}
		}
		
		dfs();
		System.out.println(arr[N-1][M-1]);
	}

}
