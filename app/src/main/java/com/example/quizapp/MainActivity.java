package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView questionlabel, questioncountlabel, scorelabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<QuestionModel> questionModelArrayList;
    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questioncountlabel = findViewById(R.id.noQuestion);
        questionlabel = findViewById(R.id.question);
        scorelabel = findViewById(R.id.score);


        answerEdt = findViewById(R.id.answer);
        progressBar = findViewById(R.id.progess);

        questionModelArrayList = new ArrayList<>();
        setUpQuestion();
        setData();
        submitButton= (Button)findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();

            }
        });

    }

    public void checkAnswer() {
        String answerString = answerEdt.getText().toString().trim();
        if (answerString.equalsIgnoreCase(questionModelArrayList.get(currentPosition).getAnswer())) {
            numberOfCorrectAnswer++;
            Log.e("answer", "right");
            currentPosition++;



        } else {


            Log.e("answer", "wrong");

            currentPosition++;
            setData();

        }
        int x = ((currentPosition + 1) * 100) / questionModelArrayList.size();
        progressBar.setProgress(x);

    }

    public void setUpQuestion() {

        questionModelArrayList.add(new QuestionModel("what is 9*9?", "81"));
        questionModelArrayList.add(new QuestionModel("what is 5*5?", "25"));
        questionModelArrayList.add(new QuestionModel("what is 5+5 ?", "10"));
        questionModelArrayList.add(new QuestionModel("what is 25*5?", "125"));
        questionModelArrayList.add(new QuestionModel("what is 50*10?", "500"));

    }

    public void setData() {
        questionlabel.setText(questionModelArrayList.get(currentPosition).getQuestionstring());
        questioncountlabel.setText("Question No :" + (currentPosition + 1));
        scorelabel.setText(("Score:" + numberOfCorrectAnswer + "/" + questionModelArrayList.size()));


    }
}