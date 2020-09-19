package company.netEasyExam.p2answer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            int[] answer = new int[n];
            Arrays.fill(answer, Integer.MAX_VALUE);
            for(int i = 0; i < n; i++){
                x[i] = scanner.nextInt();
            }
            for(int i = 0; i < n; i++){
                y[i] = scanner.nextInt();
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int[] array= new int[n];
                    for(int k = 0; k < n; k++){
                        array[k] = Math.abs(x[i] - x[k]) + Math.abs(y[j] - y[k]);
                    }
                    Arrays.sort(array);
                    int temp = 0;
                    for(int k = 0; k < n; k++){
                        temp += array[k];
                        answer[k] = Math.min(answer[k], temp);
                    }
                }
            }
            for(int i = 0; i < n-1; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println(answer[n-1]);
        }
        scanner.close();
    }
}