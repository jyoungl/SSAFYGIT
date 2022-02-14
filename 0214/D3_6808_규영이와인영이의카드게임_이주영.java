import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_6808_규영이와인영이의카드게임_이주영 {
	static int[] res; //인영 카드들의 경우의 수
	static boolean[] isSelected; //순열 중복체크 위한 배열
	static int[] arr; //규영 카드
	static int[] arr2; //인영 카드 종류 저장
	static int count; // 규영이 이겼을 경우
	public static void func(int cnt) {
		if(cnt == 9) {
			int A = 0; //인영 점수
			int B = 0; //규영 점수

			for(int i=0;i<9;i++) { //카드 수 만큼
				if(arr[i]>res[i]) //인영이 카드가 더 크면
					A += (arr[i] + res[i]); //인영 점수에 더함
				else //궁금한 점 -> 둘이 같아도 규영 점수에 더해지는데. . .
					B += (arr[i] + res[i]); //규영 점수에 더함
			}
			
			if(A > B)
				count++;
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(isSelected[i]) continue;
			res[cnt] = arr2[i];
			isSelected[i] = true;
			func(cnt+1);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			String[] str = br.readLine().split(" ");
			arr = new int[9]; //규영 카드
			arr2 = new int[9]; //인영 카드
			int[] check = new int[18]; //인영 카드 구하기 위한 체크
			
			//규영이 가진 카드 배열에 저장함
			for(int i=0;i<9;i++) {
				arr[i] = Integer.parseInt(str[i]);
				check[arr[i]-1] = 1;
			}
			
			//인영이 가진 카드 구함
			int x = 0;
			for(int i=0;i<18;i++) {
				if(check[i] == 0)
					arr2[x++] = i+1;
			}
			
			res = new int[9];
			isSelected = new boolean[9];
			count = 0;
			
			func(0);
			
			//362880 = 9! (전체)의 값
			System.out.printf("#%d %d %d\n", tc, count, 362880-count);
		}

		
	}

}
