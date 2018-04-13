package com.tw;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.fest.assertions.api.Assertions.assertThat;

public class LibraryTest {
    private Library library;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        library=new Library();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void testPrintMainMenu(){
        library.printMainMenu();
        assertThat(systemOut()).isEqualTo("1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择（1~3）：\n");
    }

    @Test
    public void testAddStudentInfo() {
        String studentInfo="张三，0001，数学：75，语文：95，英语：80，编程：80";
        library.addStudentInfo(studentInfo);
        assertThat(library.getStudentList().size()).isEqualTo(1);
    }

    @Test
    public void should_studentInfo_added_successful() {
        String studentInfo="张三，0001，数学：75，语文：95，英语：80，编程：80";
        library.addStudentAchievement(studentInfo);
        assertThat(systemOut()).isEqualTo("学生张三的成绩被添加\n1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择（1~3）：\n");
    }

    @Test
    public void should_studentInfo_added_failed() {
        String studentInfo="李四，0002，数学,85，语文,80，英语,70，编程,90";
        library.addStudentAchievement(studentInfo);
        assertThat(systemOut()).isEqualTo("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
    }

    @Test
    public void testGetAverageTotalScore() {
        List<Integer> totalScoreList=new ArrayList<>();
        totalScoreList.add(330);
        totalScoreList.add(325);
        library.setTotalScoreList(totalScoreList);

        assertThat(library.getAverageScore()).isEqualTo(327.5);
    }

    @Test
    public void testGetMedianTotalScore() {
        List<Integer> totalScoreList=new ArrayList<>();
        totalScoreList.add(330);
        totalScoreList.add(325);
        library.setTotalScoreList(totalScoreList);

        assertThat(library.getMedianScore()).isEqualTo(327.5);
    }

    @Test
    public void should_print_report_successful() {
        String studentInfo1="张三，0001，数学：75，语文：95，英语：80，编程：80";
        String studentInfo2="李四，0002，数学：85，语文：80，英语：70，编程：90";
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(studentInfo1));
        studentList.add(new Student(studentInfo2));
        library.setStudentList(studentList);

        List<Integer> totalScoreList=new ArrayList<>();
        totalScoreList.add(330);
        totalScoreList.add(325);
        library.setTotalScoreList(totalScoreList);

        String infos="0001,0002,003";

        library.buildReport(infos);
        assertThat(systemOut()).isEqualTo("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n张三|75|95|80|80|82.5|330\n李四|85|80|70|90|81.25|325\n========================\n全班总分平均数：327.5\n全班总分中位数：327.5\n1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择（1~3）：\n");
    }

    @Test
    public void should_print_report_failed() {
        String studentInfo1="张三，0001，数学：75，语文：95，英语：80，编程：80";
        String studentInfo2="李四，0002，数学：85，语文：80，英语：70，编程：90";
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(studentInfo1));
        studentList.add(new Student(studentInfo2));
        library.setStudentList(studentList);

        List<Integer> totalScoreList=new ArrayList<>();
        totalScoreList.add(330);
        totalScoreList.add(325);
        library.setTotalScoreList(totalScoreList);

        String infos="0001 0002";

        library.buildReport(infos);
        assertThat(systemOut()).isEqualTo("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
    }

    @Test
    public void testExit() {
        library.exit();
    }
}
