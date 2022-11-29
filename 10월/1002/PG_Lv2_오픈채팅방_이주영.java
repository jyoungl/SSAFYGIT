import java.io.*;
import java.util.*;


class Solution {
     public static class Log {
        String pid; //아이디
        String rec; //기록

        public Log(String pid, String rec){
            this.pid = pid;
            this.rec = rec;
        }
    }    

    public static String[] solution(String[] record) {
        HashMap<String, String> person = new HashMap<>();
        Queue<Log> que = new LinkedList<>();

        for(int i=0;i<record.length;i++){
            String[] split = record[i].split(" ");
            String status = split[0]; // 상태
            String id = split[1]; //고유아이디

            if(status.equals("Enter")){
                String name = split[2]; //닉네임
                person.put(id, name);
                que.add(new Log(id, "님이 들어왔습니다."));
            }
            else if(status.equals("Leave")){
                que.add(new Log(id, "님이 나갔습니다."));
            }
            else if(status.equals("Change")){
                String name = split[2]; //닉네임
                person.replace(id, name);
            }
        }

        String[] answer = new String[que.size()];
        int i = 0;
        while(!que.isEmpty()){
            Log l = que.poll();
            String ans = person.get(l.pid);
            ans += l.rec;
            answer[i++] = ans;
        }

        return answer;
    }
}
