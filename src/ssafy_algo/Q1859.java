package ssafy_algo;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Q1859 { //뒤에서 부터 보는게 핵심!! (얘는 모든 날짜의 매매가를 다 알고 있으니까~) 
//					 //뒤에서부터 보고 나보다 작으면 수익, 나보다 크면 매매가로 바꾸고 그 수 부터 다시 돌아가면서 보기
//
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		
//		for (int t = 0; t < T; t++) {
//			int sum = 0;
//			int N = Integer.parseInt(br.readLine());
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int[] price = new int[N];
//			
//			for (int i = 0; i < N; i++) {
//				price[i] = Integer.parseInt(st.nextToken());
//			}
//			int idx = 0;
//			for (int i = N-1; i >=0; i--) {
//				if(idx>price[i]) sum += (idx-price[i]);
//				else idx = price[i];
//			}
//			
//			System.out.println("#"+(t+1)+" "+sum);
//		}
//	}
//}



import java.util.Scanner;

public class Q1859 {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int TC = sc.nextInt();
long res = 0;
int N;
int[] map;
for(int t = 1; t <= TC ; t++) {
    res = 0;
    N = sc.nextInt();
    map = new int[N];
    for(int i = 0; i < N; i++) {
        map[i] = sc.nextInt();
    }
//        배열의 서치를 뒤부터 차례로 맨 앞에까지 검색
        int max = 0;
//        2 2 6 1 2 3 4
        for(int i = N-1 ; i >= 0; i--) {
            if(map[i]  < max ) {
                res += max - map[i];
            }else {
                max = map[i];
            }
        }
        System.out.println("#" + t + " " + res);
    }

}
}