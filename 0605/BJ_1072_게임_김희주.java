import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		double X = Integer.parseInt(st.nextToken());
		double Y = Integer.parseInt(st.nextToken());
		double percent = Math.floor(Y*100/X);
		if(percent>=99){
			System.out.println(-1);
			return;
		}

		int low = 1;
		int high = (int)X;
		int mid;
		int res = -1;
		while(low<=high){
			mid = (low+high)/2;
			if(percent<Math.floor((Y+mid)*100/(X+mid))){
				res = mid;
				high = mid-1;
			}else{
				low = mid+1;
			}
		}

		System.out.println(res);

	}
}
