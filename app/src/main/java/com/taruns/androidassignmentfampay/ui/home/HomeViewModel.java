package com.taruns.androidassignmentfampay.ui.home;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.taruns.androidassignmentfampay.data.remote_models.Card;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;
import com.taruns.androidassignmentfampay.repositories.CardGroupRepository;

public class HomeViewModel extends AndroidViewModel {


    private MutableLiveData<CardResponseModel> cardGroupsLiveData;
    private MutableLiveData<Intent> browserIntentLiveData;
    private MutableLiveData<Pair<Boolean,String>> dismissedLiveData;
    private CardGroupRepository cardGroupRepository;
    private Boolean opened;



    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        cardGroupRepository = new CardGroupRepository();
        cardGroupRepository.init();
        cardGroupRepository.fetchData();
        cardGroupsLiveData = cardGroupRepository.getCardResponseModel();
        browserIntentLiveData = new MutableLiveData<>();
        dismissedLiveData = new MutableLiveData<>();
        opened = false;
    }

    public void reInitializeRepoData(){
        cardGroupRepository.fetchData();
    }

    public LiveData<CardResponseModel> getCardGroupsLiveData(){
        return cardGroupsLiveData;
    }

    public LiveData<Pair<Boolean,String>> getDismissedLiveData(){ return  dismissedLiveData;}


    public void onCardClick(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntentLiveData.postValue(browserIntent);
    }



    public LiveData<Intent> getBrowserIntentLiveData(){return browserIntentLiveData;}

    public void onLongPressResize(View v){
        ObjectAnimator animation;
        if (!opened) {
            animation = ObjectAnimator.ofFloat(v, "translationX", 450f);
        } else {
            animation = ObjectAnimator.ofFloat(v, "translationX", 0f);
        }
        animation.setDuration(250);
        animation.start();
        opened = !opened;
    }


    public void onDismissOrRemindLater(boolean dismissed, String cardTitle){
        CardResponseModel cardGroups = cardGroupsLiveData.getValue();
        assert cardGroups != null;
        for (Card card: cardGroups.getCard_groups().get(0).getCards()) {
            if(card.getTitle().equalsIgnoreCase(cardTitle)){
                dismissedLiveData.postValue(new Pair<>(dismissed, cardTitle));
                cardGroups.getCard_groups().get(0).getCards().remove(card);
                cardGroupsLiveData.postValue(cardGroups);
            }
        }

    }


}
