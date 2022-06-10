import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());
		
		//a-b
		double x = Math.sqrt(Math.pow(ax-bx,2) + Math.pow(ay-by,2));
		//b-c
		double y = Math.sqrt(Math.pow(bx-cx,2) + Math.pow(by-cy,2));
		//a-c
		double z = Math.sqrt(Math.pow(ax-cx,2) + Math.pow(ay-cy,2));
		
		double temp = Math.min(x, Math.min(y, z));
		double max, min;
		
		if((bx-ax)*(cy-ay) == (by-ay)*(cx-ax)) {
			System.out.println("-1");
			return;
		}
		
		if(temp == x) {
			max = (y+z)*2;
			min = (x+Math.min(y, z))*2;
		}
		else if(temp == y) {
			max = (x+z)*2;
			min = (y+Math.min(x, z))*2;
		}
		else {
			max = (y+x)*2;
			min = (z+Math.min(y, x))*2;
		}
		
		double res = max - min;
		System.out.println(res);
	}

}
