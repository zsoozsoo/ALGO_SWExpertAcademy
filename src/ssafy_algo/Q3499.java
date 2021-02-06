package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3499 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			Queue<String> queue = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			for (int i = 0; i < N/2; i++) {
				queue.offer(arr[i]);
				if(N%2==0)queue.offer(arr[i+(N/2)]);
				else if(N%2==1)queue.offer(arr[i+((N/2)+1)]);
				
				if(N%2==1 && i==(arr.length/2)-1) queue.offer(arr[i+1]);
			}
			
			System.out.print("#"+(t+1)+" ");
			for (String string : queue) {
				System.out.print(string+" ");
			}
			System.out.println();
		}
	}
}
