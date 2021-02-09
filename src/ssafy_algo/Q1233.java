package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1233 {
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int result = 0;
							
			for (int t2 = 0; t2 < T; t2++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				List<Character> list = new ArrayList<>();
				
				while(st.hasMoreTokens()) {
					list.add(st.nextToken().charAt(0));
				}
				
				if(list.size()>2) {
					if(list.get(1) =='-' ||  list.get(1) =='*' || list.get(1) =='+' || list.get(1) =='/') result = 1;
					else result = 0;
				}else {
					if(list.get(1) =='-' ||  list.get(1) =='*' || list.get(1) =='+' || list.get(1) =='/') result = 0;
				}
				
			}
			
			System.out.println("#"+(t+1)+" "+result);
		}
	}
}
