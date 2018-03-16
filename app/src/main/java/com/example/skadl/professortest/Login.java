package com.example.skadl.professortest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText username, password;
    private Button login, join;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        join = (Button)findViewById(R.id.join);
        join.setOnClickListener(this);
    }

    public void onClick(View view) {

        Intent intent;

        if(view.getId() == R.id.login){

            //  로그인 확인,
            //  로그인 창
            intent = new Intent(Login.this, Main.class);
            startActivity(intent);

        }else if(view.getId() == R.id.join){
            //  회원 가입 창
            intent = new Intent(Login.this, Join.class);
            startActivity(intent);

        }
    }
}