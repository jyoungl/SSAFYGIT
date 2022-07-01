import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100_하얀칸 {

	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[8][8];
		
		for(int i=0;i<8;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		int cnt = 0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				
				
				if(arr[i][j] == 'F') {
					
					// 첫번째가 흰색
					if(i % 2 == 0) {
						if(j%2 == 0) {
							cnt++;
						}
					}else {
						if(j%2 == 1) {
							cnt++;
						}
					}
					
				}
				
			}
		}
		
		System.out.println(cnt);
	}
}
