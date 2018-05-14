package com.example.skadl.professortest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupInfo extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private String sessionNum, profNum, groupName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_info);

        Intent getInfo = getIntent();

        sessionNum = getInfo.getStringExtra("session_num");
        profNum = getInfo.getStringExtra("professor_num");
        groupName = getInfo.getStringExtra("group_name");

        name = (TextView)findViewById(R.id.groupName);
        name.setText(groupName);

        String studentInfo[][] = {{"형석", "100"}, {"준수", "99"}, {"재형", "98"}, {"기혁", "97"},
                {"다연", "96"}, {"경임", "95"}, {"형탁", "94"}, {"형래", "93"}};

        ArrayList<StudentListItem> studentList = new ArrayList<>();

        for(int i = 0 ; i < studentInfo.length ; i++)
        {
            StudentListItem list = new StudentListItem();

            list.studentName = studentInfo[i][0];
            list.studentGrade = studentInfo[i][1];
            studentList.add(list);
            list.onClickListener = this;

        }

        ListView listView = (ListView)findViewById(R.id.student_list);

        StudentListAdapter adapter = new StudentListAdapter(studentList);
        listView.setAdapter(adapter);

    }

    public void onClick(View view) {

        View parentView = (View)view.getParent();
        TextView studentInfo = (TextView)parentView.findViewById(R.id.student_name);
        //String position = (String)parentView.getTag();

        Intent intent = new Intent(GroupInfo.this, StudentGrade.class);

        intent.putExtra("student_name", studentInfo.getText().toString());
        intent.putExtra("session_num", sessionNum);
        intent.putExtra("professor_name", profNum);
        startActivity(intent);
    }

}
