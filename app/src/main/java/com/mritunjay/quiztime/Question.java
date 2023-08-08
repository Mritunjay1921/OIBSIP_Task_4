package com.mritunjay.quiztime;

import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, ArrayList<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

