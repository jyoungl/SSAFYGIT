import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int L = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		// 가로체크
		for(int i=0;i<N;i++) {
			// 모두 같은 높이인지 체크
			int current = arr[i][0];
			int max = 0;
			int maxIndex = 0;
			boolean check1 = true;
			for(int j=0;j<N;j++) {
				if(current != arr[i][j]) {
					check1 = false;
				}
				if(max < arr[i][j]) {
					max = arr[i][j];
					maxIndex = j;
				}
			}
			if(check1) {
				count++;
				continue;
			}
			// 높이가 다를 경우 1 : 인접한 칸이 2칸 이상 차이날 때
			boolean check2 = false;
			for(int j=1;j<N;j++) {
				if(Math.abs(arr[i][j-1] - arr[i][j]) > 1) {
					check2 = true;
				}
			}
			if(check2) {
				continue;
			}
			
			// 높이가 다를 경우 2 : 인접한 칸이 1칸 차이나고, 경사로를 못 놓는 상황1 - 경사로보다 짧은 칸
			int checkInt = 0;
			int checkCnt = 0;
			boolean[] check = new boolean[N];
			boolean check3 = false;
			for(int j=1;j<N;j++) {
				// 내려갈 경우
				if(arr[i][j-1]-1 == arr[i][j]) {
					// L만큼 길이 있는지 체크
					for(int k=j; k<j+L;k++) {
						if(k >= N || arr[i][k] != arr[i][j] || check[k]) {
							check3 = true;
							break;
						}
						check[k] = true;
					}
				// 올라갈 경우
				}else if(arr[i][j-1]+1 == arr[i][j]) {
					for(int k=j-1; k>=j-L;k--) {
						if(k < 0 || arr[i][k] != arr[i][j-1] || check[k]) {
							check3 = true;
							break;
						}
						check[k] = true;
					}
				}
			}
			if(check3) {
				continue;
			}
			count++;
		}
		
		// 세로체크
		for(int i=0;i<N;i++) {
			// 모두 같은 높이인지 체크
			int current = arr[0][i];
			int max = 0;
			int maxIndex = 0;
			boolean check1 = true;
			for(int j=0;j<N;j++) {
				if(current != arr[j][i]) {
					check1 = false;
				}
				if(max < arr[j][i]) {
					max = arr[j][i];
					maxIndex = j;
				}
			}
			if(check1) {
				count++;
				continue;
			}
			// 높이가 다를 경우 1 : 인접한 칸이 2칸 이상 차이날 때
			boolean check2 = false;
			for(int j=1;j<N;j++) {
				if(Math.abs(arr[j-1][i] - arr[j][i]) > 1) {
					check2 = true;
				}
			}
			if(check2) {
				continue;
			}
			
			// 높이가 다를 경우 2 : 인접한 칸이 1칸 차이나고, 경사로를 못 놓는 상황1 - 경사로보다 짧은 칸
			boolean[] check = new boolean[N];
			boolean check3 = false;
			for(int j=1;j<N;j++) {
				// 내려갈 경우
				if(arr[j-1][i]-1 == arr[j][i]) {
					// L만큼 길이 있는지 체크
					for(int k=j; k<j+L;k++) {
						if(k >= N || arr[k][i] != arr[j][i] || check[k]) {
							check3 = true;
							break;
						}
						check[k] = true;
					}
				// 올라갈 경우
				}else if(arr[j-1][i]+1 == arr[j][i]) {
					for(int k=j-1; k>=j-L;k--) {
						if(k < 0 || arr[k][i] != arr[j-1][i] || check[k]) {
							check3 = true;
							break;
						}
						check[k] = true;
					}
				}
			}
			if(check3) {
				continue;
			}
			count++;
		}
		
		System.out.println(count);
	}

}
