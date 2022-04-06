import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992_쿼드트리 {
	static char[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// N = 배열 크기 읽어오기
		int N = Integer.parseInt(in.readLine());
		
		// N*N크기 배열 생성
		arr = new char[N][N];
		
		// 배열에 주어진값 할당
		for(int i=0;i<N;i++) {
			arr[i] = in.readLine().toCharArray();
		}
		// 분할정복 함수 실행
		quad(0,0,N);

	}
	
	// 분할정복 + 재귀 이용하여 4분면 구분지어 처리하기(x,y는 시작지점, count는 비교할 값인데 시작 크기는 전체 배열의 크기 N)
	public static void quad(int x, int y, int count) {
		
		if(isPossible(x,y,count)) {
			System.out.print(arr[x][y]);
			return;
		}
		
		// 비교할 크기를 절반 줄임 
		int next = count/2;
		// 여는 괄호 출력
		System.out.print('(');
		// 1사분면 재귀
		quad(x,y,next);
		// 2사분면 재귀
		quad(x,y+next,next);
		// 3사분면 재귀
		quad(x+next,y,next);
		// 4사분면 재귀
		quad(x+next,y+next,next);
		// 닫는 괄호 출력
		System.out.print(')');
	
		
	}
	
	public static boolean isPossible(int x, int y, int count) {
		int check = arr[x][y];
		
		for(int i=x;i<x+count;i++) {
			for(int j=y;j<y+count;j++) {
				if(check != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
