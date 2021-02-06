package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int size = Integer.parseInt(br.readLine());
            int[][] map = new int[size][size];
            int sum = 0;

            for (int i = 0; i < size; i++) {
                String s = br.readLine();
                for (int j = 0; j < size; j++) {
                    map[i][j] = s.charAt(j)-'0';
                }
            }

            for (int i = 0; i <= (size/2); i++) {
                for (int j = size/2 - i; j <= size/2 +i; j++) {
                    sum += map[i][j];
                }
            }

            for (int i = 1; i <size; i++) {
                for (int j = size-(i+1); j >= i; j--) {
                    sum += map[(size/2)+i][j];
                }
            }

            System.out.println("#"+(t+1)+" "+sum);
        }
    }
}
