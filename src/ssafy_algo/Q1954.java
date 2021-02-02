package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
		
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int [size][size];
			int row=0, col=-1, dir = 1, num=1; //행,열,방향,넣어줄 숫자
			
			while(true) {
				
				for (int j = 0; j < size; j++) {
					col += dir; //열 1씩 증가
					arr[row][col] = num++;
				}
				
				size -= 1;
				if(size==0) break;
				
				for (int j = 0; j < size; j++) {
					row += dir; //행 1씩 증가
					arr[row][col] = num++;
				}
				
				dir *= -1; //방향 바꿔주기
			}
			
			System.out.println("#"+(i+1));
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					System.out.print(arr[j][j2]+" ");
				}
				System.out.println();
			}
			
			
		}
		
		
	}
}
