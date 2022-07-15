package com.taruns.androidassignmentfampay.ui.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.taruns.androidassignmentfampay.R;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;


public class HomeFragment extends Fragment {


    private HomeViewModel viewModel;


    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.init();
        viewModel.getCardGroupsLiveData().observe(this, cardResponseModel -> {
            if(cardResponseModel!=null){
                Log.d("Response", cardResponseModel.getCard_groups().get(0).getName());
            }else{
                Log.d("Response", "Null Response");
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        EpoxyRecyclerView recyclerView = view.findViewById(R.id.home_recycler);
        recyclerView.buildModelsWith(epoxyController -> {
            
        });


        return view;
    }
}