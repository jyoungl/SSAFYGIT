import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class D4_1223_계산기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(in.readLine());
            String line = in.readLine();

            //postfix로 바꾸기
            StringBuilder postfix = new StringBuilder();
            Deque<Character> operator = new ArrayDeque<>();

            for (int i = 0; i <= len; i++) {
                if(i==len || line.charAt(i)=='+'){
                    while(!operator.isEmpty()){
                        postfix.append(operator.pollFirst());
                    }
                    if(i==len) break;
                }

                char ch = line.charAt(i);
                if(ch=='*') operator.offerFirst(ch);
                else if(ch=='+') operator.offerLast(ch);
                else postfix.append(ch);
            }

            //숫자 스택에 넣어가면서 계산하기
            Stack<Integer> calculator = new Stack<>();
            for(int i=0;i<postfix.length();i++){
                char ch = postfix.charAt(i);
                switch(ch){
                    case '+':
                        calculator.push(calculator.pop()+calculator.pop());
                        break;
                    case '*':
                        calculator.push(calculator.pop()*calculator.pop());
                        break;
                    default:
                        calculator.push(ch-'0');
                        break;
                }
            }

            System.out.println(new StringBuilder("#").append(tc).append(" ").append(calculator.pop()));

        }
    }
}
