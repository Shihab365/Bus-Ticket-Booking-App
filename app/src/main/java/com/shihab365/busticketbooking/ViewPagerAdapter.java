package com.shihab365.busticketbooking;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.shihab365.busticketbooking.fragment.CardFragment;
import com.shihab365.busticketbooking.fragment.MobileFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new CardFragment();
            case 1:
                return new MobileFragment();
            default:
                return new CardFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
