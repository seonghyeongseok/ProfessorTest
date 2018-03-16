package com.example.skadl.professortest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by skadl on 2018-03-15.
 */

public class GroupMain extends AppCompatActivity implements View.OnClickListener {

    private TextView groupNameView, numOfStd;
    private Button deleteStudent, groupGrade;
    private ImageButton addStudent;

    //  그룹 명, 그룹원, 그룹원 수
    //  그룹원마다 클릭리스너
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  클릭한 그룹이름 가져와서 쿼리
        String groupName = "3학년 A반";
        groupNameView = (TextView)findViewById(R.id.groupName);
        groupNameView.setText(groupName);

        int numberOfStudent = 1;
        String text = "총 인원 : " + numberOfStudent + "명";
        numOfStd  = (TextView)findViewById(R.id.numOfStd);
        numOfStd.setText(text);

        groupGrade = (Button)findViewById(R.id.createGroup);
        groupGrade.setOnClickListener(this);

        deleteStudent = (Button)findViewById(R.id.delete);
        deleteStudent.setOnClickListener(this);

        addStudent = (ImageButton)findViewById(R.id.addStudent);
        addStudent.setOnClickListener(this);
    }

    public void onClick(View view) {

        if(view.getId() == R.id.delete){
            //  그룹원 삭제 클릭 시 학생 프로필에 클릭창 띄우기
            deleteStudent.setText("그만하기");

        }else if(view.getId() == R.id.addStudent){
            //  +이미지 버튼, 그룹원 수동 추가
            addStudentDialog();

        }else if(false){
            //  학생 프로필 클릭 창 클릭의 경우
            String name = "성형석";
            deleteStudentDialog(name);

        }else if(view.getId() == R.id.createGroup){
            //  성적 확인 창으로 이동

        }
    }

    private void deleteStudentDialog(String stdName){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        String alertMessage = "정말로 '" + stdName + "' 학생을 그룹에서 삭제시키시겠습니까?";
        alert.setTitle("알림");
        alert.setMessage(alertMessage);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                //  그룹에서 학생 삭제
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    private void addStudentDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //  PIN번호 받아오기
        //  학생 정보 이름, ID 받아오기

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                //  체크 박스 정보 받아와서 초대
            }
        });

        alert.show();
    }
}