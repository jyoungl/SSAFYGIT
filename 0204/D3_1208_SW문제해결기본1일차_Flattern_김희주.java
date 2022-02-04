import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1208_SW문제해결기본1일차_Flattern {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=10;tc++) {
			int move = Integer.parseInt(in.readLine());
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int[] boxes = new int[100];
			
			for(int i=0;i<100;i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(boxes);
			
			for(;move>0;move--) {
				boxes[0]++;
				boxes[99]--;
				
				//삽입정렬
				for(int i=1;i<100;i++) {
					int tmp = boxes[i];
					int idx = i-1;
					while(idx >= 0 && boxes[idx]>tmp) {
						boxes[idx+1] = boxes[idx];
						idx--;
					}
					boxes[idx+1] = tmp;
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(boxes[99]-boxes[0]).append("\n");
		}
		
		System.out.print(sb);
	}

}
