/*
 * ------------------------------------------------------
 * PROJECT : AI기반 솔루션 지식자산화 
 * NAME : KAADM04VO.java
 * ------------------------------------------------------
 * REVERSION :
 * 2020.06.24  신예은   최초작성
 * ------------------------------------------------------
 * */
package com.izt.adm;

public class KAADM04VO {
    private String user_id;
    private String point_type;
    private String period;
    
    private String solution;
    private String question;
    private String answer;
    private String notSuccess;
    private String score;
	private String scoreCount;
	private String avgScore;
    private String dueDate;
    private String point;
	private String userName;
	private String userDept;

	private String action;
	private String title;



	public String getUserDept(){
		return userDept;
	}
	public void setUserDept(String userDept){
		this.userDept=userDept;
	}
	public String getAvgScore(){
		return avgScore;
	}
	public void setAvgScore(String avgScore){
		this.avgScore=avgScore;
	}
	public String getAction(){
		return action;
	}
	public void setAction(String action){
		this.action=action;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    public String getScoreCount() {
		return scoreCount;
	}
	public void setScoreCount(String scoreCount) {
		this.scoreCount = scoreCount;
	}
    public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getNotSuccess() {
		return notSuccess;
	}
	public void setNotSuccess(String notSuccess) {
		this.notSuccess = notSuccess;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getSolution() {
        return solution;
    }
    public void setSolution(String solution) {
        this.solution = solution;
    }
    public String getPoint_type() {
        return point_type;
    }
    public void setPoint_type(String point_type) {
        this.point_type = point_type;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }

	@Override
	public String toString() {
		return "Practice02 [user_id=" + user_id + ", point_type=" + point_type + ", period=" + period + ", solution="
				+ solution + ", question=" + question + ", answer=" + answer + ", notSuccess=" + notSuccess + ", score="
				+ score + ", scoreCount=" + scoreCount + ", dueDate=" + dueDate + ", point=" + point + ", userName="
				+ userName + ", action=" + action + ", title=" + title + ", avgScore=" + avgScore + ", userDept=" + userDept + "]";
	}
}