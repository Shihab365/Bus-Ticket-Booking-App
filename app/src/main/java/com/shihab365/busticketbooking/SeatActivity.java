package com.shihab365.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class SeatActivity extends AppCompatActivity {

    Button btnCheckout;
    GridView gridView;
    TextView tvSeatNo, tvFrom, tvTo, tvTime, tvPrice, tvPass;
    int[] seatBooking = {R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,
            R.drawable.seat_av,R.drawable.seat_bo,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_bo,
            R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,
            R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_bo,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_bo,R.drawable.seat_av,R.drawable.seat_av,
            R.drawable.seat_bo,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,
            R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_av,R.drawable.seat_bo,R.drawable.seat_av,};
    String[] strSeatNo;
    String strFromS, strToS, strTimeS, strPriceS, strPassS, strSeat, strDate, strEmail, strName;
    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intent = getIntent();
        strFromS = intent.getStringExtra("pick");
        strToS = intent.getStringExtra("drop");
        strTimeS = intent.getStringExtra("time");
        strPriceS = intent.getStringExtra("price");
        strPassS = intent.getStringExtra("pass");
        strDate = intent.getStringExtra("date");
        strEmail = intent.getStringExtra("email");
        strName = intent.getStringExtra("name");

        gridView = findViewById(R.id.gridSeatID);
        tvSeatNo = findViewById(R.id.tv_tripSeatNoID);
        strSeatNo = getResources().getStringArray(R.array.seat);
        btnCheckout = findViewById(R.id.btnCheckoutID);
        tvFrom = findViewById(R.id.tvSeat_fromID);
        tvTo = findViewById(R.id.tvSeat_toID);
        tvTime = findViewById(R.id.tvSeat_timeID);
        tvPrice = findViewById(R.id.tvSeat_priceID);
        tvPass = findViewById(R.id.tvSeat_passID);

        tvFrom.setText(strFromS);
        tvTo.setText(strToS);
        tvTime.setText(strTimeS);
        tvPrice.setText(strPriceS);
        tvPass.setText(strPassS);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeatActivity.this, PaymentActivity.class);
                intent.putExtra("pick", strFromS);
                intent.putExtra("drop", strToS);
                intent.putExtra("time", strTimeS);
                intent.putExtra("price", strPriceS);
                intent.putExtra("pass", strPassS);
                intent.putExtra("seat", strSeat);
                intent.putExtra("date", strDate);
                intent.putExtra("email", strEmail);
                intent.putExtra("name", strName);
                startActivity(intent);
            }
        });

        SeatAdapter seatAdapter = new SeatAdapter(this, seatBooking, strSeatNo);
        gridView.setAdapter(seatAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                strSeat = strSeatNo[position];
                tvSeatNo.setText(strSeat);
            }
        });

    }
}