package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5215 {
	
	static int N ;
	static int L ;
	static int[] tArr = new int[N];
	static int[] kArr = new int[N];
	static int max=0;
	
	public static void kal(int cnt,boolean[] isSelected) {
		int tSum = 0, kSum = 0;
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
					if(isSelected[i]) {
						tSum += tArr[i];
						kSum += kArr[i];
				}
			}
			
			if(kSum < L && tSum>max) {
				max = tSum;
			}
			return;
		}
	
		isSelected[cnt] = true;
		kal(cnt+1,isSelected);
		isSelected[cnt] = false;
		kal(cnt+1,isSelected);
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t <T; t++) {
			max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 L = Integer.parseInt(st.nextToken());
			 
			 tArr = new int[N];
			 kArr = new int[N];
			 
			for (int i = 0; i <N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				tArr[i] = Integer.parseInt(st2.nextToken());
				kArr[i] = Integer.parseInt(st2.nextToken());
			}
			
			kal(0,new boolean[N]);
			System.out.println("#"+(t+1)+" "+max);
			
		}
				
	}
}
