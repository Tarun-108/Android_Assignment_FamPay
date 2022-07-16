package com.taruns.androidassignmentfampay.ui.home;

import static java.security.AccessController.getContext;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.taruns.androidassignmentfampay.data.remote_models.Card;
import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;
import com.taruns.androidassignmentfampay.repositories.CardGroupRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeViewModel extends AndroidViewModel {



    private CardGroupRepository cardGroupRepository;
    private MutableLiveData<CardResponseModel> cardGroupsLiveData;
    private Intent browserIntent;
    private MutableLiveData<Intent> browserIntentLiveData;
    private MutableLiveData<Pair<Boolean,String>> dismissedLiveData;

    private Boolean opened;



    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        cardGroupRepository = new CardGroupRepository();
        cardGroupRepository.init();
        cardGroupsLiveData = cardGroupRepository.getCardResponseModel();
        browserIntentLiveData = new MutableLiveData<>();
        dismissedLiveData = new MutableLiveData<>();
        opened = false;
    }

    public LiveData<CardResponseModel> getCardGroupsLiveData(){
        return cardGroupsLiveData;
    }

    public LiveData<Pair<Boolean,String>> getDismissedLiveData(){ return  dismissedLiveData;}


    public void onCardClick(String url){
        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntentLiveData.postValue(browserIntent);
    }



    public LiveData<Intent> getBrowserIntentLiveData(){return browserIntentLiveData;}

    public void onLongPressResize(View v){
        if (!opened) {
            ObjectAnimator animation = ObjectAnimator.ofFloat(v, "translationX", 450f);
            animation.setDuration(250);
            animation.start();
        } else {
            ObjectAnimator animation = ObjectAnimator.ofFloat(v, "translationX", 0f);
            animation.setDuration(250);
            animation.start();
        }
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
