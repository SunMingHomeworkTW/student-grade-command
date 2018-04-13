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

    public void addStudentAchievement(String studentInfo) {
        try {
            addStudentInfo(studentInfo);
            System.out.print("学生"+studentList.get(studentList.size()-1).getName()+"的成绩被添加\n");
            printMainMenu();
        }catch (Exception e){
            System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
        }
    }
}
