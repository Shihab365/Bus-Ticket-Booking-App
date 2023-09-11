package com.shihab365.busticketbooking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Booking extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView tvBookFrom, tvBookTo, tvBookDate, tvBookPass;
    ArrayList<trip> arrayList;
    tripAdapter adapter;
    FirebaseFirestore db;

    String strGetFrom, strGetTo, strGetDate, strGetPass, strGetEmail, strGetName;
    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intent = getIntent();
        strGetFrom = intent.getStringExtra("from");
        strGetTo = intent.getStringExtra("to");
        strGetDate = intent.getStringExtra("date");
        strGetPass = intent.getStringExtra("tPass");
        strGetEmail = intent.getStringExtra("email");
        strGetName = intent.getStringExtra("name");

        recyclerView = findViewById(R.id.recy_tripID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tvBookFrom = findViewById(R.id.tv_bookingFromID);
        tvBookTo = findViewById(R.id.tv_bookingToID);
        tvBookDate = findViewById(R.id.tv_bookingDateID);
        tvBookPass = findViewById(R.id.tv_bookingPassID);

        tvBookFrom.setText(strGetFrom);
        tvBookTo.setText(strGetTo);
        tvBookDate.setText(strGetDate);
        tvBookPass.setText(strGetPass);

        db = FirebaseFirestore.getInstance();
        arrayList = new ArrayList<trip>();
        adapter = new tripAdapter(Booking.this, arrayList, tvBookPass, tvBookDate, strGetEmail, strGetName);

        recyclerView.setAdapter(adapter);

        if(strGetFrom.matches("DHAKA") && strGetTo.matches("SYLHET")){
            DhkSyl();
        }else if(strGetFrom.matches("KHULNA") && strGetTo.matches("RAJSHAHI")){
            KhuRaj();
        }

    }

    private void DhkSyl() {
        db.collection("DhkSyl").orderBy("rTime", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentChange dc: value.getDocumentChanges()){
                    if(dc.getType()== DocumentChange.Type.ADDED){
                        arrayList.add(dc.getDocument().toObject(trip.class));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void KhuRaj() {
        db.collection("KhuRaj").orderBy("rTime", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for(DocumentChange dc: value.getDocumentChanges()){
                    if(dc.getType()== DocumentChange.Type.ADDED){
                        arrayList.add(dc.getDocument().toObject(trip.class));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}