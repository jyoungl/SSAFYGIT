import java.io.*;

public class BOJ_1992_쿼드트리 {
    static StringBuilder sb = new StringBuilder();
    static int[][] video;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        zipVideo(N,0,0);
        System.out.println(sb);

    }

    public static void zipVideo(int n,int i,int j){
        if(n==1 || checkVideo(n,i,j)) {
            sb.append(video[i][j]);
            return;
        }

        sb.append("(");

        int halfN = n>>1;
        zipVideo(halfN,i,j);
        zipVideo(halfN,i,j+halfN);
        zipVideo(halfN,i+halfN,j);
        zipVideo(halfN,i+halfN,j+halfN);

        sb.append(")");

    }

    public static boolean checkVideo(int n,int i,int j){
        int check = video[i][j];
        for(int y=i;y<i+n;y++){
            for(int x=j;x<j+n;x++){
                if(check!=video[y][x]) return false;
            }
        }
        return true;
    }


}
