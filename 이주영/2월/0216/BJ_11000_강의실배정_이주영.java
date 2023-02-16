package feb16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11000_강의실배정_이주영 {
    public static class Room {
        int s;
        int t;

        public Room(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    static PriorityQueue<Integer> list = new PriorityQueue<>();
    static ArrayList<Room> que = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            que.add(new Room(x, y));
        }

        que.sort(new Comparator<Room>() {
            @Override
            public int compare(Room r1, Room r2) {
                if(r1.s == r2.s)
                    return r1.s - r2.s;
                else
                    return r1.s - r2.s;
            }
        });

        System.out.println(classCount());
    }

    public static int classCount(){
        list.add(que.get(0).t);
        int size = que.size();

        for (int i = 1; i < size; i++) {
            if(que.get(i).s >= list.peek())
                list.poll();
            
            list.add(que.get(i).t);
        }
        return list.size();
    }
}
