package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] sArr = null;
		int[] resultArr = new int[T];
		int count;
		
		for (int i = 0; i < T; i++) {
			count = 0;
			String s = br.readLine();
			sArr = s.split("");
			if(sArr[0].equals("1")) count=1;
			else count = 0;
			
			for (int j = 0; j < s.length(); j++) {
				if(!sArr[0].equals(sArr[j])) count++;
				sArr[0] = sArr[j];
			}
			
			resultArr[i] = count;
		}
		
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println("#"+(i+1)+" "+resultArr[i]);
		}
		
	}
}
