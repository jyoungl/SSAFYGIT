import java.io.*;

public class BOJ_3085_사탕게임 {
    static int N,result;
    static char[][] board;
    static int[][] deltas = {{1,0},{0,1}};//아래쪽-오른쪽
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        board = new char[N][N];

        for(int i=0;i<N;i++){
            String line = in.readLine();
            for(int j=0;j<N;j++){
                board[i][j] = line.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                result = Math.max(result,swapCandy(i,j));
            }
        }

        System.out.println(result);
    }

    private static int swapCandy(int r, int c) {
        int max = 0;

        for(int d=0;d<2;d++){
            int nr = r+deltas[d][0];
            int nc = c+deltas[d][1];
            if(nr>=0 && nr<N && nc>=0 && nc<N && board[r][c]!=board[nr][nc]){
                char tmp = board[r][c];
                board[r][c] = board[nr][nc];
                board[nr][nc] = tmp;

                max = Math.max(max,countCandy());

                board[nr][nc] = board[r][c];
                board[r][c] = tmp;
            }
        }
        return max;
    }

    private static int countCandy(){
        int tmpMax = 1;
        for(int i=0;i<N;i++){
            char nowH = board[i][0];
            char nowV = board[0][i];
            int cntH = 1;
            int cntV = 1;

            for(int j=1;j<N;j++){
                if(nowH!=board[i][j]){
                    tmpMax = Math.max(tmpMax,cntH);
                    nowH = board[i][j];
                    cntH = 1;
                }
                else ++cntH;

                if(nowV != board[j][i]){
                    tmpMax = Math.max(tmpMax,cntV);
                    nowV = board[j][i];
                    cntV = 1;
                }
                else ++cntV;

            }
            tmpMax = Math.max(tmpMax,cntH>cntV?cntH:cntV);
        }

        return tmpMax;
    }
}
