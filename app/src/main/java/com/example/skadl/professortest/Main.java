package com.example.skadl.professortest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private Button createGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGroup = (Button)findViewById(R.id.createGroup);
        createGroup.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view.getId() == R.id.createGroup){
            createGroupDialog();
        }
    }

    private void createGroupDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        ImageButton groupMainImage = new ImageButton(Main.this);
        final TextView groupNameText = new TextView(Main.this);
        final TextView groupPINText = new TextView(Main.this);

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
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
    }
}
