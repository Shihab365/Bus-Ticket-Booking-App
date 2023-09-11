package com.shihab365.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class CardFormActivity extends AppCompatActivity {

    Button btnPayDone;
    ImageView ivCard;
    Intent intent;
    String strCardKey;
    String strFrom, strTo, strTime, strPrice, strPass, strSeat, strDate, strEmail, strName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_form);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnPayDone = findViewById(R.id.btnPayDone_ID);
        ivCard = findViewById(R.id.imgView_CardID);

        intent = getIntent();
        strCardKey = intent.getStringExtra("key");
        strFrom = intent.getStringExtra("pick");
        strTo = intent.getStringExtra("drop");
        strTime = intent.getStringExtra("time");
        strPrice = intent.getStringExtra("price");
        strPass = intent.getStringExtra("pass");
        strSeat = intent.getStringExtra("seat");
        strDate = intent.getStringExtra("date");
        strEmail = intent.getStringExtra("email");
        strName = intent.getStringExtra("name");

        btnPayDone.setText("Pay "+strPrice);

        if(strCardKey.matches("master")){
            ivCard.setImageResource(R.drawable.master_sqr);
        }
        if(strCardKey.matches("visa")){
            ivCard.setImageResource(R.drawable.visa_sqr);
        }
        if(strCardKey.matches("amex")){
            ivCard.setImageResource(R.drawable.amex_sqr);
        }
        if(strCardKey.matches("paypal")){
            ivCard.setImageResource(R.drawable.paypal_sqr);
        }
        if(strCardKey.matches("union")){
            ivCard.setImageResource(R.drawable.uni_sqr);
        }
        if(strCardKey.matches("jcb")){
            ivCard.setImageResource(R.drawable.jcb_sqr);
        }



        btnPayDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardFormActivity.this, DownloadActivity.class);
                intent.putExtra("pick", strFrom);
                intent.putExtra("drop", strTo);
                intent.putExtra("time", strTime);
                intent.putExtra("price", strPrice);
                intent.putExtra("pass", strPass);
                intent.putExtra("seat", strSeat);
                intent.putExtra("date", strDate);
                intent.putExtra("email", strEmail);
                intent.putExtra("name", strName);
                startActivity(intent);
            }
        });
    }
}