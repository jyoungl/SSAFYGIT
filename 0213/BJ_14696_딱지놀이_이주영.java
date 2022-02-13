package bqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 우선순위 : 별4 -> 동그라미3 -> 네모2 -> 세모1
public class BJ_14696_딱지놀이_이주영 {
	static int[] A;
	static int[] B;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char res = '0';
		//라운드 수(N)만큼
		for(int i=0;i<N;i++) {
			A = new int[5]; //숫자에 맞는 인덱스에 갯수 저장
			B = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<=num1;j++)
				A[Integer.parseInt(st.nextToken())]++;
			
			st = new StringTokenizer(br.readLine());
			int num2 = Integer.parseInt(st.nextToken());
			for(int j=1;j<=num2;j++)
				B[Integer.parseInt(st.nextToken())]++;
		
			//승부계산
			for(int j=4;j>=0; j--) {
				if(A[j] > B[j]) {
					res = 'A';
					break;
				}
				else if(A[j] < B[j]) {
					res = 'B';
					break;
				}
				else 
					res = 'D';
			}
			sb.append(res+"\n");
		}
		
		System.out.println(sb);
	}

}
