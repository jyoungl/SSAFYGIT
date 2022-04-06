import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[6][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			if(gender == 0) {
				arr[level-1][gender]++;
			}else {
				arr[level-1][gender]++;
			}
		}
		int roomCnt = 0;
		for(int i=0;i<6;i++) {
//			System.out.println(Arrays.toString(arr[i]));
			if(arr[i][0] != 0) {
				if(arr[i][0] % K == 0) {
					roomCnt += arr[i][0]/K;
				}else {
					roomCnt += arr[i][0]/K + 1;
				}
			}
			if(arr[i][1]!= 0) {
				if(arr[i][1] % K == 0) {
					roomCnt += arr[i][1]/K;
				}else {
					roomCnt +=arr[i][1]/K + 1;
				}
			}
		}
		
		System.out.println(roomCnt);
		
	}

}
