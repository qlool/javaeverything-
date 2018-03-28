package com.qlool.jdk1_8.project;

/**
 * 2. 实例方法引用
 */
public class Project_2 {

    public static void main(String[] args) {

        Converter<String, Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return new Helper().String2Int(from);
            }
        };
        Integer old_convert = converter.convert("120");
        System.out.println("old convert = " +old_convert);

        // lambda表达式
        Helper helper = new Helper();
        Converter<String, Integer> converte1 = helper::String2Int;
        Integer new_converter = converte1.convert("120");
        System.err.println("new converter ="+new_converter);
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    static class Helper {
        public int String2Int(String from) {
            return Integer.valueOf(from);
        }
    }
}
