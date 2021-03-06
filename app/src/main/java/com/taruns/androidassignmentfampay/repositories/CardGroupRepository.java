package com.taruns.androidassignmentfampay.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;
import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;
import com.taruns.androidassignmentfampay.data.util.CardApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class CardGroupRepository{


    private Call<CardResponseModel> cardGroupCall;
    private MutableLiveData<CardResponseModel> cardResponseModelMutableLiveData;

    ArrayList<String> designTypesInSequence = new ArrayList<String>(){
        {
            add("HC3");
            add("HC6");
            add("HC5");
            add("HC9");
            add("HC1");
        }
    };


    public void init(){

        cardResponseModelMutableLiveData = new MutableLiveData<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        CardApi cardApi = retrofit.create(CardApi.class);

        cardGroupCall = cardApi.getCardGroups();

    }


    public void fetchData() {


        cardGroupCall.enqueue(new Callback<CardResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<CardResponseModel> call, @NonNull Response<CardResponseModel> response) {
                if(response.body() != null){
                    /*
                     *  Rearranging the response in cardResponseModel so that HC3 is on top and the sequence is followed
                     */
                    CardResponseModel cardResponseModel = response.body();
                    ArrayList<CardGroup> inSequence = new ArrayList<>();
                    for (String designType: designTypesInSequence) {
                        for (CardGroup cardGroup: cardResponseModel.getCard_groups()) {
                            if(cardGroup.getDesign_type().equalsIgnoreCase(designType)){
                                inSequence.add(cardGroup);
                            }
                        }
                    }
                    cardResponseModel.setCard_groups(inSequence);
                    cardResponseModelMutableLiveData.postValue(cardResponseModel);
                }

            }

            @Override
            public void onFailure(@NonNull Call<CardResponseModel> call, @NonNull Throwable t) {
                cardResponseModelMutableLiveData.postValue(null);
            }
        });


    }

    public MutableLiveData<CardResponseModel> getCardResponseModel(){
        return cardResponseModelMutableLiveData;
    }

}
