package com.example.skadl.professortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class studentRecord extends AppCompatActivity implements View.OnClickListener {

    private TextView groupName, studentName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_record);

        //  반 정보
        groupName = (TextView)findViewById(R.id.groupName);
        String Gname = "3학년C반";
        groupName.setText(Gname);

        //  학생 정보 받아오기
        studentName = (TextView)findViewById(R.id.studentName);
        String Sname = "성형석";
        studentName.setText(Sname);

        //  학생별 날짜 퀴즈명 점수 오답노트 재시험응시결과 받아오기
    }

    public void onClick(View view) {
        //  학생 이름 옆의 버튼 클릭 시 해당 그룹의 그룹원 목록출력

        //  오답노트 미제출 경우 제출일 경우 제출 텍스트 클릭 시 해당 오답노트로 이동

        //  재시험 완료일 경우 완료 텍스트 클릭 시 해당 재시험 결과 보여주기 창으로 이동
    }
}
