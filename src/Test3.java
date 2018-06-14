import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test3 {

    public static void main(String[] args) {

        String str = "tmammzuxt";

        // i = 2

        int result = lengthOfLongestSubstring(str);

        System.out.println("result = " + result);

    }

    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();

        int result = 0;

        // tmammzuxt
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < len; j++) {

            char currChar = s.charAt(j);

            if (map.containsKey(currChar)) { // 说明已经有了

                i = Math.max(map.get(currChar) + 1, i);

            }

            result = Math.max(result, j - i + 1);

            map.put(currChar, j);

        }

        return result;

    }

}
