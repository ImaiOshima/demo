package com.wyh.demo.copy;

/**
 * @author imai
 * @since 2021/3/12 3:09 下午
 * 浅拷贝
 */
public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("1");
        teacher.setAge(1);

        Student student = new Student();
        student.setName("2");
        student.setAge(2);
        student.setTeacher(teacher);

        Student student1 = (Student) student.clone();
        System.out.println("拷贝后");
        System.out.println(student);
        System.out.println(student1);

        System.out.println("修改老师的信息");

        teacher.setName("Games");
        teacher.setAge(3);
        System.out.println(student);
        System.out.println(student1);
    }
}
