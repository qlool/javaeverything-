package com.qlool.java.base.entity;

/**
 * @Author: cxn
 * @Description: (测试)
 * @Date: Created in 11:05 2018/5/18
 * @Modified by:
 */
public class Persion {

    private String name ;
    private String sex;


    public String getName() {
        return name;
    }

    public Persion setName(String name) {
        this.name = name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Persion setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
class Test{
    /**
     * @Author: cxn
     * @Description: []
     */
    public static void main(String[] args) {
        Persion persion = new Persion().setName("testName").setSex("man");
        System.out.println(persion);
    }

}