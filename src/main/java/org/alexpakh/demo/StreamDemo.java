package org.alexpakh.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamDemo {

    int age;
    String name;
    List<String> strings = new ArrayList<>();
    List<StreamDemo> students = new ArrayList<>();

    public void addStudents() {

        students.add(new StreamDemo((10), "pavel"));
        students.add(new StreamDemo((13), "pave"));
        students.add(new StreamDemo((13), "pavlo"));
        students.add(new StreamDemo((14), "anton"));
        students.add(new StreamDemo((15), "alex"));
        students.add(new StreamDemo((17), "ale"));
        students.add(new StreamDemo((10), "parks"));
        students.add(new StreamDemo((17), "alexandr"));
    }

    public StreamDemo() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StreamDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void addStrings(String string) {
        strings.add(string);
    }

    public static void main(String[] args) {


        StreamDemo streamDemo = new StreamDemo();

        IntStream.range(1, 5).forEach(i -> streamDemo.addStudents());
        System.out.println(streamDemo.students + "\n");


        double age = streamDemo.students.stream()
                .collect(Collectors.averagingInt(StreamDemo::getAge));
        System.out.println(age);
        List<StreamDemo> studentFilter = streamDemo.students.stream()
                .filter(student -> student.getAge() > 10)
                .filter(student -> student.getName().contains("pav"))
                .toList();
        System.out.println(studentFilter);


    }

    @Override
    public String toString() {
        return "StreamDemo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
