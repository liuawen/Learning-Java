package company.netEasyExam.p8;

import java.util.Scanner;

public class Main {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] state = new int[n+1][k+1];
        state[0][1] = 1;
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum = (sum + state[i-1][j]) % mod;
            }
            for(int j=1; j<=k; j++) {
                int invalid = 0;
                int p = 2;
                while(p*j <= k) {
                    invalid = (invalid + state[i-1][p*j]) % mod;
                    p++;
                }
                 state[i][j] = (sum - invalid + mod) % mod;
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                System.out.print(state[i][j]+"    ");
            }
            System.out.println();
        }


        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum = (sum + state[n][i]) % mod;
        }

        System.out.println(sum);
        scanner.close();
    }
}