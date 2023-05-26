package com.example.animalhospital;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_product_main;
    EditText edit_count;
    TextView txt_price, txt_delivery, txt_pay;
    CheckBox chk_agree;

    //계산과 관련된 변수
    int selected_price; //단가
    int selected_count; //수량


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        img_product_main = findViewById(R.id.img_product_main);
        edit_count = findViewById(R.id.edit_count);
        txt_price = findViewById(R.id.txt_price);
        txt_delivery = findViewById(R.id.txt_delivery);
        txt_pay = findViewById(R.id.txt_pay);
        chk_agree = findViewById(R.id.chk_agree);

        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio1:
                selected_price = 1500;
                img_product_main.setImageResource(R.drawable.product1);
                break;
            case R.id.radio2:
                selected_price = 2000;
                img_product_main.setImageResource(R.drawable.product2);
                break;
            case R.id.radio3:
                selected_price = 3000;
                img_product_main.setImageResource(R.drawable.product3);
                break;
            case R.id.btn_minus:
                selected_count = Integer.parseInt(edit_count.getText().toString());
                if(selected_count<=1){
                    Toast.makeText(this, "최소 수량은 1개입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    edit_count.setText(String.valueOf(--selected_count));
                }
                break;
            case R.id.btn_plus:
                selected_count = Integer.parseInt(edit_count.getText().toString());
                if(selected_count>=5){
                    Toast.makeText(this, "최소 수량은 1개입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    edit_count.setText(String.valueOf(++selected_count));
                }

                break;
            case R.id.btn_pay:
                break;

        }
    }
}