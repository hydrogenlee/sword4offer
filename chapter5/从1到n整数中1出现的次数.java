package sword4offer.chapter5;

public class 从1到n整数中1出现的次数 {
    public static void main(String[] args) {
        Solution solution = new 从1到n整数中1出现的次数().new Solution();
        System.out.println(solution.countNumberOf1Between1AndN(12));         // 5
        System.out.println(solution.countNumberOf1Between1AndN(13));         // 6
    }

    class Solution {
        // 思路：
        //                      12    3   45
        //                      ^     ^   ^
        //                    round  cur  pre = 45
        // 若cur为0，则1出现次数为round * base               // 只有round有关， 其实 = round * base + 0 * base
        // 若cur为1，则1出现次数为round * base + pre + 1     // 不仅与round有关，还与其前面的值有关， 即pre + 1个1
        // 若cur大于1，则1出现次数为round * base + base      // 不仅与round有关，还与cur有关
        public int countNumberOf1Between1AndN(int n) {
            if (n <= 0) {
                return 0;
            }

            int base = 1;
            int count = 0;
            int round = n;
            while (round > 0) {
                int cur = round % 10;
                round /= 10;
                if (cur == 1) {
                    // round * base + pre + 1
                    count += round * base + n % base + 1;
                } else if (cur > 1) {
                    // round * base + base
                    count += round * base + base;
                } else {
                    // round * base
                    count += round * base;
                }
                base *= 10;
            }

            return count;
        }
    }
}
