package org.example.CheckRepeat;

import java.util.HashSet;

/**
 * @author mzy
 */
public class CheckRepeat {
    /**
     * 判断数组中是否有重复的值
     */
    public static boolean checkIsRepeat(String[] array) {
        HashSet<String> hashSet = new HashSet<>();
        int count = 0;
        for (String s : array) {
            if ("".equals(s)) {
                count++;
                continue;
            }
            hashSet.add(s);
        }
        count += hashSet.size();
        return count == array.length;
    }
}
