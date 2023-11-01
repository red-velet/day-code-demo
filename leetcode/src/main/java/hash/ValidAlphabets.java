package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description:有效的字母异位词
 */
public class ValidAlphabets {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        //把t的每个字母出现次数加入hash
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : sArray) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, (map.get(c) + 1));
            }
        }
        for (char c : tArray) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, (map.get(c) - 1));
            }
        }
        //Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (entry.getValue() == 0) {
                iterator.remove();
            }
        }
        return map.isEmpty();
    }
}
