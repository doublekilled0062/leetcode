/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 * 输入：14
 * 输出：False
 */
public class LeetCode367 {
    /**
     * 牛顿迭代法。。。这个最快
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num < 0){
            return false;
        }
        if(num == 0 || num == 1){
            return true;
        }
        long start = num;
        while (start * start > num){
            start = (start + num/start)/2;
        }
        return (int)(start * start) == num;
    }

    /**
     * 还有完全平方数这个东西 1 + 3 + 5 + 7 + 9...
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        int value = 1;
        while (num > 0){
            num -= value;
            value = value + 2;
        }
        return num == 0;
    }
}
