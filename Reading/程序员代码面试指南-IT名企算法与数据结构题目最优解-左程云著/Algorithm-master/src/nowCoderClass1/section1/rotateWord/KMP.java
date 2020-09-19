package nowCoderClass1.section1.rotateWord;

/**
 * KMP算法
 * 模式串和主串去匹配，直到第一个字符相同
 * 一直比较，直到模式串和主串有一个字符不相同为止
 * 利用已知信息，不要把搜索位置移回已经比较过的信息，而是继续将他向后移，提高效率
 * 针对模式串，设置一个跳转数组  next[]
 * 已知不匹配字符，根据跳转数组不匹配字符的值a，从模式串下标为a的位置开始匹配
 * 如果next值为-1,表示首字母就不匹配，直接向后移一位
 * 直到搜索完成
 *
 * next数组的求值和计算(基于前缀和后缀)
 *
 *
 *
 * Created by Dell on 2017-04-14.
 */
public class KMP {
    void getNext(String p,int[] next){}
    int KMP(String ss,String pp,int[] next){
        char[] s=ss.toCharArray();
        char[] p=pp.toCharArray();

        getNext(pp,next);
        int i=0;
        int s_len=s.length;
        int j=0;
        int p_len=p.length;
        while(i<s_len&&j<p_len){
            if(j==-1||s[i]==p[j]){
                i++;
                j++;
            }else{//将j，匹配失败时置为next[j],进行跳转
                j=next[j];
            }
        }
            if(j==p_len)
                return i-j;
            return -1;
    }





    //求解模式串的next数组
    //示例ABCDABD
//    public void getNext(String pp,int next[]){
//        char[] p=pp.toCharArray();
//        int p_len=p.length;
//        int i=0;//i是模式串P的下标，从0开始，依次求出next[i]的值
//        int j=-1;//j，从next[i]=j看出，j代表前后缀，最长共有元素的长度
//        next[0]=-1;
//        while(i<p_len){
//            if(j==-1||p[i]==p[j]){
//                i++;
//                j++;
//                next[i]=j;//若i=3,接下来要求解的就是P[0]-p[3]的最长相同前后缀的长度，也就是next[4]
//            }else{
//                j=next[j];
//            }
//        }
//    }






//    public void getMyNext(String pp,int next[]){
//        char[] p=pp.toCharArray();
//        int p_len=p.length;
//        int i=0;//i是模式串P的下标，从0开始，依次求出next[i]的值,记录匹配过程中位置
//        int j=-1;//j代表前后缀，最长元素的长度，等于-1表示还没有开始匹配
//        next[i]=-1;//为了特殊边界的判断
//        while(i<p_len){//进行一次匹配
//
//            if(j==-1||p[j]==p[i]){//j等于-1标志着前面都没有比较成功，下一次比较的开始，
//                //向后移动，进行下一次匹配
//                i++;
//                j++;
//                next[i]=j;//将j的值存入数组，如果一次都没有匹配到，++后的结果为0，可存入数据库，j值的重复使用，一遍就可将所有的模式串的最长前后缀求出
//
//            }else{//
//                j=next[j];//初始化j的值等于next[j]的值，如果前面判断没有相等的，则等于0，如果有相等的，j等于前面相等的个数
//            }
//        }
//    }

}
