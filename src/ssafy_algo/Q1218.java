package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1218 {

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack <Character> stack = new Stack<>();
		boolean flg = false;
		
		for (int t = 0; t < 10; t++) {
			
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			char[] arr = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i);
			}
			
			if(flg) break;
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]=='(' || arr[i]=='{' || arr[i]=='[' || arr[i]=='{') stack.push(s.charAt(i));
				else { 
					if(arr[i]==')')
				}
					
					
					
					
					if(arr[i]==')') {
					if(stack.peek()=='(')stack.pop();
					else flg = true;
				}
				if(arr[i]=='[') stack.push(s.charAt(i));
				else if(arr[i]==']') {
					if(stack.peek()=='[')stack.pop();
					else flg = true;
				}
				if(arr[i]=='{') stack.push(s.charAt(i));
				else if(arr[i]=='}') {
					if(stack.peek()=='{')stack.pop();
					else flg = true;
				}
				if(arr[i]=='<') stack.push(s.charAt(i));
				else if(arr[i]=='>') {
					if(stack.peek()=='<')stack.pop();
					else flg = true;
				}
			}
			
			if(stack.isEmpty()) System.out.println("#"+(t+1)+" "+1);
			else System.out.println("#"+(t+1)+" "+0);
		}
		
	}

}
