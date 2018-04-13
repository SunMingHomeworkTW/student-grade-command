package com.tw;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Student> studentList;

    public Library() {
        studentList=new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean someLibraryMethod() {
        return true;
    }

    public void printMainMenu() {
        System.out.print("1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择（1~3）：\n");
    }

    public void addStudentInfo(String studentInfo) {
        studentList.add(new Student(studentInfo));
    }
}
