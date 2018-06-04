package sword4offer.chapter4;

import java.util.ArrayList;

public class 字符串的所有组合 {
    public static void main(String[] args) {
        ArrayList<String> result = combination(new char[]{'a', 'b', 'c'});
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> combination(char[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        doCombination(result, new StringBuilder(), array, 0);

        return result;
    }

    public static void doCombination(ArrayList<String> result, StringBuilder sb,
                                     char[] array, int start) {
        if (sb.length() != 0) {
            result.add(sb.toString());
        }

        for (int i = start; i < array.length; i++) {
            doCombination(result, sb.append(array[i]), array, i + 1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
