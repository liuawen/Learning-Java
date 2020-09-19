package nowCoderClass1.section10;

import java.util.Random;

/**
 * Created by Dell on 2017-06-02.
 */
public class Random7 {
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }

    // 通过rand5实现rand7
    public int randomNumber() {
        //TODO


        return 0;
    }
}
