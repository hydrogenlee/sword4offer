package sword4offer.chapter6;

import java.util.ArrayList;
import java.util.List;

public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        System.out.println(lastRemainingOptimized(5, 2));        // 2
        System.out.println(lastRemainingOptimized(5, 3));        // 3
        System.out.println("------------------------------");
        System.out.println(lastRemaining(5, 2));        // 2
        System.out.println(lastRemaining(5, 3));        // 3
    }


    // 使用递推公式
    //            +----- 0                    , n = 1
    // f(n, m) = |
    //           +-----  [f(n-1, m) + m] % n  , n > 1
    // T-C: O(N)
    // S-C: O(1)
    private static int lastRemainingOptimized(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }


    // 使用模拟圆环
    // T-C: O(MN)
    // S-C: O(N)
    public static int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        // 删除
        int i = 1;
        int deleteIndex = 0;
        while (list.size() > 1) {
            if (i % m == 0) {
                list.remove(deleteIndex);
                // 如果在删除元素后，deleteIndex指向现在数组的的长度位置，
                // 重新指向开头，否则不变
                if (deleteIndex == list.size()) {
                    deleteIndex = 0;
                }
            } else {
                deleteIndex = (deleteIndex + 1) % list.size();
            }
            i++;
        }

        return list.get(0);
    }
}
