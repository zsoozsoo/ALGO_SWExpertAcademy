package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9299 {
	
	static int N ;
	static int M;
	static int max = 0;
	static int[] cookie = new int[N];
	
	public static void weight(int toSelect, int[] selected, int startIdx) {
		int sum = 0;
		
		if(toSelect == 2) {
			for (int i = 0; i < selected.length; i++) {
				sum += selected[i];
			}
			
			if(sum <= M && max <sum) max = sum;
			
			return;
		}
		
		for (int i = startIdx; i < cookie.length; i++) {
			selected[toSelect]  = cookie[i];
			weight(toSelect+1,selected,i+1);
		}
	}
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			cookie = new int[N];
			for (int i = 0; i < N; i++) {
				cookie[i] = Integer.parseInt(st2.nextToken());
			}
			
			
			weight(0,new int[2],0);
			System.out.print("#"+(t+1)+" ");
			if(max == 0) System.out.println(-1);
			else System.out.println(max);
			
		}
	}
}
