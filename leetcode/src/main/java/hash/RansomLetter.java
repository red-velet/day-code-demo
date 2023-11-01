package hash;

import java.util.HashMap;

/**
 * author: chiou
 * createTime: 2023/11/1
 * description: 赎金信
 */
public class RansomLetter {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            //没有的情况
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
