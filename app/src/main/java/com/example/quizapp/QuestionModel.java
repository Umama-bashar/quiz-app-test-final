package com.example.quizapp;

public class QuestionModel {
    public QuestionModel(String questionString,String answer)
    {
        QuestionString = questionString;
        Answer=answer;

    }
    public String getQuestionstring(){return  QuestionString;}
    public void  setQuestionString(String questionString){QuestionString =questionString;}
    public String getAnswer() { return Answer;}
    public void setAnswer(String answer){ Answer=answer;}

    private String QuestionString;
    private String Answer;

}
