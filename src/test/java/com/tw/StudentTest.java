//package com.tw;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.fest.assertions.api.Assertions.assertThat;
//
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.Test;
//
//public class StudentTest {
//  private  Student student;
//
//  @Test
//  public void testGetAverageScoreOfAStudent() {
//    Map<String,Integer> scores=new HashMap<>();
//    scores.put("数学",75);
//    scores.put("数学",75);
//    scores.put("数学",75);
//    scores.put("数学",75);
//    assertThat(student.getAverageScoreOfAStudent(scores)).isEqualTo(82.5);
//  }
//
//  @Test
//  public void testGetTotalScoreOfAStudent() {
//    Map<String,Integer> scores=new HashMap<>();
//    scores.put("数学",75);
//    scores.put("数学",75);
//    scores.put("数学",75);
//    scores.put("数学",75);
//    assertThat(student.getTotalScoreOfAStudent(scores)).isEqualTo(330);
//  }
//}
