import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와친구들 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N];
		int index = 0;
		arr[0] = 1;
		int cnt = 0;
		if(M == 1) {
			System.out.println(0);
			return;
		}
		while(true) {

			if(arr[index] %2 == 0) {
				for(int i=0;i<L;i++) {
					index--;
					if(index < 0) {
						index = N-1;
					}
				}
			}else {
				index = (index + L)%N;
			}
			
			arr[index]++;
			
			cnt++;
			
			if(arr[index] == M) {
				break;
			}

		}
		System.out.println(cnt);
	}

}
