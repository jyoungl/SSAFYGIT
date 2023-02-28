package feb28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1713_후보추천하기_이주영 {
    public static class Student implements Comparable<Student>{
        int num;
        int count;
        int order;
        public Student(int num, int count, int order) {
            this.num = num;
            this.count = count;
            this.order = order;
        }

        @Override
        public int compareTo(Student o) {
            if (o.count == this.count)
                return this.order - o.order;

            return this.count - o.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // PriorityQueue<Student> que = new PriorityQueue<>();
        ArrayList<Student> list = new ArrayList<>();
        int[] visited = new int[101];
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (visited[x] == 0) { //처음 들어감
                if (list.size() >= N) {
                    Collections.sort(list);
                    int y = list.get(0).num;
                    visited[y] = 0;
                    list.remove(0);
                }
                list.add(new Student(x, 1, i));
                visited[x] = 1;
            } else { //이미 존재
                visited[x] += 1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).num == x) {
                        list.get(j).count = visited[x];
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i).num);
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ans.size();i++)
            sb.append(ans.get(i) + " ");
        System.out.println(sb);
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < 101; i++) {
        //     if (visited[i] != 0)
        //         sb.append(i + " ");
        // }
        // System.out.println(sb);
    }

}
