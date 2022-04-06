import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

	static int answer= 0;
	static int N, R, C;
	static int X, Y;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		// 배열의 크기
		N = Integer.parseInt(st.nextToken());
		// 행
		R = Integer.parseInt(st.nextToken());
		// 열
		C = Integer.parseInt(st.nextToken());
		
		X = (int) Math.pow(2, N)/2;
		Y = (int) Math.pow(2, N)/2;
		// R과 C는 현재 좌표이고, X, Y는 각각 행열의 배열의 길이에서 2씩 나눈 좌표이다.(가운데)
		// 절반 나누기
		for(int i = --N;i>=0;i--) {
			int size = (int) Math.pow(2, i);
			int add = (int) Math.pow(4, i);
			// 각 사분면에 해당할 떄, 그 사분면 만큼 범위를 좁혀가는 부분.
			if(R < X && C < Y) {
				// 1사분면
				X = X - size/2;
				Y = Y - size/2;
			}else if(R < X && C >= Y) {// 2사분면
				X = X - size/2;
				Y = Y + size/2;
				// answer 변수가 카운트를 하는데, 사분면이 2,3,4넘어갈 때마다
				// 그 이전 사분면에 대한 카운트는 그 사분면의 범위만큼 더해주면 되기 때문에
				// 범위만큼 더해준다. 해당 범위는 2*2^i 즉 4의 i제곱이 된다.
				answer = answer+add*1;
			}else if(R >= X && C < Y) { // 3사분면
				X = X + size/2;
				Y = Y - size/2;
				answer = answer+add*2;
			}else { // 4사분면
				X = X + size/2;
				Y = Y + size/2;
				answer = answer+add*3;
			}
		}
		System.out.println(answer);
	}
	


	
}
