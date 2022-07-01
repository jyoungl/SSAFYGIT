import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1075_나누기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int F = Integer.parseInt(in.readLine());

		int origin = N/100*100;
		for(int i=0;i<100;i++){
			if((origin+i)%F==0){
				if(i<10) System.out.println("0"+i);
				else System.out.println(i);
				break;
			}
		}
	}
}
