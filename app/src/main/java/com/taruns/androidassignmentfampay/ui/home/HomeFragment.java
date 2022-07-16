package com.taruns.androidassignmentfampay.ui.home;

import android.animation.ObjectAnimator;
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
import android.widget.Toast;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.CarouselModel_;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.taruns.androidassignmentfampay.Hc1BindingModel_;
import com.taruns.androidassignmentfampay.Hc3BindingModel_;
import com.taruns.androidassignmentfampay.Hc5BindingModel_;
import com.taruns.androidassignmentfampay.Hc6BindingModel_;
import com.taruns.androidassignmentfampay.Hc9BindingModel_;
import com.taruns.androidassignmentfampay.R;
import com.taruns.androidassignmentfampay.data.remote_models.Card;
import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;

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

    private Boolean opened = false;




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

        viewModel.getBrowserIntentLiveData().observe(this, this::startActivity);

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


            for (CardGroup cardGroup: cardGroups) {

                switch (cardGroup.getDesign_type()){
                    case "HC3":{
                        List<Hc3BindingModel_> bindingModel_s = new ArrayList<>();
                        for (Card card: cardGroup.getCards()) {
                            bindingModel_s.add(new Hc3BindingModel_().id(0).card(card).viewModel(viewModel));
                        }
                        CarouselModel_ carouselModel_ = new CarouselModel_().id(cardGroup.getId()).models(bindingModel_s);
                        epoxyController.add(carouselModel_);
                        break;
                    }
                    case "HC5":{
                        List<Hc5BindingModel_> bindingModel_s = new ArrayList<>();
                        for (Card card: cardGroup.getCards()) {
                            bindingModel_s.add(new Hc5BindingModel_().id(0).card(card).viewModel(viewModel));
                        }
                        CarouselModel_ carouselModel_ = new CarouselModel_().id(cardGroup.getId()).models(bindingModel_s);
                        epoxyController.add(carouselModel_);
                        break;
                    }
                    case "HC6":{
                        List<Hc6BindingModel_> bindingModel_s = new ArrayList<>();
                        for (Card card: cardGroup.getCards()) {
                            bindingModel_s.add(new Hc6BindingModel_().id(0).card(card).viewModel(viewModel));
                        }
                        CarouselModel_ carouselModel_ = new CarouselModel_().id(cardGroup.getId()).models(bindingModel_s);
                        epoxyController.add(carouselModel_);
                        break;
                    }
                    case "HC9":{

                        List<Hc9BindingModel_> bindingModel_s = new ArrayList<>();
                        for (Card card: cardGroup.getCards()) {
                            bindingModel_s.add(new Hc9BindingModel_().id(0)
                                    .card(card)
                                    .height(cardGroup.getHeight())
                                    .viewModel(viewModel));
                        }
                        CarouselModel_ carouselModel_ = new CarouselModel_().id(cardGroup.getId()).models(bindingModel_s);
                        epoxyController.add(carouselModel_);
                        break;
                    }

                    case "HC1":{
                        List<Hc1BindingModel_> bindingModel_s = new ArrayList<>();
                        if(cardGroup.isIs_scrollable()){
                            for (Card card: cardGroup.getCards()) {
                                bindingModel_s.add(new Hc1BindingModel_().id(0).card(card).viewModel(viewModel));
                            }
                            CarouselModel_ carouselModel_ = new CarouselModel_().id(cardGroup.getId()).models(bindingModel_s);
                            epoxyController.add(carouselModel_);
                        }else{
                            for (Card card: cardGroup.getCards()) {
                                Hc1BindingModel_ bindingModel_ = new Hc1BindingModel_().id(0).card(card).viewModel(viewModel);
                                bindingModel_s.add(bindingModel_);
                            }
                            CarouselModel_ carouselModel_ = new CarouselModel_().id(cardGroup.getId()).models(bindingModel_s);
                            epoxyController.add(carouselModel_);
                        }
                        break;
                    }
                }

            }


            return null;
        });

    }

}