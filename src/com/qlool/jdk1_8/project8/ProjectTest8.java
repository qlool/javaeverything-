package com.qlool.jdk1_8.project8;

import java.util.ArrayList;
import java.util.List;

/**
 * 效率
 */
public class ProjectTest8 {

    public static void main(String[] args) {
        test2();
    }

    public static void test2(){

        List<String> list = new ArrayList<>();
        for(int i=0;i<10000;i++)
            list.add(String.valueOf(i));
        //lambda表达式 ->并行
        long start = System.currentTimeMillis();
//        list.parallelStream().forEach((s)->{
//            s.toString();
//        });

        //lambda表达式 ->串行
        list.stream().forEach((s)->{
            s.toString();
        });
        //普通测试
//        for (Object s :list){
//            s.toString();
//        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start) +"  ms");
    }
}
