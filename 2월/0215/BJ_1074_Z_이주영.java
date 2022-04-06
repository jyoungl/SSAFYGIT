import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074_Z_이주영 {
	static int cnt = 0;
	//x,y 시작점
	public static void func(int length, int r, int c) {
		if(length == 1) //기저 조건
			return;
		
		if(r<length/2 && c<length/2) { //1사분면일 때
			func(length/2, r, c);
		}
		else if(r<length/2 && c>=length/2) { //2사분면일 때
			cnt += length * length/4; //1사분면에서 지나친 점들의 수 추가
			func(length/2, r, c-length/2);
		}
		else if(r>=length/2 && c<length/2) { //3사분면일 때
			cnt += (length * length/4) * 2; //2사분면까지 지나친 점들 수 추가
			func(length/2, r-length/2, c);
		}
		else {
			cnt += (length * length/4) * 3; //4사분면일 때
			func(length/2, r-length/2, c-length/2); //3사분면까지 지나친 점들 수 추가
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int r = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		int length = (int) Math.pow(2, N); //전체 길이
		
		func(length, r, c);
		System.out.println(cnt);
	}

}
