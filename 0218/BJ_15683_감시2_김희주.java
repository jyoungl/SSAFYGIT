import java.io.*;
import java.util.*;

public class BOJ_15683_감시2 {
	static int N, M, cctvCnt, MIN = Integer.MAX_VALUE;
	static char[][] office;
	static int[][] cctvs;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new char[N][M];
		cctvs = new int[8][3];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			for (int m = 0; m < M; m++) {
				office[n][m] = st.nextToken().charAt(0);
				if (office[n][m] >= '1' && office[n][m] <= '5') {
					cctvs[cctvCnt][0] = n;
					cctvs[cctvCnt][1] = m;
					cctvs[cctvCnt++][2] = office[n][m] - '0';
				}
			}
		}

		setCCTV(0);

		System.out.println(MIN);

	}

	private static int countZero() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == '0') ++cnt;
			}
		}
		return cnt;
	}

	private static void copyArray(char[][] origin, char[][] result) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				result[i][j] = origin[i][j];
			}
		}
	}

	private static void setCCTV(int cnt) {
		if (cnt == cctvCnt) {
			MIN = Math.min(MIN, countZero());
			return;
		}

		char[][] tmpOffice = new char[N][M];

		for (int i = 0; i < 4; i++) {
			copyArray(office, tmpOffice);

			setOffice(cctvs[cnt], i);
			setCCTV(cnt + 1);

			copyArray(tmpOffice, office);
		}

	}

	private static void setOffice(int[] cctv, int d) {
		int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		for (int i = 0; i < 4; i++) {
			int nn = cctv[0];
			int nm = cctv[1];

			while ((nn+=deltas[(d+i)%4][0]) >= 0 && nn < N
					&& (nm+=deltas[(d+i)%4][1]) >= 0 && nm < M) {

				if (office[nn][nm] == '6') break;
				if (office[nn][nm] == '0') office[nn][nm] = '#';
			}

			if(cctv[2]==1) break;
			else if(cctv[2]==2) ++i;
			else if(cctv[2]==3 && i==1) break;
			else if(cctv[2]==4 && i==2) break;
		}
	}

}
