package com.shihab365.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DownloadActivity extends AppCompatActivity {

    String strFrom, strTo, strTime, strPrice, strPass, strSeat, strDate, strEmail, strName;
    Intent intent;
    TextView tvFrom, tvTo, tvDate, tvTime, tvPass, tvSeat;
    Button btnDown;
    FirebaseFirestore firebaseFirestore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        firebaseFirestore = FirebaseFirestore.getInstance();

        tvFrom = findViewById(R.id.dndTvFromID);
        tvTo = findViewById(R.id.dndTvToID);
        tvDate = findViewById(R.id.dndTvDateID);
        tvTime = findViewById(R.id.dndTvTimeID);
        tvPass = findViewById(R.id.dndTvPassID);
        tvSeat = findViewById(R.id.dndTvSeatID);
        btnDown = findViewById(R.id.btnDownload_ID);

        intent = getIntent();
        strFrom = intent.getStringExtra("pick");
        strTo = intent.getStringExtra("drop");
        strTime = intent.getStringExtra("time");
        strPrice = intent.getStringExtra("price");
        strPass = intent.getStringExtra("pass");
        strSeat = intent.getStringExtra("seat");
        strDate = intent.getStringExtra("date");
        strEmail = intent.getStringExtra("email");
        strName = intent.getStringExtra("name");

        tvFrom.setText(strFrom);
        tvTo.setText(strTo);
        tvDate.setText(strDate);
        tvTime.setText(strTime);
        tvPass.setText(strPass);
        tvSeat.setText(strSeat);

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> bookingData = new HashMap<>();
                bookingData.put("From", strFrom );
                bookingData.put("To", strTo );
                bookingData.put("Date", strDate );
                bookingData.put("Time", strTime );
                bookingData.put("Passenger", strPass );
                bookingData.put("Seat", strSeat );
                bookingData.put("Price", strPrice );
                bookingData.put("Name", strName );

                firebaseFirestore.collection("BookingData").document(strEmail).set(bookingData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        ShowDialog();
                    }
                });
            }
        });


    }

    private void ShowDialog() {
        Rect displayRectangle = new Rect();
        Window window = getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        final AlertDialog.Builder alert = new AlertDialog.Builder(DownloadActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog, null);
        mView.setMinimumWidth((int)(displayRectangle.width() * 0.9f));
        mView.setMinimumHeight((int)(displayRectangle.height() * 0.9f));
        alert.setView(mView);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCancelable(false);

        mView.findViewById(R.id.btnBackID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DownloadActivity.this, SearchActivity.class);
                intent1.putExtra("email", strEmail);
                startActivity(intent1);
            }
        });
        alertDialog.show();
    }
}