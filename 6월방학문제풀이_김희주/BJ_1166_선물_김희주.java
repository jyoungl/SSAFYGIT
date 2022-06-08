import java.io.*;
import java.util.*;

public class BOJ_1166_선물 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		double low = 0;
		double high = Math.min(L,Math.min(W,H));
		double mid;
		while(low<high){
			mid = (low+high)/2;

			if((long)(L/mid)*(long)(W/mid)*(long)(H/mid)<N){
				if(high==mid) break;
				high = mid;
			}else{
				if(low==mid) break;
				low = mid;
			}
		}
		System.out.println(low);



	}
}
