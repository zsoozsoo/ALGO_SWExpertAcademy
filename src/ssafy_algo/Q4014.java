package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4014 {
	static int N, X; //총 가능한 갯수 ,한변의 크기, 경사로의 길이 
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+process());
		}
	}
	
	private static int process() {
		int count = 0;
		for (int i = 0; i < map.length; i++) { //방문처리 같은거 상관없거 그냥 0행,0열로 각각 보면 되니까 for문 하나로~
			if(makeRoadByRow(i)) count++;
			if(makeRoadByCol(i)) count++;
		}
		return count;
	}

	private static boolean makeRoadByRow(int i) {
		int beforeH = map[i][0], size = 0; //이전 높이, size = 동일높이가 지속되는 수
		int j = 0; //탐색위치
		while(j<N) {
			if(beforeH == map[i][j]) {
				++size; ++j;
			}else if(beforeH+1 == map[i][j]) { //오르막 경사로 설치 가능한지 판단
				if(size<X) return false; //경사로 설치 불가
				beforeH++; //하나 증가하고했으니까
				size = 1; //다시 처음부터 세줌
				++j;
			}else if(beforeH-1 == map[i][j]) {
				int count = 0; //내리막길 다음부터 동일높이 체크 위한 변수
				for (int k = j; k < N; k++) { 
					if(map[i][k] != beforeH-1) break; // 경사 뒤에 높이 차이가 하나인것이 아니면 경사로 설치 불가
					if(++count ==X) break; //설치 가능(밑변의 높이랑 같음)
				}
				if(count <X) return false; //경사로 설치 불가
				beforeH --;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true ; //끝까지 온건 설치 가능하다는 의미
	}
	
	private static boolean makeRoadByCol(int i) {
		int beforeH = map[0][i], size = 0; //이전 높이, size = 동일높이가 지속되는 수
		int j = 0;
		while(j<N) {
			if(beforeH == map[j][i]) {
				++size; ++j;
			}else if(beforeH+1 == map[j][i]) { //오르막 경사로 설치 가능한지 판단
				if(size<X) return false; //경사로 설치 불가
				beforeH++; //하나 증가하고했으니까
				size = 1; //다시 처음부터 세줌
				++j;
			}else if(beforeH-1 == map[j][i]) {
				int count = 0; //내리막길 다음부터 동일높이 체크 위한 변수
				for (int k =j; k < N; k++) { 
					if(map[k][i] != beforeH-1) break; // 경사 뒤에 높이 차이가 하나인것이 아니면 경사로 설치 불가
					if(++count ==X) break; //설치 가능(밑변의 높이랑 같음)
				}
				if(count <X) return false; //경사로 설치 불가
				beforeH --;
				size = 0;
				j += X;
			}else {
				return false;
			}
		}
		return true ; //끝까지 온건 설치 가능하다는 의미
	}
	
	
}
