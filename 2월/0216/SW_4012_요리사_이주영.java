import java.util.Scanner;

public class SW_4012_요리사_이주영 {
	
	static int N;
	static int[][] matrix;
	static int[] foodA;
	static int[] foodB;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			matrix = new int[N][N];
			answer = -1;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			foodA = new int[N/2];
			foodB = new int[N/2];
			
			addFood(0, 0, 0);
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	//재귀로 재료 추가 
	static void addFood(int aCnt, int bCnt, int idx) {
		
		if(idx == N) {
			calcS();
		}
		
		//A에 재료 추가
		if(aCnt < N/2) {
			foodA[aCnt] = idx;
			addFood(aCnt+1, bCnt, idx+1);
		}
		
		//B에 재료 추가 
		if(bCnt < N/2) {
			foodB[bCnt] = idx;
			addFood(aCnt, bCnt+1, idx+1);
		}
		
	}
	
	// 시너지 계산 
	static void calcS() {
		int a = 0;
		int b = 0;
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				a += matrix[foodA[i]][foodA[j]];
			}
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				b += matrix[foodB[i]][foodB[j]];
			}
		}
		
		int v = Math.abs(a-b);
		
		if(answer == -1 || answer > v)
			answer = v;
	}

}