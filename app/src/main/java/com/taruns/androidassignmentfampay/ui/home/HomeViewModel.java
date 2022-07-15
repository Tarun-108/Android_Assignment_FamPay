package com.taruns.androidassignmentfampay.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;
import com.taruns.androidassignmentfampay.repositories.CardGroupRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {


    private CardGroupRepository cardGroupRepository;
    private LiveData<CardResponseModel> cardGroupsLiveData;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        cardGroupRepository = new CardGroupRepository();
        cardGroupsLiveData = cardGroupRepository.getCardResponseModel();
    }

    public LiveData<CardResponseModel> getCardGroupsLiveData(){
        return cardGroupsLiveData;
    }

}
