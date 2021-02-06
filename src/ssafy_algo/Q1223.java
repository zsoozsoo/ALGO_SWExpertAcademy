package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1223 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			
			int N = Integer.parseInt(br.readLine());
			String s= br.readLine();
			for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if( c!='*' && c!='+') {
				sb.append(c);
			}else {
				if(c=='*') stack.push(c);
				else {
					do {
						if(stack.isEmpty()) break;
						sb.append(stack.pop());
					}while(!stack.isEmpty() && stack.peek()!='+');
					stack.push(c);
					}
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			Stack<Integer> calc = new Stack<>();
			for (int j = 0; j < sb.length(); j++) {
				if(sb.charAt(j) != '+' && sb.charAt(j) !='*') calc.push(sb.charAt(j)-'0');
				else {
					int num1 = calc.pop();
					int num2 = calc.pop();
					char op = sb.charAt(j);
					if(op=='*') {
						calc.push(num1*num2);
					}else {
						calc.push(num1+num2);
					}
				}
			}
			System.out.println("#"+(t+1)+" "+calc.peek());
			
		}
	}
}
