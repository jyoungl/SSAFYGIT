import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3 {
    static int N, M, R;
    static int[][] arr;
    static int[][] divideIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int r = 0; r < R; r++) {
            switch (st.nextToken().charAt(0)) {
                case '1':
                    moveUD();
                    break;
                case '2':
                    moveLR();
                    break;
                case '3':
                    turn(true);
                    break;
                case '4':
                    turn(false);
                    break;
                case '5':
                    divide(true);
                    break;
                case '6':
                    divide(false);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    //상하 -> 줄단위로 바꿈
    private static void moveUD() {
        for (int i = 0; i < N / 2; i++) {
            int[] tmp = arr[i];
            arr[i] = arr[N - i - 1];
            arr[N - i - 1] = tmp;
        }
    }

    //좌우 -> 열단위로 바꾸는게 안됨. 한땀한땀...
    private static void moveLR() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = tmp;
            }
        }
    }

    //90도 오른쪽 회전, 90도 왼쪽 회전
    private static void turn(boolean isRight) {
        int tmp[][] = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(isRight) tmp[j][N-i-1] = arr[i][j];
                else tmp[M-j-1][i] = arr[i][j];
            }
        }
        arr = tmp;

        int num = M;
        M = N;
        N = num;
    }

    //4개나눠서 시계방향(R) -> 델타 (y,x) -> (0,x+M/2), (y+N/2,0),(0,x-M/2),(y-N/2,0) 오른쪽-아래-왼쪽-위 순서
    //4개 나눠서 반시계방향(L) -> 델타 (y,x) -> (y+N/2,0),(0,x+M/2),(y-N/2,0),(0,x-M/2) 아래-왼쪽-위-오른쪽 순서
    private static void divide(boolean isRight) {
        int[][] tmp = new int[N][M];
        int[][] deltas;
        int halfN = N/2;
        int halfM = M/2;

        if(isRight){
            divideIdx = new int[][]{{0, 0}, {0, halfM}, {halfN, halfM}, {halfN, 0}};
            deltas = new int[][]{{0, halfM}, {halfN, 0}, {0, -halfM}, {-halfN, 0}};

        }else {
            divideIdx = new int[][]{{0, 0}, {halfN, 0}, {halfN, halfM}, {0, halfM}};
            deltas = new int[][]{{halfN, 0}, {0, halfM}, {-halfN, 0}, {0, -halfM}};
        }

        for(int k=0;k<4;k++){
            for (int i = divideIdx[k][0]; i < divideIdx[k][0]+N/2; i++) {
                for (int j = divideIdx[k][1]; j < divideIdx[k][1]+M/2; j++) {
                    tmp[i+deltas[k][0]][j+deltas[k][1]] = arr[i][j];
                }
            }
        }

        arr = tmp;
    }

}
