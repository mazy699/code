package org.example.CheckRepeat;

import org.junit.Test;

import static org.example.CheckRepeat.CheckRepeat.checkIsRepeat;

public class CheckRepeatTest {

    @Test
    public void testCheckRepeat(){
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
}
