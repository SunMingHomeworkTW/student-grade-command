package com.tw;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class StudentTest {
  private  Student student;

  @Test
  public void testGetAverageScoreOfAStudent() {
    Map<String,Integer> scores=new HashMap<>();
    scores.put("数学",75);
    scores.put("语文",95);
    scores.put("英语",80);
    scores.put("编程",80);
    student=new Student();
    assertThat(student.getAverageScoreOfAStudent(scores)).isEqualTo(82.5);
  }

  @Test
  public void testGetTotalScoreOfAStudent() {
    Map<String,Integer> scores=new HashMap<>();
    scores.put("数学",75);
    scores.put("语文",95);
    scores.put("英语",80);
    scores.put("编程",80);
    student=new Student();
    assertThat(student.getTotalScoreOfAStudent(scores)).isEqualTo(330);
  }

  @Test
  public void testGetDetailedInfo() {
    String studentInfo="张三，0001，数学：75，语文：95，英语：80，编程：80";
    student=new Student(studentInfo);
    assertThat(student.getDetailedInfo()).isEqualTo("张三|75|95|80|80|82.5|330");
  }
}
