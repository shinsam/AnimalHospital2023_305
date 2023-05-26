package com.example.animalhospital;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userid, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userid  = findViewById(R.id.userid);
        passwd = findViewById(R.id.passwd);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //////
                //Toast.makeText(MainActivity.this, "로그인 버튼", Toast.LENGTH_SHORT).show();
                //아이디 : 6자리 (roboth)
                //패스워드 : 10자리 이상 (1234567890)
                String str_userid = userid.getText().toString();
                String str_passwd = passwd.getText().toString();

                if(str_userid.length() !=6 ){
                    Toast.makeText(MainActivity.this, "아이디는 6자입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }else if( str_passwd.length() < 10){
                    Toast.makeText(MainActivity.this, "패스워드는 10자리 이상입니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if( !str_userid.equals("roboth") ){
                    Toast.makeText(MainActivity.this, "잘못된 아이디입니다.", Toast.LENGTH_SHORT).show();
                }else if(!str_passwd.equals("1234567890")){
                    Toast.makeText(MainActivity.this, "비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, str_userid+"님 환영합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_info:
                Log.d("TEST" , "btn_info 클릭");
                intent = new Intent(MainActivity.this , InfoActivity.class);
                intent.putExtra("TITLE" , "안녕하세요 저희 병원을....") ;
                startActivity(intent);
                break;
            case R.id.btn_guide:
                Log.d("TEST" , "btn_guide 클릭");
                intent = new Intent(MainActivity.this , GuideActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_call:
                Log.d("TEST" , "btn_call 클릭");
                intent = new Intent(MainActivity.this , CallActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_shop:
                Log.d("TEST" , "btn_shop 클릭");
                intent = new Intent(MainActivity.this , ShopActivity.class);
                startActivity(intent);

                break;
        }
    }
}