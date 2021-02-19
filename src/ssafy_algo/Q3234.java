package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3234 {
	
	static int N, result;
	static int[] arr, perL,perR,left, right;
	static boolean[] isSelected;
	static boolean[] isSelected2;
	
	public static void permu(int[] left, int[] right, int toSelect) {
		
		if(toSelect==N) {
			int sumL = 0, sumR = 0;
			for (int i = 0; i < N; i++) {
				sumL += perL[i];
				sumR += perR[i];
				if(sumL<sumR) return;
			}
			result ++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!isSelected2[i]) {
				isSelected2[i] = true;
				perL[toSelect] = left[i];
				perR[toSelect] = right[i];
				permu(left,right, toSelect+1);
				isSelected2[i] = false;
			}
		}
	}
	
	public static void powerSet(int cnt) {
		
		if(cnt == N) {
			int sumL = 0, sumR = 0;
			left = new int[N];
			right = new int[N];
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					left[i] = arr[i];
					sumL += arr[i];
				} else {
					right[i] = arr[i];
					sumR += arr[i];
				}
			}
			if(sumL<sumR) return;
			else{
			perL = new int[N];
			perR = new int[N];
			permu(left,right,0);
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		powerSet(cnt+1);
		isSelected[cnt] = false;
		powerSet(cnt+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t <T; t++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			isSelected = new boolean[N]; isSelected2 = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(0);
			System.out.println("#"+(t+1)+" "+result);
			result = 0;
		}
	}
}
