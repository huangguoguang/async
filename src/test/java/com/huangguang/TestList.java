package com.huangguang;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2018-09-26 14:50
 */
public class TestList {
    //@Test
    public void testList() {
        String[] aaa = {"123", "456", "789"};
        List<String> bbb = Arrays.asList(aaa)
                .stream()
                .filter(x -> x.equals("123"))
                .collect(Collectors.toList());
        System.out.println(bbb);
    }

    @Test
    public void testList2() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三", 88));
        studentList.add(new Student("张大", 86));
        studentList.add(new Student("张二", 82));
        studentList.add(new Student("张四", 78));
        studentList.add(new Student("张五", 98));

        //筛选出成绩大于85的学生
        List<Student> aList = studentList.stream().filter(student -> student.getScore() > 85).collect(Collectors.toList());
        System.out.println(aList);


        //map归类。结果一般是一组数据
        List<String> nList = studentList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(nList);
        nList.forEach(s -> System.out.println(s));


        List<Integer> sList = studentList.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .map(Student::getScore)
                .collect(Collectors.toList());
        System.out.println(sList);
        sList.forEach(System.out::println);

        //求和
        Integer sum = studentList.stream().mapToInt(Student::getScore).sum();
        System.out.println("求和:" + sum);

        //求平均值
        OptionalDouble avg = studentList.stream().mapToInt(Student::getScore).average();
        System.out.println("求平均值:" + avg.getAsDouble());

        //计算最高分和最低分
        Optional<Integer> max = studentList.stream().map(Student::getScore).reduce(Integer::max);
        System.out.println("求最高分:" + max.get());

        Optional<Integer> min = studentList.stream().map(Student::getScore).reduce(Integer::min);
        System.out.println("求最低分:" + min.get());

        //生成随机数流
        IntStream intStream = IntStream.rangeClosed(1, 100);
        System.out.println(intStream);
    }


}
