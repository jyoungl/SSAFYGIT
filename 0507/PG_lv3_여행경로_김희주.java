import java.io.*;
import java.util.*;

class Solution {
    ArrayList<String> result;
    Map<String, ArrayList<Ticket>> map;
    int len;
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        result = new ArrayList<>();
        Arrays.sort(tickets, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        map = new HashMap<>();
        for (int i = 0, j = 0; i < tickets.length;i=j ) {
            while (j < tickets.length && tickets[i][0].equals(tickets[j][0])) j++;
            ArrayList<Ticket> list = new ArrayList<>();
            for (int idx = 0; idx < j - i; idx++) {
                list.add(new Ticket(false,tickets[i + idx][1]));
            }
            map.put(tickets[i][0], list);
        }
        result.add("ICN");
        dfs(0,"ICN");
        return result.toArray(new String[]{});
    }
    private boolean dfs(int count, String start) {
        if(count==len) return true;

        if(map.get(start)==null) return false;
        for(Ticket ticket:map.get(start)){
            if(ticket.isUsed) continue;
            ticket.isUsed = true;
            int size = result.size();
            result.add(ticket.end);
            if(dfs(count+1, ticket.end)) return true;
            ticket.isUsed = false;
            result.remove(size);
        }
        return false;
    }
    private class Ticket{
        boolean isUsed;
        String end;
        Ticket(boolean isUsed, String end){
            this.isUsed = isUsed;
            this.end = end;
        }
    }
}
