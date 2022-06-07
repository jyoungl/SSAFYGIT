import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		long X = Long.parseLong(st.nextToken());
		
		long Y = Long.parseLong(st.nextToken());


		
		long end = X;
		
		long start = 0;
		
		long percent = ((Y*100) / X);
		
		if(X == Y) {
			System.out.println(-1);
			return;
		}
		boolean check = false;
		while(start <= end) {
			
			long half = (start + end)/2;
			
			long tempPer = (((Y+half)*100)/(X+half));
			
//			System.out.println("perc: "+percent+" tempper: "+tempPer + " start : "+start + " end : "+ end);
			
			if(tempPer != percent) {
				end = half;
				if(start == end) {
					check = true;
					break;
				}
			}else {
				start = half+1;
				
			}
			
		}

		if(!check) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(end);
		
	}

}
