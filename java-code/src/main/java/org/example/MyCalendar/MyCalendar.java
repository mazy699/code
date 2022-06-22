package org.example.MyCalendar;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author mzy
 */
public class MyCalendar {
    public static void main(String[] args) {
        GregorianCalendar d = new GregorianCalendar();
        //获取当前的日，月
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        //将d设置为本月的第一天，获取第一天的星期
        d.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        //获取所在地区的星期起始日
        int firstDayOfWeek = d.getFirstDayOfWeek();
        //确定第一天在日历表中的位置
        int indent = 0;
//		System.out.println(today+".. "+month+"... "+weekday+"...."+firstDayOfWeek);
        while (weekday != firstDayOfWeek) {
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
            indent++;
//			System.out.println(indent+". "+today+".. "+month+"... "+weekday+"...."+firstDayOfWeek);
        }
        //打印星期名
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_WEEK, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();
        for (int i = 1; i < indent; i++) {
            System.out.print("	");
        }
        //将d设置为本月第一天
        d.set(Calendar.DAY_OF_MONTH, 1);
        do {
            //打印天
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day);
            //判断是否为当前日期
            if (day == today) {
                System.out.print("*  ");
            } else {
                System.out.print("   ");
            }
            //设置d为下一天
            d.add(Calendar.DAY_OF_MONTH, 1);
            //获取d的星期
            weekday = d.get(Calendar.DAY_OF_WEEK);
            //新星期换一行
            if (weekday == firstDayOfWeek) {
                System.out.println();
            }
        } while (d.get(Calendar.MONTH) == month);//判断条件：d是不是这个月

    }
}
