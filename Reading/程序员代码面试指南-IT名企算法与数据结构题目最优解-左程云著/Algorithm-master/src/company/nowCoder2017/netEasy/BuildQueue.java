package company.nowCoder2017.netEasy;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-08.
 */
public class BuildQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group=sc.nextInt();
        while (group-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            //约瑟夫环
            int cur = 1;
            for (int i = 1; i < n; i += 2) {
                arr[i] = cur++;
            }
            int index = 0;
            int count = 0;
            while (cur <= n) {
                for (int i = index % n; i < n; i++) {
                    if (arr[i] == 0) {
                        count++;
                    }
                    if (count == 2) {
                        arr[i] = cur++;
                        index = i;
                        count = 0;
                        continue;
                    }
                }
                index = 0;
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[n - 1]);
        }
    }
}
