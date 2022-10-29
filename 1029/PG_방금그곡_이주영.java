import java.io.*;
import java.util.*;

class Solution {
    //해시맵 대신 사용할 변수 2개 선언, 해시맵 사용시 런타임에러 남
    static int time = 0;
    static String answer = null;
    static String[] shaps = {"A#","C#","D#","F#","G#"};
    static String[] reps = {"Q","W","R","T","Y"};

    public String solution(String m, String[] musicinfos) {
        for(int i=0;i<shaps.length;i++){
            if(m.contains(shaps[i]))
                m = m.replaceAll(shaps[i], reps[i]);
        }

        int mlength = m.length();
        //HashMap<String, Integer> music = new HashMap<>(); //조건에 일치하는 음악 제목, 재생 시간 저장할 해시맵

        for(String s : musicinfos){ // 반복문 돌리면서 조건에 일치하는 음악 찾음
            String[] info = s.split(","); //긴 문자열을 , 기준으로 나눔

            String[] stime = info[0].split(":");
            String[] etime = info[1].split(":");
            String title = info[2];
            String sheet = info[3];

            int hour = Integer.parseInt(etime[0])*60 - Integer.parseInt(stime[0])*60;
            int minute = Integer.parseInt(etime[1]) - Integer.parseInt(stime[1]);
            int mlen = hour + minute; // 재생시간

            for(int i=0;i<shaps.length;i++){
                if(sheet.contains(shaps[i]))
                    sheet = sheet.replaceAll(shaps[i], reps[i]);
            }

            int infolen = sheet.length();
            String resh = "";
            //악보정보가 길이보다 짧으면                            
            for(int i=0;i<mlen;i++){
                resh += sheet.charAt(i%infolen);
            }

            if(resh.contains(m)){
                if(time < mlen){
                    answer = title;
                    time = mlen;
                }

            }
        }

        if(answer == null) {
            answer = "(None)";
        }
        return answer;
    }
}
