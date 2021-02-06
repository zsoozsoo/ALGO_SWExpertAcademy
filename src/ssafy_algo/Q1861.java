package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1861 {
	
	static int result = 0;
	static int cnt = 0;
	
	
	public static void find(int row, int col, int[][] arr) {
		
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int num = arr[row][col];
		cnt++;
		
		for (int i = 0; i < dir.length; i++) {
			int x = row + dir[i][0]; 
			int y = col + dir[i][1]; 
			if(x>=0 && x<arr.length && y>=0 && y<arr.length && (num+1) == arr[x][y]) {
				find(x,y,arr);
				result = arr[row][col];
			}else if(i==3) {
				return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트케이스
		
		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			Map<Integer,Integer> map = new HashMap<>();
			
			for (int i = 0; i <N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
						
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					cnt=0;
					find(i,j,arr);
					if(map.containsKey(cnt)) {
						if(map.get(cnt)>result) map.put(cnt, result);
					}else {
						map.put(cnt,result);
					}
				}
			}
			
			List<Integer> list = new ArrayList<>(map.keySet());
			
			class Descending implements Comparator<Integer>{
				
				public int compare(Integer a, Integer b)
				{
					return b.compareTo(a);
				}
			}
			
			Collections.sort(list, new Descending());
			 for(int v :list) {
				 System.out.print("#"+(t+1)+" "+map.get(v)+" "+v+"\n");break;
			 }
					

			
		}
	}
}
