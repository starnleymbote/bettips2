package com.nanocomputing.bettips.fragments;

/**
 * Created by Tonui on 3/15/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nanocomputing.bettips.R;
import com.nanocomputing.bettips.models.tips;
import com.nanocomputing.bettips.tipsAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DailyTips extends Fragment {
    ArrayList<tips> tips = new ArrayList<>();
    private RecyclerView recyclerView;
    private Context context;
    TextView date;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_bet_tips,container,false);
        context = getActivity();
        recyclerView = view.findViewById(R.id.recyclerView);
        date = view.findViewById(R.id.date);
        getDailyTips();
        return view;
    }

    private void getDailyTips(){
        //set todays date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd yyyy");
        String today = simpleDateFormat.format(Calendar.getInstance().getTime());
        date.setText(today);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(context,
                        LinearLayoutManager.HORIZONTAL));
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        List<tips> tipsList = new ArrayList<>();
        tipsList.add(new tips("12:15 AM","ATLETICO MINEIRO ","DANUBIO FC","1.36","10.24"));
        tipsList.add(new tips("02:30 AM","BARCELONA SC","DEFENSOR SPORTING","1.39","8.24"));
        // tipsList.add(new tips("04:05 PM","ENVIGADO FC","AGUARES DE CORDOBA ","1.24","1.56"));
        // tipsList.add(new tips("12:00AM","CD MARATHON","CD VIDA","1.54","6.12"));

        recyclerView.setAdapter(new tipsAdapter(tipsList,context) );
    }
}
