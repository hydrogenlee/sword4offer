package sword4offer.chapter8;

public class 正则表达式匹配 {
    public static void main(String[] args) {
        Solution solution = new 正则表达式匹配().new Solution();
        System.out.println(solution.match("".toCharArray(), ".*".toCharArray()));            // true
        System.out.println(solution.match("aaa".toCharArray(), "a.a".toCharArray()));        // true
        System.out.println(solution.match("aaa".toCharArray(), "ab*ac*a".toCharArray()));    // true
        System.out.println(solution.match("aaa".toCharArray(), ".*aaa".toCharArray()));      // true
        System.out.println(solution.match("aaa".toCharArray(), "a.aa".toCharArray()));       // false
        System.out.println(solution.match("aaa".toCharArray(), "ab*a".toCharArray()));       // false
    }

    class Solution {
        // 模式中的字符'.'表示任意一个字符
        // 而'*'表示它前面的字符可以出现任意次（包含0次）。
        // 思路：
        //      如果是除'.'和'*'之外的任何字符，那么直接进行匹配即可
        //      如果仅仅出现了'.'，那么直接匹配当前字符即可
        //      如果仅出现'*'，那么匹配前面的字符多次，需要判断到底是几次
        //      如果同时出现".*"，那么需要判断匹配几个字符
        public boolean match(char[] str, char[] pattern) {
            if (str == null || pattern == null) {
                return false;
            }
            // 从后往前进行匹配
            return doMatch(str, pattern, str.length - 1, pattern.length - 1);
        }

        private boolean doMatch(char[] str, char[] pattern, int strEnd, int patternEnd) {
            // 是不是同时匹配完成
            if (patternEnd < 0 && strEnd >= 0) {
                return false;
            }
            if (strEnd < 0) {
                return patternEnd < 0 || (patternEnd == 1 && pattern[1] == '*'); // 表示还剩下两个字符
            }
            // 不匹配
            if (str[strEnd] != pattern[patternEnd] && pattern[patternEnd] != '.' && pattern[patternEnd] != '*') {
                return false;
            }
            // 如果当前字符相等，或者仅遇到'.'
            if (str[strEnd] == pattern[patternEnd] || pattern[patternEnd] == '.') {
                return doMatch(str, pattern, strEnd - 1, patternEnd -1);
            }

            // 如果遇到了'*'，那么需要同时考虑'*'之前的字符
            // 分为几种情况，匹配0个，匹配1个和匹配多个
            return  doMatch(str, pattern, strEnd, patternEnd - 2) ||                           // 匹配0个
                    ((str[strEnd] == pattern[patternEnd - 1] || pattern[patternEnd - 1] == '.') &&       // 判断前一个字符是否符合条件
                            (doMatch(str, pattern, strEnd - 1, patternEnd - 2) ||       // 匹配1个
                                    doMatch(str, pattern, strEnd - 1, patternEnd)));              // 匹配多个
        }
    }
}
