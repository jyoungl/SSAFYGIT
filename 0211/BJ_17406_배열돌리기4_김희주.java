import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4 {
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//오른쪽, 아래, 왼쪽, 위
    static int N, M, K;
    static int[][] A;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] isSelected;
    static int[][] numbers;
    static int[][] turns;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //회전 정보 저장
        turns = new int[K][3];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(in.readLine());
            turns[k][0] = Integer.parseInt(st.nextToken())-1;
            turns[k][1] = Integer.parseInt(st.nextToken())-1;
            turns[k][2] = Integer.parseInt(st.nextToken());
        }

        //순열로 순서정하기-> 순서 다 정했으면 회전하기->최소값찾기->찐최소값찾아서 저장하기
        //회전-> s(반지름)만큼만 돌기
        //순열로 순서정하고 최소값 탐색
        isSelected = new boolean[K];
        numbers = new int[K][3];
        permutation(0);

        //최소값 출력
        System.out.println(MIN);
    }

    //배열 깊은복사
    private static int[][] copyArray(){
        int[][] arr = new int[N][M];
        for(int k=0;k<A.length;k++){
            System.arraycopy(A[k],0,arr[k],0,A[k].length);
        }
        return arr;
    }

    //순열
    private static void permutation(int cnt){
        if(cnt==K){
            //회전 다 하고 최소값비교

            int[][] arr = copyArray();
            for(int k=0;k<K;k++){
                for (int i = 0; ; i++) {
                    //s만큼 반복하면 끝
                    if (i >= numbers[k][2]) break;

                    //회전하기
                    arr = turnArr(arr, i, numbers[k][0], numbers[k][1], numbers[k][2]);
                }
            }

            MIN = Math.min(MIN,calcMin(arr));

            return;
        }

        for(int k=0;k<K;k++){
            if(isSelected[k]) continue;
            numbers[cnt] = turns[k];
            isSelected[k] = true;
            permutation(cnt+1);
            isSelected[k] = false;
        }
    }


    //최소값 계산
    private static int calcMin(int[][] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) sum += arr[i][j];
            if (min > sum) min = sum;
        }
        return min;
    }

    private static int[][] turnArr(int[][] arr, int i, int r, int c, int s) {
        int y = r - s + i;
        int x = c - s + i;
        int d = 0;

        int num = arr[y][x];

        while (true) {
            if (d == 4) break;

            int tmpy = y + deltas[d][0];
            int tmpx = x + deltas[d][1];

            if (tmpy < r - s + i|| tmpy > r + s - i|| tmpx < c - s + i|| tmpx > c + s - i) {
                ++d;
                continue;
            }

            int n = num;
            num = arr[tmpy][tmpx];
            arr[tmpy][tmpx] = n;

            y = tmpy;
            x = tmpx;

        }

        return arr;

    }

}
