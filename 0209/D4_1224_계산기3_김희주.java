import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1224_계산기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(in.readLine());
            String line = in.readLine();

            //postfix로 바꾸기
            StringBuilder postfix = new StringBuilder();
            Stack<Character> operator = new Stack<>();

            for (int i = 0; i < len; i++) {
                char ch = line.charAt(i);
                if (ch == '(') {
                    operator.push(ch);
                    continue;
                }
                else if(ch>='0'){
                    //입력될 char부호는 '0'~'9'보다 작음
                    postfix.append(ch);
                    continue;
                }

                while (!operator.empty() && operator.peek() != '(') {
                    if(ch==')') postfix.append(operator.pop());
                    else if (operator.peek() <= ch) postfix.append(operator.pop()); //'+' > '*' > ')' : true
                    else break;
                }

                if(ch=='+' || ch=='*') operator.push(ch);
                else if(ch==')') operator.pop();

            }

            //stack에 넣어가면서 계산하기
            Stack<Integer> calculator = new Stack<>();
            for (int i = 0; i < postfix.length(); i++) {
                char ch = postfix.charAt(i);
                switch (ch) {
                    case '+':
                        calculator.push(calculator.pop() + calculator.pop());
                        break;
                    case '*':
                        calculator.push(calculator.pop() * calculator.pop());
                        break;
                    default:
                        calculator.push(ch - '0');
                        break;
                }
            }


            //출력하기
            System.out.println("#" + tc + " " + calculator.pop());

        }
    }
}
