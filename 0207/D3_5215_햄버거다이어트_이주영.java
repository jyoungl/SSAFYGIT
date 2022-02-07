import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_5215_햄버거다이어트 {
	static int maxtaste = 0;
	static int N, L;
	static int[][] mat;
	
	public static void func(int idx, int score, int cal) {
		if(cal > L) {
			return;
		}
		
		if(cal <= L) {
			maxtaste = Math.max(maxtaste, score);
		}
		
		if(idx == N) {
			return;
		}
		
		func(idx+1, score+mat[idx][0], cal+mat[idx][1]);
		//최대제한칼로리 초과 -> 해당 재료 빼기
		func(idx+1, score, cal);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		//테스트 케이스 수만큼
		for(int tc=1;tc<=input;tc++) {
			//재료수, 제한칼로리
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			L = Integer.parseInt(str[1]);
			mat = new int[N][2];
			
			//재료 정보 입력
			for(int i=0;i<N;i++) {
				String[] str2 = br.readLine().split(" ");
				mat[i][0] = Integer.parseInt(str2[0]); //맛 점수
				mat[i][1] = Integer.parseInt(str2[1]); //칼로리
			}
			
			func(0, 0, 0);
			
			System.out.print("#"+tc+" "+maxtaste+"\n");
			maxtaste = 0;
		}
	}

}
