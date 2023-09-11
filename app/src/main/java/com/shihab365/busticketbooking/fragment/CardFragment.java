package com.shihab365.busticketbooking.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shihab365.busticketbooking.CardFormActivity;
import com.shihab365.busticketbooking.R;

public class CardFragment extends Fragment {

    CardView cardMaster, cardVisa, cardAmex, cardPaypal, cardUnion, cardJCB;
    String strCardType;
    String strFrom, strTo, strTime, strPrice, strPass, strSeat, strDate, strEmail, strName;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);

        cardMaster = v.findViewById(R.id.cardBtnMaster_ID);
        cardVisa = v.findViewById(R.id.cardBtnVisa_ID);
        cardAmex = v.findViewById(R.id.cardBtnAmex_ID);
        cardPaypal = v.findViewById(R.id.cardBtnPaypal_ID);
        cardUnion = v.findViewById(R.id.cardBtnUnipay_ID);
        cardJCB = v.findViewById(R.id.cardBtnJCB_ID);
        intent = getActivity().getIntent();

        strFrom = intent.getStringExtra("pick");
        strTo = intent.getStringExtra("drop");
        strTime = intent.getStringExtra("time");
        strPrice = intent.getStringExtra("price");
        strPass = intent.getStringExtra("pass");
        strSeat = intent.getStringExtra("seat");
        strDate = intent.getStringExtra("date");
        strEmail = intent.getStringExtra("email");
        strName = intent.getStringExtra("name");



        cardMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCardType = "master";
                cardForm();
            }
        });

        cardVisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCardType = "visa";
                cardForm();
            }
        });

        cardAmex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCardType = "amex";
                cardForm();
            }
        });

        cardPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCardType = "paypal";
                cardForm();
            }
        });

        cardUnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCardType = "union";
                cardForm();
            }
        });

        cardJCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strCardType = "jcb";
                cardForm();
            }
        });

        return v;
    }

    private void cardForm() {
        if(strCardType.matches("master")){
            Intent intent = new Intent(getActivity(), CardFormActivity.class);
            intent.putExtra("key", strCardType);
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
        if(strCardType.matches("visa")){
            Intent intent = new Intent(getActivity(), CardFormActivity.class);
            intent.putExtra("key", strCardType);
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
        if(strCardType.matches("amex")){
            Intent intent = new Intent(getActivity(), CardFormActivity.class);
            intent.putExtra("key", strCardType);
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
        if(strCardType.matches("paypal")){
            Intent intent = new Intent(getActivity(), CardFormActivity.class);
            intent.putExtra("key", strCardType);
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
        if(strCardType.matches("union")){
            Intent intent = new Intent(getActivity(), CardFormActivity.class);
            intent.putExtra("key", strCardType);
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
        if(strCardType.matches("jcb")){
            Intent intent = new Intent(getActivity(), CardFormActivity.class);
            intent.putExtra("key", strCardType);
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
    }
}