package jan31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1309_동물원_이주영 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N][3];
		//0->배치x, 1->왼쪽배치, 2->오른쪽배치 (해당 행에서)
		arr[0][0] = arr[0][1] = arr[0][2] = 1;
		
		for(int i=1;i<N;i++) {
			arr[i][0] = arr[i-1][0] + arr[i-1][1] + arr[i-1][2];
			arr[i][1] = arr[i-1][0] + arr[i-1][2];
			arr[i][2] = arr[i-1][0] + arr[i-1][1];
			arr[i][0] %= 9901;
			arr[i][1] %= 9901;
			arr[i][2] %= 9901;
		}
		
		long sum = arr[N-1][0]+arr[N-1][1]+arr[N-1][2];
		System.out.println(sum%9901);
	}

}
