package com.java_2_base.webapp.other;

public class MainUtil {

    public static void main(String[] args) {
        // true
        //System.out.println(Integer.valueOf(-1) == Integer.valueOf(-1));
        // false
        //System.out.println(Integer.valueOf(-1) == new Integer(-1));

        int result = getInt();
        System.out.println("\n" + result);

        // ошибка! NullPointerException
        //result = getInt2();
        System.out.println(getInt2());
    }

    private static Integer getInt(){
        return -1;
    }

    private static Integer getInt2(){
        return null;
    }
}
