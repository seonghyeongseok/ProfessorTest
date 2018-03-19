package com.example.skadl.professortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class FeedbackList extends AppCompatActivity implements View.OnClickListener{

    private TextView groupName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_list);

        groupName = (TextView)findViewById(R.id.groupName);
        String gName = "3학년C반";
        groupName.setText(gName);


        //  학생 질문 리스트
        //  게시판 참고
        //  최근 1주, 최근 한달 기준으로
    }

    @Override
    public void onClick(View view) {

    }
}
