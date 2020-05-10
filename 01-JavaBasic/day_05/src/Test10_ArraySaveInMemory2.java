/**
 * @author Liu Awen
 * @create 2018-05-10 19:47
 */
/*
数组的存储
栈   堆
连续的存储空间
 */
class Test10_ArraySaveInMemory2{
    public static void main(String[] args){
        int[] array = new int[5];
        //默认值  0
        array[0] = 1;
        array[1] = 3;
        System.out.println(array[4]);

        String[] names = new String[5];
        names[0] = "法外狂徒";
        //元素的默认值是null
    }
}