package codingInterviewGuide.part4dp;

/**
 * 字符串交错组成
 * Created by Dell on 2017-08-10.
 */
public class Mixture {
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if(n==0||m==0||v==0){
            return true;
        }
        if(n!=0&&m!=0) {
            if (C.charAt(0) == A.charAt(0) && C.charAt(0) == B.charAt(0)) {
                boolean a, b;
                a = chkMixture(A.substring(1), n - 1, B, m, C.substring(1), v - 1);
                b = chkMixture(A, n, B.substring(1), m - 1, C.substring(1), v - 1);
                return a || b;
            }
            if (C.charAt(0) == A.charAt(0)) {
                return chkMixture(A.substring(1), n - 1, B, m, C.substring(1), v - 1);
            }
            if (C.charAt(0) == B.charAt(0)) {
                return chkMixture(A, n, B.substring(1), m - 1, C.substring(1), v - 1);
            }
        }
        return n==0?A.equals(C):B.equals(C);
    }
}
