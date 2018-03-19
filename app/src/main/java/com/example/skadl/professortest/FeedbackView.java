package com.example.skadl.professortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class FeedbackView extends AppCompatActivity {

    private Button write;
    private TextView comment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_view);

        //  해당 글 불러오기~
        //  댓글 기능 작성
    }
    /*
    private void (){
        댓글 기능
    }*/

    private void fileSend(){
        //  학생 피드백에 파일을 추가할 수 있도록
        //  파일을 추가할 경우 해당 학생에게 파일이 넘어간다.
    }
}
