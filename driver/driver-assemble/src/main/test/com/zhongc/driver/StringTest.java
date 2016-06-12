package com.zhongc.driver;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Collator;
import java.util.*;

/**
 * Created by cst on 2016/4/7 0007.
 */
public class StringTest {

    String lpad(String b, int length, char p) {
        if (b == null || b.length() >= length) {
            return b;
        }
        StringBuffer sb = new StringBuffer(p);
//        for (int i = 0;i = length - b.length()-)

        return "";
    }


    public static void main(String[] args) {
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        List<String> arrayList = Arrays.asList("1","2");

        Arrays.sort(arrayList.toArray(),comparator);

        int a = 256 << 2;
        System.out.println(a);


    }
}
