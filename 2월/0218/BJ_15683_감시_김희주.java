import java.io.*;
import java.util.*;

public class BOJ_15683_감시 {
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
            //남은 숫자 세기
            MIN = Math.min(MIN, countZero());
            return;
        }

        //복사해서 잠깐 저장해놓을 배열
        char[][] tmpOffice = new char[N][M];

        //cctv 타입에 따라서 분리
        //1: 한 방향
        //2: 180도 양방향
        //3: 90도 양방향
        //4: 세 방향
        //5: 네 방향 전부

        //현재 상태를 tmpOffice에 저장해놓고 -> cctv가 보는 방향에 따라서 체크해준 뒤 -> 다음 cctv를 불러옴
        //다 끝났으면 현재상태로 되돌리기

        switch (cctvs[cnt][2]) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    copyArray(office, tmpOffice);

                    setOffice(cctvs[cnt][0], cctvs[cnt][1], i);

                    setCCTV(cnt + 1);
                    copyArray(tmpOffice, office);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    copyArray(office, tmpOffice);

                    setOffice(cctvs[cnt][0], cctvs[cnt][1], i);
                    setOffice(cctvs[cnt][0], cctvs[cnt][1], i + 2);

                    setCCTV(cnt + 1);
                    copyArray(tmpOffice, office);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    copyArray(office, tmpOffice);

                    //위 오른쪽, 오른쪽 아래, 아래 왼쪽, 왼쪽 위
                    setOffice(cctvs[cnt][0], cctvs[cnt][1], i);
                    setOffice(cctvs[cnt][0], cctvs[cnt][1], (i + 1) % 4);

                    setCCTV(cnt + 1);
                    copyArray(tmpOffice, office);
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    copyArray(office, tmpOffice);

                    setOffice(cctvs[cnt][0], cctvs[cnt][1], i);
                    setOffice(cctvs[cnt][0], cctvs[cnt][1], (i + 1) % 4);
                    setOffice(cctvs[cnt][0], cctvs[cnt][1], (i + 2) % 4);

                    setCCTV(cnt + 1);

                    copyArray(tmpOffice, office);
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++) {
                    setOffice(cctvs[cnt][0], cctvs[cnt][1], i);
                }
                setCCTV(cnt + 1);
                break;
        }
    }

    private static void setOffice(int n, int m, int way) {
        switch (way) {
            case 0://위
                for (int i = n - 1; i >= 0; i--) {
                    if (office[i][m] == '6') break;
                    if (office[i][m] == '0') office[i][m] = '#';
                }
                break;
            case 1://오른쪽
                for (int i = m + 1; i < M; i++) {
                    if (office[n][i] == '6') break;
                    if (office[n][i] == '0') office[n][i] = '#';
                }
                break;
            case 2://아래
                for (int i = n + 1; i < N; i++) {
                    if (office[i][m] == '6') break;
                    if (office[i][m] == '0') office[i][m] = '#';
                }
                break;
            case 3://왼쪽
                for (int i = m - 1; i >= 0; i--) {
                    if (office[n][i] == '6') break;
                    if (office[n][i] == '0') office[n][i] = '#';
                }
                break;
        }

    }
}
