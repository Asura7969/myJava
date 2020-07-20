package org.myJava.algorithm.bitmap;

/**
 * https://www.toutiao.com/i6837870999216587271/
 */
public class FindNumber {
    /**
     * 保存数据的
     */
    private byte[] bits;

    /**
     * 能够存储多少数据
     */
    private int capacity;

    public FindNumber(int capacity) {
        this.capacity = capacity;

        //1bit能存储8个数据，那么capacity数据需要多少个bit呢，(capacity/8)+1,右移3位相当于除以8
        bits = new byte[(capacity >> 3) + 1];
        System.out.println("初始化容量:" + ((capacity >> 3) + 1));
    }

    public void add(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;
        System.out.println(num + " 对应的索引位:" + arrayIndex);

        // num%8得到在byte[index]的位置
        int position = num & 0x07;
        System.out.println("(num & 0x07) = (num % 8) :" + ((num & 0x07) == (num % 8)));
        System.out.println("0x07 = " + 0x07);
        System.out.println(position);

        //将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了。
        bits[arrayIndex] |= 1 << position;
    }

    public boolean contain(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
        return (bits[arrayIndex] & (1 << position)) != 0;
    }

    public void clear(int num) {
        // num/8得到byte[]的index
        int arrayIndex = num >> 3;

        // num%8得到在byte[index]的位置
        int position = num & 0x07;

        //将1左移position后，那个位置自然就是1，然后对取反，再与当前值做&，即可清除当前的位置了.
        bits[arrayIndex] &= ~(1 << position);

    }

    public static void main(String[] args) {
        FindNumber bitmap = new FindNumber(100);
        bitmap.add(10);
        System.out.println("插入10成功");

        boolean isexsit = bitmap.contain(7);
        System.out.println("7是否存在:" + isexsit);

        bitmap.clear(7);
        isexsit = bitmap.contain(7);
        System.out.println("7是否存在:" + isexsit);
    }
}
