package com.tw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Student> studentList;
    private List<Integer> totalScoreList;

    public Library() {
        studentList=new ArrayList<>();
        totalScoreList=new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Integer> getTotalScoreList() {
        return totalScoreList;
    }

    public void setTotalScoreList(List<Integer> totalScoreList) {
        this.totalScoreList = totalScoreList;
    }

    public boolean someLibraryMethod() {
        return true;
    }

    public void printMainMenu() {
        System.out.print("1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择（1~3）：\n");
    }

    public void addStudentInfo(String studentInfo) {
        Student student=new Student(studentInfo);
        studentList.add(student);
        totalScoreList.add(student.getTotalScore());
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

    public double getAverageScore() {
        double averageScore=0.0;
        for(int totalScore:totalScoreList)
            averageScore+=totalScore;
        return averageScore/totalScoreList.size();
    }

    public double getMedianScore() {
        Collections.sort(totalScoreList);
        if(totalScoreList.size()%2==1){
            return totalScoreList.get(totalScoreList.size()/2);
        }
        else {
            return ((double)totalScoreList.get(totalScoreList.size()/2)+(double)totalScoreList.get(totalScoreList.size()/2-1))/2;
        }
    }

    public void buildReport(String infos) {
        if(infos.matches("[，,0-9]*")){
            System.out.print("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n");
            String[] strs=infos.split(",");
            for (int i = 0; i <strs.length ; i++) {
                for(Student student:studentList){
                    if (Integer.valueOf(student.getId())==Integer.valueOf(strs[i])) {
                        System.out.print(student.getDetailedInfo());
                        break;
                    }
                }
            }
            System.out.print("========================\n全班总分平均数："+getAverageScore()+"\n全班总分中位数："+getMedianScore()+"\n");
            printMainMenu();
        }else {
            System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        }
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args){
        Library library=new Library();
        library.printMainMenu();
        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNext()){
            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
                    library.addStudentAchievement(scanner.nextLine());
                    break;
                case "2":
                    System.out.print("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
                    library.buildReport(scanner.nextLine());
                    break;
                case "3":
                    library.exit();
                    default:
                        library.printMainMenu();
                        break;

            }
        }
    }
}
