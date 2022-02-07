import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_카드2 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            queue.add(i);
        }

        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());

    }
}
