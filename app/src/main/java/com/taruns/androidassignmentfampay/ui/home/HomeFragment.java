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

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.taruns.androidassignmentfampay.Hc1BindingModel_;
import com.taruns.androidassignmentfampay.Hc3BindingModel_;
import com.taruns.androidassignmentfampay.Hc5BindingModel_;
import com.taruns.androidassignmentfampay.Hc6BindingModel_;
import com.taruns.androidassignmentfampay.Hc9BindingModel_;
import com.taruns.androidassignmentfampay.R;
import com.taruns.androidassignmentfampay.data.remote_models.Card;
import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class HomeFragment extends Fragment {


    private HomeViewModel viewModel;
    private EpoxyRecyclerView recyclerView;
    private List<CardGroup> cardGroups;




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
                cardGroups = cardResponseModel.getCard_groups();
                updateUI(cardGroups);
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


        recyclerView = view.findViewById(R.id.home_recycler);



        return view;
    }

    private void updateUI(List<CardGroup> cardGroups) {

        recyclerView.withModels(epoxyController -> {

            epoxyController.add(new Hc3BindingModel_().id(0).card(cardGroups.get(0).getCards().get(0)));
            epoxyController.add(new Hc6BindingModel_().id(0).card(cardGroups.get(1).getCards().get(0)));
            epoxyController.add(new Hc5BindingModel_().id(0).card(cardGroups.get(2).getCards().get(0)));
            epoxyController.add(new Hc9BindingModel_().id(0).card(cardGroups.get(4).getCards().get(0)));
            epoxyController.add(new Hc1BindingModel_().id(0).card(cardGroups.get(5).getCards().get(0)));





            return null;
        });

    }







}