package com.taruns.androidassignmentfampay.data.util;

import com.taruns.androidassignmentfampay.data.remote_models.CardResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CardApi {


    @GET("04a04703-5557-4c84-a127-8c55335bb3b4")
    Call<CardResponseModel> getCardGroups();


}
