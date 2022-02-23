import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어_이주영 {
	static int N, shark=2, minx, miny, mind;
	static int[][] arr;
	static int[][] check;
	static int[] dr = {-1, 0, 0, 1}; //위, 왼쪽, 오른쪽, 아래
	static int[] dc = {0, -1, 1, 0};

	public static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		q.add(x);
		q2.add(y);
		check[x][y] = 0;
		
		while(!q.isEmpty()) {
			  int a = q.poll();
		      int b = q2.poll();
		      //System.out.printf("%d %d\n",a,b);
		      //상하좌우 확인
		      for(int k = 0; k < 4;k++) {
		        int da = a + dr[k];
		        int db = b + dc[k];
		        
		        //배열 범위에서 안 벗어났고, 방문 안했고, 물고기가 상어보다 작거나 같으면 (없는 경우인 0 포함)
		        if(da >= 0 && db >= 0 && da < N && db < N && check[da][db] == -1 && shark >= arr[da][db]) {      
		           check[da][db] = check[a][b]+1; //거리 계산
		           
		           //먹을 수 있는 물고기
		           if(arr[da][db] < shark && arr[da][db] != 0) {
		        	   //저장된 최소거리보다 더 가까운 위치의 물고기일 때
		        	   if(mind > check[da][db]) {
		        		   minx = da;
			        	   miny = db;
			        	   mind = check[da][db];   
		        	   }
		        	   //최소거리와 동일할 때
		        	   else if(mind == check[da][db]) {
			        	   //높이가 동일하면
		        		   if(minx == da) {
		        			   //더 왼쪽에 있으면
			        		   if(miny > db) {
			        			   minx = da;
				        		   miny = db;
			        		   }
			        	   } //더 위에 있으면
			        	   else if(minx > da) {
			        		   minx = da;
			        		   miny = db;
			        	   }
		        	   }
			        	   
		           }
		        q.add(da);
				q2.add(db);
		        }
		      }   
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int x=0, y=0;
		arr = new int[N][N];
		int maxx=Integer.MAX_VALUE;
		int maxy=Integer.MAX_VALUE;
		int res = 0;
		int fishcount = 0;
		
		//배열에 먹이 정보 저장
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					x = i; y = j;
					arr[i][j] = 0;
				}
			}
		}

		while(true) {
			mind = Integer.MAX_VALUE;
			minx = Integer.MAX_VALUE;
			miny = Integer.MAX_VALUE;
			check = new int[N][N];
			
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					check[i][j] = -1;
			
			bfs(x, y); //가장 가까이의 먹을 수 있는 물고기 찾아옴

			if(minx != maxx && miny != maxy) {
				res += check[minx][miny];
				arr[minx][miny] = 0;
				fishcount++;
				
				if(shark == fishcount) {
					shark++;
					fishcount = 0;
				}
				
				x = minx;
				y = miny;
			}
			else
				break;
			//System.out.println(res);
		}
		
		System.out.println(res);
	}

}
