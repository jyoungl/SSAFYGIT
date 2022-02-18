import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

	static int food[][];
	static int N;
	static int numbers[];
	static int subnum[];
	static int min = Integer.MAX_VALUE;
	static List<int[]> list;
	static List<Integer> sum;
	static int s1;
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 버퍼드리더로 값 읽어오기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(in.readLine());
		numbers = new int[N / 2];
		food = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list  = new ArrayList<>();
		
		comb(0, 0, N, N/2);
		
		sum = new ArrayList<>();
		
		numbers = new int[2];
		
		min = Integer.MAX_VALUE;
		// 두 음식의 맛 차이가 최소
		for(int i=0,n=list.size();i<n;i++) {
			comb2(0,0,list.get(i).length,2,list.get(i));
			sum.add(s1);
			s1=0;
//				System.out.println("=========");
		}
//		System.out.println(sum);
		
		for(int i=0,n=sum.size();i<n/2;i++) {
			int m1 = sum.get(i);
			int m2 = sum.get(n-i-1);
			
			min = Math.min(min, Math.abs(m1-m2));
		}
			// 음식의 맛 비교

		System.out.println(min);
	}

	

	static void comb2(int cnt, int start, int N, int R, int input[]) {
		
		// 기저조건
		if(cnt == R) {
			s1 += food[numbers[0]][numbers[1]];
			s1 += food[numbers[1]][numbers[0]];
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//유도파트
		for(int i=start;i<N;i++) {
			numbers[cnt] = input[i];
			comb2(cnt+1,i+1,N,R,input);
		}
		
	}
	
	static void comb(int cnt, int start, int N, int R) {

		// 기저조건
		if (cnt == R) {
//			System.out.println(Arrays.toString(numbers));
			list.add(numbers.clone());
			return;
		}

		// 유도파트
		for (int i = start; i < N; i++) {

			numbers[cnt] = i + 1;

			comb(cnt + 1, i + 1,N,R);

		}

	}

}
