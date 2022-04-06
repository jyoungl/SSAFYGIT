import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Vector{
	
	int x;
	int y;
	public Vector(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

public class BOJ_15686_치킨배달 {

	
	static int N, M, arr[][];
	
	static ArrayList<Vector> chList;
	static ArrayList<Vector> hoList;
	static Vector[] chickens;
	static int totalDist = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		
		M = Integer.parseInt(st.nextToken());

		
		
		arr = new int[N][N];
		chList = new ArrayList<>();
		hoList = new ArrayList<>();
		chickens = new Vector[M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					chList.add(new Vector(i,j));
				}
				if(arr[i][j] == 1) {
					hoList.add(new Vector(i,j));
				}
			}
		}		
		
		comb(0,0);
		
		System.out.println(totalDist);
	}
	
	static void comb(int start, int cnt) {
		
		if(cnt == M) {
			int inTotalDist = 0;
			for(int i=0,n=hoList.size();i<n;i++) {
				int inMin = Integer.MAX_VALUE;
				for(int j=0;j<chickens.length;j++) {
					int row =  Math.abs(hoList.get(i).x - chickens[j].x);
					int col =  Math.abs(hoList.get(i).y - chickens[j].y);
					int dist = row + col;
					inMin = Math.min(inMin,dist);
				}
				inTotalDist += inMin;
			}
			totalDist = Math.min(totalDist, inTotalDist);
			return;
		}
		
		for(int i=start, n = chList.size();i<n;i++) {
			
			chickens[cnt] = new Vector(chList.get(i).x, chList.get(i).y);
			
			comb(i+1,cnt+1);
		}
		
		
	}
	
}
