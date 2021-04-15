package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1238_1 {
	
	public static class res{
		int num, depth;

		public res(int num, int depth) {
			super();
			this.num = num;
			this.depth = depth;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken()); //데이터의 길이
			int start = Integer.parseInt(st.nextToken()); //시작점
			
			int[][] callMap = new int[101][101];
			boolean[] vs = new boolean[101];
			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<res> resQueue = new LinkedList<res>();
			st = new StringTokenizer(br.readLine()); //데이터 입력받기 (from -> to)
			for (int i = 0; i < size/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				callMap[from][to] = 1;
			}
			
			queue.add(start);
			int depth = 1; //깊이 알아내줄 변수
			while(!queue.isEmpty()) {
				
				for (int i = queue.size(); i >0; i--) {
					int curr = queue.poll();
					vs[curr] = true;
					
					boolean flg = false; //100까지 돌렸는데 없는애들 찾아야되니까 그거 구별해줄 변수
					for (int j = 1; j <= 100; j++) {
						if(callMap[curr][j] == 1 && !vs[j]) { //전화가능한애들은 queue에 넣어주기
							queue.add(j); 
							vs[j] = true;
							flg = true;
						}else if(j==100 && !flg) {
							resQueue.add(new res(curr,depth));//더이상못가는애들 resQueue에 넣어주기
						}
					}	
				}
				depth++; //깊
			}
			
			int max = 0;
			for (res res : resQueue) { //더이상 갈 수 없는 애들 모여둔 것 중 최대값 찾기
				if(res.depth==depth-1) { //트리의 높이와 같은애들 중에서
					if(max<res.num) max = res.num;
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
}
