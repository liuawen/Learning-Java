package cn.liuawen.inherit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-31
 */
public class SubClass extends SuperClass{
    @Override
    public ArrayList<Integer> func() throws Throwable {
        return new ArrayList<>();
    }
}
