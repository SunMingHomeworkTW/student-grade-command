package com.tw;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
  private String id;
  private String name;
  private Map<String,Integer> scores;
  private int totalScore;
  private double averageScore;

  public Student(){}

  public Student(String studentInfo) {
    String[] strs=studentInfo.split("，");
    name=strs[0];
    id=strs[1];
    scores=new LinkedHashMap<>();
    for (int i = 0; i < strs.length - 2; i++) {
      String[] strs1=strs[i+2].split("：");
      scores.put(strs1[0],Integer.valueOf(strs1[1]));
    }
    totalScore=getTotalScoreOfAStudent(scores);
    averageScore=getAverageScoreOfAStudent(scores);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Integer> getScores() {
    return scores;
  }

  public void setScores(Map<String, Integer> scores) {
    this.scores = scores;
  }

  public double getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(double averageScore) {
    this.averageScore = averageScore;
  }

  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }


  public int getTotalScoreOfAStudent(Map<String, Integer> scores) {
    int sum=0;
    for(int score:scores.values())
      sum+=score;
    return sum;
  }

  public double getAverageScoreOfAStudent(Map<String, Integer> scores) {
    return (double) getTotalScoreOfAStudent(scores)/scores.size();
  }

  public String getDetailedInfo(){
    return name+"|"+scores.get("数学")+"|"+scores.get("语文")+"|"+scores.get("英语")+"|"+scores.get("编程")+"|"+averageScore+"|"+totalScore+"\n";
  }
}
