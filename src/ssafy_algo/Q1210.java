package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1210 {
	
	static int row=0 ,col = 0;
	static int[][] arr = new int[100][100];
	static int dir =1;
	
	public static void ladder(int row, int col,int dir) {
		
		switch(dir) {
		case 1:
			if(col-1>=0 && arr[row][col-1]==1) {col-=1;dir=2;}
			else if(col+1<100&& arr[row][col+1]==1) {col+=1; dir=3;} 
			else {row--; dir=1;}
		case 2:
			if(col-1>=0 && arr[row][col-1]==1 ) {col-=1;dir=2;}
			else if(col+1<100&& arr[row][col+1]==1) {col+=1; dir=3;}
			else {row--; dir=1;}
		case 3:
			if(col-1>=0 && arr[row][col-1]==1 ) {col-=1;dir=2;}
			else if(col+1<100&& arr[row][col+1]==1) {col+=1; dir=3;}
			else {row--; dir=1;}
	
		}
		
		System.out.println(row+" "+col);
		ladder(row,col,dir);
		if(row==0) return;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 1; tc++) {
			int t = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n==2) { row = i; col = j; }
					arr[i][j] = n;
				}
			}
			ladder(row,col,dir);
			System.out.println("#"+t+" "+col);
		}
	}
}
