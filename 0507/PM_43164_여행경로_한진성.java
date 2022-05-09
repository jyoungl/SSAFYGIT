import java.util.Arrays;

public class PM_43164_여행경로 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] answer = sol.solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
			{ "ATL", "SFO" } });
		System.out.println(Arrays.toString(answer));
		
	}

}

class Solution {
	String[] strings;
	String check = "";
	String[] answer;
	public String[] solution(String[][] tickets) {
		strings = new String[tickets.length + 1];
        for(int i=0;i<tickets.length;i++){
            Arrays.toString(tickets[i]);
        }
		dfs(tickets, 0, strings);
		return answer;
	}

	public void dfs(String[][] tickets, int cnt, String ans[]) {
		ans[0] = "ICN";
		
        if (cnt == tickets.length) {
            
		String str ="";
		for(int i=0;i<ans.length;i++) {
			str = str + ans[i];
		}
            
        System.out.println(Arrays.toString(answer));
		if(check == "") {
			check = str;
			answer = Arrays.copyOf(strings, tickets.length+1);
		}else {
			if(check.compareTo(str) > 0) {
				check = str;
				answer = Arrays.copyOf(strings, tickets.length+1);
			}
        }
			return;
		}
        
		for (int i = 0; i < tickets.length; i++) {
			if (ans[cnt].equals(tickets[i][0]) && tickets[i][1] != "") {
				ans[cnt + 1] = tickets[i][1];
				String temp = tickets[i][1];
				tickets[i][1] = "";
				dfs(tickets, cnt + 1, ans);
				tickets[i][1] = temp;
			}

		}
	}

}