package com.qlool.project;

/**
 *  1.静态方法引用
 */
public class Project_1 {

    public static void main(String[] args) {
        Converter<String ,Integer> converter=new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Project_1.String2Int(from);
            }
        };
        Integer old_convert = converter.convert("120");
        System.out.println("old convert="+old_convert);


        Converter<String, Integer> converter1 = Project_1::String2Int;
        Integer new_convert = converter1.convert("120");
        System.err.println("new convert = " + new_convert);
    }

    @FunctionalInterface
    interface Converter<F,T>{
        T convert(F from);
    }

   public static int String2Int(String from) {
        return Integer.valueOf(from);
    }
}
