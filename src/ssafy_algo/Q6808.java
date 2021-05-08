package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q6808 {
	
	static int[] kyu;
	static List<Integer> in;
	static int win,lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			win = 0; lose = 0;
			kyu = new int[9];
			in = new ArrayList<>();
			boolean[] check = new boolean[19];
			
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				kyu[j] = num;
				check[num] = true;
			}
			
			for (int j = 1; j < check.length; j++) {
				if(!check[j]) in.add(j);
			}
			
			makePermu(new boolean[9],new int[9],0);
			System.out.println("#"+i+" "+win+" "+lose);
		}
	}

	private static void makePermu(boolean[] vs,int[] temp,int curr) {
		if(curr==9) {
			cal(temp);
		}else {
			for (int i = 0; i < in.size(); i++) {
				if(!vs[i]) {
					vs[i] = true;
					temp[curr] = in.get(i);
					makePermu(vs,temp,curr+1);
					vs[i] = false;
				}
			}
		}
	}

	private static void cal(int[] temp) {
		int kyuScore = 0, inScore = 0;
		for (int i = 0; i < 9; i++) {
			if(kyu[i]>temp[i]) kyuScore += (kyu[i]+temp[i]);
			else inScore += (kyu[i]+temp[i]);
		}
		
		if(kyuScore>inScore) win++;
		else lose++;
	}
}
