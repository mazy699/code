package org.example.CheckRepeat;

import java.util.HashSet;

/**
 * @author mzy
 */
public class CheckRepeat {
    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        String c = "2";
        String[] array = {a,b,c};
        if (checkIsRepeat(array)) {
            System.out.println("没有重复值！");
        } else {
            System.out.println("有重复值！");
        }
    }

    /*
     * 判断数组中是否有重复的值
     */
    private static boolean checkIsRepeat(String[] array) {
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
