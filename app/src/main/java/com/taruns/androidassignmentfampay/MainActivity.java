package com.taruns.androidassignmentfampay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.taruns.androidassignmentfampay.data.remote_models.CardGroup;
import com.taruns.androidassignmentfampay.data.util.CardApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] responseString = new String[1];

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        CardApi cardApi = retrofit.create(CardApi.class);

        Call<List<CardGroup>> call = cardApi.getCardGroups();

        call.enqueue(new Callback<List<CardGroup>>() {
            @Override
            public void onResponse(@NonNull Call<List<CardGroup>> call, @NonNull Response<List<CardGroup>> response) {
                if(!response.isSuccessful()){
                    responseString[0] = response.code()+ "";
                    return;
                }
                List<CardGroup> cardGroups = response.body();

                assert cardGroups != null;
                responseString[0] = cardGroups.toString();

                Log.d("Response String", responseString[0]);
            }

            @Override
            public void onFailure(@NonNull Call<List<CardGroup>> call, @NonNull Throwable t) {
                responseString[0] = t.getMessage();
                Log.e("Response String", responseString[0]);
            }
        });




    }
}