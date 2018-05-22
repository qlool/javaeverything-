package com.qlool.java.base.datatype;

import java.math.BigDecimal;

/**
 * @Author: cxn
 * @Description: (Explain this function)
 * @Date: Created in 17:14 2018/5/22
 * @Modified by:
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        // 浮点数的打印
        System.out.println(new BigDecimal("0.01").toString());

        // 普通的数字字符串
        System.out.println(new BigDecimal("100.000").toString());

        // 去除末尾多余的0
        System.out.println(new BigDecimal("100.000").stripTrailingZeros().toString());

        // 避免输出科学计数法
        System.out.println(new BigDecimal("100.000").stripTrailingZeros().toPlainString());
    }
}
