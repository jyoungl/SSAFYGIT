import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1198_삼각형으로자르기 {
	static int N;
	static double MAX = 0;
	static int[][] points;
	static int[][] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		points = new int[N][2];
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		selected = new int[N][2];
		pick(0,0);
		System.out.println(MAX);
	}
	private static void pick(int cnt, int start){
		if(cnt==3){
			//넓이 구하기
			double area = (selected[0][0]*selected[1][1]+selected[1][0]*selected[2][1]+selected[2][0]*selected[0][1])
					-(selected[0][0]*selected[2][1]+selected[2][0]*selected[1][1]+selected[1][0]*selected[0][1]);
			if(area<0) area *= -1;
			area/=2;
			//비교하기
			MAX = Math.max(MAX,area);
			return;
		}

		for(int i=start;i<N;i++){
			selected[cnt] = points[i];
			pick(cnt+1,i+1);
			selected[cnt] = null;
		}
	}
}
