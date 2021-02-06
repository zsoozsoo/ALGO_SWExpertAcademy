package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int cnt =1;
			while(true) {
				int num = queue.poll();
				num = num-cnt;
				
				if(num<=0) {
					num = 0;
					queue.offer(num);
					break;
				}
				queue.offer(num);
				
				if(cnt==5) cnt=0;
				cnt++;
			}
			
			System.out.print("#"+T+" ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
			
		}
	}
}
