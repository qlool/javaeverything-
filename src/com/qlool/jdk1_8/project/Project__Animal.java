package com.qlool.jdk1_8.project;

/**
 *  3.构造方法引用
 *
 * 3.1.父类
 */
public class Project__Animal {

    private String name;
    private int age;

    public Project__Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void behavior() {
    }
}

/**
 * 3.2.定义子类
 */
class Bird extends Project__Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior() {
        System.out.println("fly");
    }
}

/**
 * 3.3.定义子类
 */
class Dog extends Project__Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior() {
        System.out.println("run");
    }
}

/**
 * 3.4.定义工厂接口：
 */
interface Factory<T extends Project__Animal> {
    T create(String name, int age);
}

class test{

    public static void main(String[] args) {
        /**
         * 用传统的方法来创建Dog类和Bird类的对象：
         */
        Factory factory=new Factory() {
            @Override
            public Project__Animal create(String name, int age) {
                return new Dog(name,age);
            }
        };

        Project__Animal dog = factory.create("dog", 3);
        dog.behavior();

        factory=new Factory() {
            @Override
            public Project__Animal create(String name, int age) {
                return new Bird(name,age);
            }
        };
        Project__Animal bird = factory.create("bird", 2);
        bird.behavior();

        /**q
         * lambda表达式仅仅为了创建两个对象就写了十多号代码，现在我们用构造函数引用试试：
         */
        Factory<Dog> dogFactory =Dog::new;
        Dog ldog = dogFactory.create("alias", 4);
        ldog.behavior();
        Factory<Bird> birdFactory = Bird::new;
        Bird lbird = birdFactory.create("smook", 3);
        lbird.behavior();

    }
}
