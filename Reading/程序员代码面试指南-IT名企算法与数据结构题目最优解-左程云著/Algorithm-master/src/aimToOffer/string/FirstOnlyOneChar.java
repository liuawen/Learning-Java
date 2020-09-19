package string;

import java.util.LinkedHashMap;

/**
 * Created by Dell on 2017-06-12.
 */
public class FirstOnlyOneChar {
    /**
     * 使用LinkedHashMap或者数组去实现
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
