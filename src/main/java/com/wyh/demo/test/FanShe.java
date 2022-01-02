package com.wyh.demo.test;

public class FanShe {
    public static void main(String[] args)  {
        //First
        Person person1 = new Person();
        Class class1 = person1.getClass();
        System.out.println(class1.getName());

        //second
        Class class2 = Person.class;
        System.out.println(class1 == class2);

        try {
            Class class3 = Class.forName("com.wyh.demo.test.Person");
            System.out.println(class3==class2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
