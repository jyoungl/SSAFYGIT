import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3_이주영 {
	static int[][] arr;
	static int N, M, R;
	public static int[][] calc(int cal, int[][] arr) {
		int x = arr.length; //N
		int y = arr[0].length; //M
		int[][] temp = new int[x][y];
		int[][] temp2 = new int[y][x];
		switch(cal) {
		case 1:
			for(int i=0;i<x;i++) {
				for(int j=0;j<y;j++) {
					temp[i][j] = arr[x-1-i][j];
				}
			}
			break;
		case 2:
			for(int i=0;i<x;i++) {
				for(int j=0;j<y;j++) {
					temp[i][j] = arr[i][y-1-j];
				}
			}
			break;
		case 3:
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					temp2[i][j] = arr[x-1-j][i];
				}
			}
			break;
		case 4:
			for(int i=0;i<y;i++) {
				for(int j=0;j<x;j++) {
					temp2[i][j] = arr[j][y-1-i];
				}
			}
			break;
		case 5:
			//4 -> 1
			for(int i=0;i<x/2;i++) {
				for(int j=0;j<y/2;j++) {
					temp[i][j] = arr[x/2+i][j];
				}
			}
			//1 -> 2
			for(int i=0;i<x/2;i++) {
				for(int j=y/2;j<y;j++) {
					temp[i][j] = arr[i][j-y/2];
				}
			}
			//3 -> 4
			for(int i=x/2;i<x;i++) {
				for(int j=0;j<y/2;j++) {
					temp[i][j] = arr[i][y/2+j];
				}
			}
			//2 -> 3
			for(int i=x/2;i<x;i++) {
				for(int j=y/2;j<y;j++) {
					temp[i][j] = arr[i-x/2][j];
				}
			}
			break;
		case 6:
			//2 (arr) -> 1 (temp)
			for(int i=0;i<x/2;i++) {
				for(int j=0;j<y/2;j++) {
					temp[i][j] = arr[i][j+y/2];
				}
			}
			//3 -> 2
			for(int i=0;i<x/2;i++) {
				for(int j=y/2;j<y;j++) {
					temp[i][j] = arr[i+x/2][j];
				}
			}
			//1 -> 4
			for(int i=x/2;i<x;i++) {
				for(int j=0;j<y/2;j++) {
					temp[i][j] = arr[i-x/2][j];
				}
			}
			//4 -> 3
			for(int i=x/2;i<x;i++) {
				for(int j=y/2;j<y;j++) {
					temp[i][j] = arr[i][j-y/2];
				}
			}
			break;
		}
		
		if(cal == 3 || cal == 4)
			return temp2;
		else
			return temp;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		
		String[] str = br.readLine().split(" ");
		int cal = 0;
		int[][] res = arr.clone();
		int len = str.length;
		
		for(int i=0;i<R;i++) {
			if(i < str.length)
				cal = Integer.parseInt(str[i]);
			res = calc(cal, res).clone();
		}
		
		if(cal == 3 || cal == 4) {
			for(int i=0;i<res.length;i++) {
				for(int j=0;j<res[0].length;j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		}
		else {
			for(int i=0;i<res.length;i++) {
				for(int j=0;j<res[0].length;j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
