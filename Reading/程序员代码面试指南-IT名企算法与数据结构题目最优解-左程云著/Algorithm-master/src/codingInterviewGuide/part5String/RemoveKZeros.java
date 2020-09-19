package codingInterviewGuide.part5String;

/**
 * Created by Dell on 2017-09-02.
 */
public class RemoveKZeros {
    public String removeKZeros(String str,int k){
        if(str==null||k<1){
            return str;
        }
        char[] chas=str.toCharArray();
        int count=0,start=-1;
        for (int i=0;i<chas.length;i++){
            if(chas[i]=='0'){
                count++;
                start=start==-1?i:start;
            }else{
                if(count==k){
                    while (count--!=0){
                        chas[start++]=0;//据说ASCII的0对应的是空，
                    }
                }
                count=0;
                start=-1;
            }
        }
        if(count==k){
            while (count--!=0){
                chas[start++]=0;//据说ASCII的0对应的是空，
            }
        }
        return String.valueOf(chas);



    }
}
