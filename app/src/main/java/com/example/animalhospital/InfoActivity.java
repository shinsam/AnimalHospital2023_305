package com.example.animalhospital;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity  {

    int imgs[] = {R.drawable.info1, R.drawable.info2, R.drawable.info3,
            R.drawable.info4,R.drawable.info5};
    int imgno = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent() ;
        String str_title = intent.getStringExtra("TITLE");
        Log.d("TEST 넘겨진 값" , str_title);
        ((TextView)findViewById(R.id.txt_info)).setText(str_title);
        //뒤로가기 버튼
        findViewById(R.id.btn_info_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //이미지를 클릭하면 다음 이미지로 이동
        ImageView imageView = findViewById(R.id.img_info);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //그림 교체
                imageView.setImageResource(imgs[++imgno % imgs.length] );
            }
        });

    }


}