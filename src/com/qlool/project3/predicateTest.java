package com.qlool.project3;

import java.util.Objects;
import java.util.function.Predicate;

public class predicateTest {

    /**
     * 输入一个参数，并返回一个Boolean值，其中内置许多用于逻辑判断的默认方法:
     * @param args
     */
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean test = predicate.test("test");
        System.out.println("字符串长度大于0:" + test);

        test = predicate.test("");
        System.out.println("字符串长度大于0:" + test);

        test = predicate.negate().test("");
        System.out.println("字符串长度小于0:" + test);

        Predicate<Object> pre = Objects::nonNull;
        Object ob = null;
        test = pre.test(ob);
        System.out.println("对象不为空:" + test);
        ob = new Object();
        test = pre.test(ob);
        System.out.println("对象不为空:" + test);
    }

}
