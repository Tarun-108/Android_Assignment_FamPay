package com.taruns.androidassignmentfampay.ui.home;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;
import com.taruns.androidassignmentfampay.repositories.CardGroupRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {



    private CardGroupRepository cardGroupRepository;
    private LiveData<CardResponseModel> cardGroupsLiveData;
    private Intent browserIntent;
    private MutableLiveData<Intent> browserIntentLiveData;



    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        cardGroupRepository = new CardGroupRepository();
        cardGroupRepository.init();
        cardGroupsLiveData = cardGroupRepository.getCardResponseModel();
        browserIntentLiveData = new MutableLiveData<>();
    }

    public LiveData<CardResponseModel> getCardGroupsLiveData(){
        return cardGroupsLiveData;
    }

    public void onCardClick(String url){
        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntentLiveData.postValue(browserIntent);
    }

    public LiveData<Intent> getBrowserIntentLiveData(){return browserIntentLiveData;}

}
