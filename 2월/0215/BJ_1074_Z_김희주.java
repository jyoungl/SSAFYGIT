import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
    static int count,N,r,c;
    static int[][] deltas = {{0,0},{0,1},{1,-1},{0,1}};//왼쪽-대각선-왼쪽

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        findRC(0,0,N);

        System.out.println(count);
    }

    private static void findRC(int y, int x, int n){
        if(n==1){
//            for(int i=0;i<4;i++){
//                y+=deltas[i][0];
//                x+=deltas[i][1];
//                if(y==r && x==c) break;
//                ++count;
//            }
            return;
        }

        int halfN = 1<<(n-1);
        int halfArea = halfN*halfN;//Math.pow(halfN,2);

        //둘다 절반보다 크면 세면적 더하고 호출
        //r만 절반보다 크면 두 면적 더하고 호출
        //c만 절반보다 크면 한 면적 더하고 호출
        //다 아니면 나머지 하나 호출

        if(r>=y+halfN && c>=x+halfN) {
            count+=halfArea*3;
            findRC(y+halfN,x+halfN,n-1);
        }
        else if(r>=y+halfN){
            count+=halfArea*2;
            findRC(y+halfN,x,n-1);
        }
        else if(c>=x+halfN){
            count+=halfArea;
            findRC(y,x+halfN,n-1);
        }else{
            findRC(y,x,n-1);
        }

    }
}
