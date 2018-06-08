package sword4offer.chapter8;

import java.util.HashMap;
import java.util.Map;

public class 字符流中第一个不重复的字符 {
    private static Map<Character, Integer> map;
    private static int index;

    public 字符流中第一个不重复的字符() {
        map = new HashMap<>();
        index = 0;
    }

    public static void main(String[] args){
        字符流中第一个不重复的字符 solution = new 字符流中第一个不重复的字符();
        solution.insert('g');
        System.out.println(solution.firstAppearingOnce());   // 'g'
        solution.insert('o');
        System.out.println(solution.firstAppearingOnce());   // 'g'
        solution.insert('o');
        System.out.println(solution.firstAppearingOnce());   // 'g'
        solution.insert('g');
        System.out.println(solution.firstAppearingOnce());   // '#'
        solution.insert('l');
        System.out.println(solution.firstAppearingOnce());   // 'l'
        solution.insert('e');
        System.out.println(solution.firstAppearingOnce());   // 'l'
    }

    //Insert one char from stringstream
    public void insert(char ch) {
        if (map.containsKey(ch)) {
            // 出现多次时置-1
            map.put(ch, -1);
        } else {
            map.put(ch, index++);
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        char result = '#';
        int max = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() < max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
