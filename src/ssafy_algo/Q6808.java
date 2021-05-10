package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q6808 {
	
	static int[] kyu,in;
	static int win,lose;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			win = 0; lose = 0;
			kyu = new int[9];
			in = new int[9];
			boolean[] check = new boolean[19];
			
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				kyu[j] = num;
				check[num] = true;
			}
			
			int idx = 0;
			for (int j = 1; j < check.length; j++) {
				if(!check[j]) in[idx++] = j;
			}
			
			makePermu(new boolean[9],0,0,0);
			System.out.println("#"+i+" "+win+" "+lose);
		}
	}

	private static void makePermu(boolean[] vs,int curr, int kyuSum, int inSum) {
		if(curr==9) {
			if(kyuSum>inSum) win++;
			else lose++;
		}else {
			for (int i = 0; i < 9; i++) {
				if(!vs[i]) {
					vs[i] = true;
					if(kyu[curr]>in[i]) makePermu(vs, curr+1, kyuSum+kyu[curr]+in[i], inSum);
					else makePermu(vs, curr+1, kyuSum, inSum+kyu[curr]+in[i]);
					vs[i] = false;
				}
			}
		}
	}
}
