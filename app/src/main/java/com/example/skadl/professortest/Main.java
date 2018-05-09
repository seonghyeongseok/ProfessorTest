package com.example.skadl.professortest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private ImageButton record, feedback;
    private String sessionNum, profNum;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor_main);
/*
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/

        Intent getInfo = getIntent();

        sessionNum = getInfo.getStringExtra("session_num");
        profNum = getInfo.getStringExtra("professor_name");

        record = (ImageButton) findViewById(R.id.record);
        record.setOnClickListener(this);

        feedback = (ImageButton) findViewById(R.id.feed_back);
        feedback.setOnClickListener(this);
    }

    public void onClick(View view) {

        Intent intent;


        if(view.getId() == R.id.record)
        {

            intent = new Intent(Main.this, GroupList.class);
            intent.putExtra("session_num", sessionNum);
            intent.putExtra("professor_name", profNum);
            startActivity(intent);

        }
        else if(view.getId() == R.id.feed_back)
        {

            intent = new Intent(Main.this, FeedbackList.class);
            intent.putExtra("session_num", sessionNum);
            intent.putExtra("professor_name", profNum);
            startActivity(intent);

        }
    }

    /*private void createGroupDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        ImageButton groupMainImage = new ImageButton(Main.this);
        final TextView groupNameText = new TextView(Main.this);
        final TextView groupPINText = new TextView(Main.this);

        alert.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            //  그룹 생성
            public void onClick(DialogInterface dialogInterface, int i) {

                String groupName = groupNameText.getText().toString();
                String groupPIN = groupPINText.getText().toString();
                //  이미지도 함께 받아서 
                //  그룹 생성DB저장
            }
        });

        alert.show();
    }*/
}