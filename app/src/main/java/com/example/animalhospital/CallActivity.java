package com.example.animalhospital;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    EditText edit_name, edit_phone, edit_consulting;
    CheckBox check_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        edit_phone = findViewById(R.id.edit_phone);
        edit_name = findViewById(R.id.edit_name);
        edit_consulting = findViewById(R.id.edit_consulting);
        check_agree = findViewById(R.id.check_agree);

        //전화걸기
        findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:82-02-3016-0270") );
                startActivity(intent);
            }
        });

        //메세지 보내기
        findViewById(R.id.btn_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_name, str_phone, str_consulting ;
                str_name = edit_name.getText().toString().trim();
                str_phone = edit_phone.getText().toString().trim();
                str_consulting = edit_phone.getText().toString().trim();
                if(str_name.length()==0 || str_phone.length()==0 || str_consulting.length()==0){

                    Toast.makeText(CallActivity.this,
                            "이름,전화번호,내용을 모두 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                //메세지
                if(check_agree.isChecked()){
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-1234-5678"));

                    String message = "이름:"+str_name + "\n연락처:" + str_phone + "\n" + str_consulting;
                    intent.putExtra("sms_body",message  );
                    startActivity(intent);
                }else{
                    Toast.makeText(CallActivity.this,
                            "개인정보 동의 방침 확인", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}