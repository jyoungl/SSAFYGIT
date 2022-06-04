import java.io.*;

public class BOJ_1058_친구 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		boolean[][] map = new boolean[N][N];

		String line;
		for(int i=0;i<N;i++){
			line = in.readLine();
			for(int j=0;j<N;j++){
				map[i][j] = line.charAt(j)=='Y';
			}
		}

		boolean[][] res = new boolean[N][N];
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				if(i==k) continue;
				for(int j=0;j<N;j++){
					if(i==j || j==k || res[i][j] || map[i][j]) continue;
					if(map[i][k]&&map[k][j]) res[i][j] = true;
				}
			}
		}

		int tmp, answer=0;
		for(int i=0;i<N;i++){
			tmp = 0;
			for(int j=0;j<N;j++){
				if(res[i][j] || map[i][j]) tmp++;
			}
			if(answer<tmp) answer = tmp;
		}

		System.out.println(answer);
	}
}
