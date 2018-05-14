package com.example.skadl.professortest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupList extends AppCompatActivity implements View.OnClickListener{

    private String sessionNum, profNum;
   // LineChart lineChart;

    //  그룹 명, 그룹원, 그룹원 수
    //  그룹원마다 클릭리스너
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);

        Intent getInfo = getIntent();

        sessionNum = getInfo.getStringExtra("session_num");
        profNum = getInfo.getStringExtra("professor_name");

        ListView listview = (ListView) findViewById(R.id.group_list);

        Log.d("asdf", listview.toString());

        String[] className = {"1학년 A반", "1학년 B반", "1학년 C반",
                "2학년 A반", "2학년 B반", "2학년 C반"};

        ArrayList<GroupListItem> classList = new ArrayList<>();

        for(int i = 0 ; i < className.length ; i++)
        {

            GroupListItem list = new GroupListItem();
            list.className = className[i];
            classList.add(list);
            list.onClickListener = this;

        }

        GroupListAdapter adapter = new GroupListAdapter(classList);
        listview.setAdapter(adapter);


    }



    @Override
    public void onClick(View view) {

        View parentView = (View)view.getParent();
        TextView className = (TextView)parentView.findViewById(R.id.class_name);
        //String position = (String)parentView.getTag();

        Intent intent = new Intent(GroupList.this, GroupInfo.class);

        intent.putExtra("group_name", className.getText().toString());
        intent.putExtra("session_num", sessionNum);
        intent.putExtra("professor_name", profNum);
        startActivity(intent);
        /*AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog);

        String strMsg = "선택한 아이템의 position 은 "+position+" 입니다.\nTitle 텍스트 :" + className.getText();
        oDialog.setMessage(strMsg)
                .setPositiveButton("확인", null)
                .setCancelable(false) // 백버튼으로 팝업창이 닫히지 않도록 한다.
                .show();*/

    }

    /*private void deleteStudentDialog(String stdName){
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
    }*/

}