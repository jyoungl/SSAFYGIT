import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//서로 다른 숫자여야함.
public class BOJ_2503_숫자야구 {
	static int N;
	static int[][] q;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		q = new int[N][5];//100,10,1자리 숫자, 스트라이크, 볼

		String num;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			num = st.nextToken();
			for(int i=0;i<3;i++){
				q[n][i] = num.charAt(i)-'0';
			}
			q[n][3] = Integer.parseInt(st.nextToken());
			q[n][4] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 10; b++) {
				if(a==b) continue;
				for (int c = 1; c < 10; c++) {
					if(a==c || b==c) continue;
					if(isAns(new int[]{a,b,c})) count++;
				}
			}
		}

		System.out.println(count);
	}
	private static boolean isAns(int[] nums){
		boolean[] check = new boolean[3];
		int ss, bb;
		for (int n = 0; n < N; n++) {
			ss = bb = 0;

			for(int i=0;i<3;i++){
				check[i] = nums[i]==q[n][i];
				if(check[i]) ss++;
			}

			if (ss!=q[n][3]) return false;

			for(int i=0;i<3;i++){
				if(check[i]) continue;
				for(int j=0;j<3;j++){
					if(i==j) continue;
					if(nums[i]==q[n][j]){
						check[i] = true;
						bb++;
					}
				}
			}
			if(bb!=q[n][4]) return false;
		}

		return true;
	}
}
