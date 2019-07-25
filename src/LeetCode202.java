import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode202 {
    /**
     * 常规解法 按规则去算
     * 小技巧就是10以内的直接按类型返回
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if(n == 1 || n == 7) {
            return true;
        }
        if(n < 10) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (true){
            int sum = 0;
            while (n != 0){
                int temp = n % 10;
                sum += temp * temp;
                n = n/10;
            }
            if(sum == 1){
                return true;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n = sum;
        }
    }
}