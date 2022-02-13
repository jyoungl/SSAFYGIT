import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {

	
	// 별 = 4, 동그라미 = 3 네모 = 2 세모 = 1
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		// 라운드 수 만큼 반복
		StringBuilder sb = new StringBuilder();
		for(int r=0;r<N;r++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			
			int[] cardA = new int[Integer.parseInt(st.nextToken())];
			for(int i=0;i<cardA.length;i++) {
				cardA[i] = Integer.parseInt(st.nextToken());
				
			}
			
			st = new StringTokenizer(in.readLine()," ");
			int[] cardB = new int[Integer.parseInt(st.nextToken())];
			
			for(int i=0;i<cardB.length;i++) {
				cardB[i] = Integer.parseInt(st.nextToken());
			}
			int[] cnt1 = new int[5];
			int[] cnt2 = new int[5];
			
			for(int i=0;i<cardA.length;i++) {
				cnt1[cardA[i]]++;
			}
			for(int i=0;i<cardB.length;i++) {
				cnt2[cardB[i]]++;
			}
	
			// 비교 부분
			for(int i=4;i>0;i--) {
				if(cnt1[i] > cnt2[i]) {
					sb.append("A").append("\n");
					break;
				}else if(cnt1[i] < cnt2[i]) {
					sb.append("B").append("\n");
					break;
				}else if(i == 1){
					sb.append("D").append("\n");
					break;
				}
			}
		}
		System.out.print(sb);

	}

}
