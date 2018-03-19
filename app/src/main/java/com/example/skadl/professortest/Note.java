package com.example.skadl.professortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Note extends AppCompatActivity{

    private TextView studentName, quizName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);

        studentName = (TextView)findViewById(R.id.studentName);
        String sName = "성형석";
        studentName.setText(sName);

        quizName = (TextView)findViewById(R.id.quizName);
        String qName = "4주차 2일자 단어";
        quizName.setText(qName + "레이스 오답노트");

        //  학생 - 해당 일자를 기준으로 오답노트 정보 가져오기
    }

}
