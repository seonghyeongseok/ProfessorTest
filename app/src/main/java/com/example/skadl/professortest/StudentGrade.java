package com.example.skadl.professortest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentGrade extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private Button note, retest;
    private String sessionNum, profNum, studentName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_record);

        Intent getInfo = getIntent();

        sessionNum = getInfo.getStringExtra("session_num");
        profNum = getInfo.getStringExtra("professor_name");
        studentName = getInfo.getStringExtra("student_name");


        //  학생 정보 받아오기
        name = (TextView)findViewById(R.id.studentName);

        name.setText(studentName);

        note = (Button)findViewById(R.id.note);
        note.setOnClickListener(this);

        retest = (Button)findViewById(R.id.retest);
        retest.setOnClickListener(this);

        //  학생별 날짜 퀴즈명 점수 오답노트 재시험응시결과 받아오기
    }

    public void onClick(View view) {
        //  학생 이름 옆의 버튼 클릭 시 해당 그룹의 그룹원 목록출력
        /*if(view.getId() == R.id.note){
            Intent intent = new Intent(studentRecord.this, Note.class);
            startActivity(intent);
        }else if(view.getId() == R.id.retest){
            Intent intent = new Intent(studentRecord.this, Retest.class);
            startActivity(intent);
        }*/
        //  오답노트 미제출 경우 제출일 경우 제출 텍스트 클릭 시 해당 오답노트로 이동

        //  재시험 완료일 경우 완료 텍스트 클릭 시 해당 재시험 결과 보여주기 창으로 이동
    }
}
