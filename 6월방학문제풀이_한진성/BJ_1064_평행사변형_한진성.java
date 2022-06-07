import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1064_평행사변형 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		
		double Ax = Double.parseDouble(st.nextToken());
		double Ay = Double.parseDouble(st.nextToken());
		double Bx = Double.parseDouble(st.nextToken());
		double By = Double.parseDouble(st.nextToken());
		double Cx = Double.parseDouble(st.nextToken());
		double Cy = Double.parseDouble(st.nextToken());
		
		double line1;
		double line2;
		double line3;
		double max= 0;
		double min = Double.MAX_VALUE;
		
		// 기울기 - 나눗셈으로 구하면 0으로 나누는 경우가 생김
		double a1 = (Ay-By)*(Bx-Cx);
		double a2 = (By-Cy)*(Ax-Bx);
		
		if(a1 == a2) {
			System.out.println(-1.0);
			return;
		}
	
		// A-B사이의 거리
		line1 = Math.sqrt((double)(Ax-(double)Bx)*(Ax-Bx)+(Ay-By)*(Ay-By));
		// B-C사이의 거리
		line2 = Math.sqrt((double)(Bx-(double)Cx)*(Bx-Cx)+(By-Cy)*(By-Cy));
		// C-A사이의 거리
		line3 = Math.sqrt((double)(Cx-(double)Ax)*(Cx-Ax)+(Cy-Ay)*(Cy-Ay));

		max = Math.max(max, line1*2+line2*2);
		max = Math.max(max, line2*2+line3*2);
		max = Math.max(max, line3*2+line1*2);
		
		min = Math.min(min, line1*2+line2*2);
		min = Math.min(min, line2*2+line3*2);
		min = Math.min(min, line3*2+line1*2);
		
		System.out.printf("%.15f",max-min);
	}

}
