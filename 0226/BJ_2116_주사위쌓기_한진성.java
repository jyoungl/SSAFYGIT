import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	static int N, diceArr[][], ans, totalDiceValue = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(in.readLine());
		
		diceArr = new int [N][6];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < 6; j++) {
				diceArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 0-5 1-3 2-4
		
		dice(totalDiceValue,0,0);
		
		System.out.println(ans);
		
	}

	
	// value : 현재 주사위의 밑면의 값, diceNum : 현재 주사위 번호, sum : 주사위 옆면의 합 누적
	public static void dice( int value, int diceNum, int sum) {
		
		// 주사위의 방문 상태 배열
		boolean[] visited = new boolean[6]; 
		
		int index = 0;
		// 주어진 주사위 밑면의 값와 같은 수의 인덱스를 찾기
		for(int j=0;j<6;j++) {
			if(diceArr[diceNum][j] == value) {
				index = j;
			}					
		}
		// 밑면의 index와 윗면의 index를 방문처리(사용하지 못함)
		visited[index] = true;
		// 주사위 밑면의 맞은편(윗면) 구하기
		if(index == 1 || index == 2) {
			index += 2;
		}else if(index ==3 || index == 4) {
			index -= 2;
		}else if(index == 0) {
			index = 5;
		}else {
			index = 0;
		}
		// 주사위 윗면 방문처리
		visited[index] = true;
		
		// 주사위 윗면의  값 value에 저장 : 현재 주사위의 윗면 = 다음 주사위의 밑면
		value = diceArr[diceNum][index];
		// 주사위 옆면의 최댓값을 저장할 변수
		int max = 0;
		// 주사위 면 수만큼 반복
		for(int i=0;i<6;i++) {
			// 밑면, 윗면이 아닌 값 중에 최댓값 구하기
			if(!visited[i]&&diceArr[diceNum][i] > max) {
				max = diceArr[diceNum][i];
			}
		}
		// 구한 값 누적시키기 ( 옆면의 최댓값의 합)
		sum += max;
//		System.out.println(Arrays.toString(visited));
		// 1차 기저조건 : 모든 주사위를 다 쌓았다면
		if(diceNum == N-1) {
			// 정답을 담는 변수에 최댓값을 넣는다. (sum은 각 경우의 수 별 옆면의 최댓값)
			ans = Math.max(ans, sum);
			//재귀호출 2 : 주사위의 다음 수를 밑면으로 하여 재귀호출한다. 주사위 번호와 누적되는 sum 값은 0으로 초기화한다.
			dice(++totalDiceValue,0,0);
			return;
		}
		// 2차 기저조건
		if(totalDiceValue == 7) {
			return;
		}
		// 재귀호출 1 : 인자값으로는 현재 쌓은 주사위의 윗면의 값, 다음 주사위 번호, 현재까지 누적된 주사위 옆면의 최댓값의 합
		dice(value, diceNum+1, sum);
			
	}
		
		
}
	

