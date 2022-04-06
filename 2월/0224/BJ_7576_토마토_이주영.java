package feb24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토_이주영 {
	static int N;
	static int M;
	static Queue<Tomato> que;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] tom;
	
	public static class Tomato{
		int x;
		int y;
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs() {
		
	    while(!que.isEmpty()) {
	      Tomato t = que.poll();
	      
	      int a = t.x;
	      int b = t.y;
	      
	      //상하좌우 확인
	      for(int k = 0; k < 4;k++) {
	        int da = a + dr[k];
	        int db = b + dc[k];
	        
	        //유효한 범위인지 확인
	        if(da >= 0 && db >= 0 && da < N && db < M) {      
	           if(tom[da][db] == 0) {
	        	   que.add(new Tomato(da, db));
	        	   tom[da][db] = tom[a][b] + 1;
	           }
	        }
	        
	      }
	    }
	    
	    int res = Integer.MIN_VALUE;
	    
	    for(int i=0;i<N;i++) {
	    	for(int j=0;j<M;j++) {
	    		if(tom[i][j] == 0)
	    			return -1;
	    		
	    		res = Math.max(res, tom[i][j]);
	    	}
	    }
	    
	    if(res == 1)
	    	return 0;
	    else
	    	return res-1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //열
		N = Integer.parseInt(st.nextToken()); //행
		
		tom = new int[N][M];
		que = new LinkedList<Tomato>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				tom[i][j] = Integer.parseInt(st.nextToken());
				if(tom[i][j] == 1) {
					que.add(new Tomato(i,j));
				}
			}
		}
		
		int res = bfs();
		System.out.println(res);
	}

}
