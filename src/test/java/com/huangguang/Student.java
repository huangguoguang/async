package com.huangguang;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * Description:
 * User : huangguang
 * DATE : 2018-09-26 15:55
 */
public class Student {
    private String name;

    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
