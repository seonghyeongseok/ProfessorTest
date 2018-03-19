package com.example.skadl.professortest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GroupRecord extends AppCompatActivity implements View.OnClickListener {

    private TextView groupName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_record);

        //  그룹 정보 받아오기

        groupName = (TextView)findViewById(R.id.groupName);
        String name = "3학년C반";
        groupName.setText(name);
        //  그룹에 속한 그룹원 정보
    }

    public void onClick(View view) {
        //  그룹 이름 옆버튼은 해당 교수가 담당하는 그룹 리스트 출력

        //  학생 리스트를 가지고 오고 학생 정보 라인을 클릭 시 해당 학생 성적확인으로 이동
    }
}
