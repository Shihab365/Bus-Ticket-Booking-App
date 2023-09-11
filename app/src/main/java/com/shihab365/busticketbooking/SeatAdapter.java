package com.shihab365.busticketbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SeatAdapter extends BaseAdapter {

    Context context;
    int[] seatBooking;
    String[] strSeatNo;
    LayoutInflater inflater;

    public SeatAdapter(Context context, int[] seatBooking, String[] strSeatNo) {
        this.context = context;
        this.seatBooking = seatBooking;
        this.strSeatNo = strSeatNo;
    }

    @Override
    public int getCount() {
        return seatBooking.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =  inflater.inflate(R.layout.seat_view,parent,false);
        }

        ImageView btnSeat = convertView.findViewById(R.id.imgButton_seatID);
        btnSeat.setImageResource(seatBooking[position]);

        return convertView;
    }
}
