import java.util.*;
 
class Solution {
    public String[] solution(String[] record) {
        
        //아이디 - 닉네임 map
        Map<String,String> map = new HashMap<>();
        StringTokenizer st;
        for(String rec:record){
            st = new StringTokenizer(rec);
            String command = st.nextToken();
            if(!command.equals("Leave")){
                map.put(st.nextToken(), st.nextToken());
            }
        }
        
        
        //결과
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        
        ArrayList<String> list = new ArrayList<>();
        for(String rec:record){
            st = new StringTokenizer(rec);
            String command = st.nextToken();
            if(command.equals("Enter")){
                list.add(new StringBuilder().append(map.get(st.nextToken())).append(enter).toString());
            }else if(command.equals("Leave")){
                list.add(new StringBuilder().append(map.get(st.nextToken())).append(leave).toString());
            }
        }
        
        return list.toArray(new String[list.size()]);
    }
}
