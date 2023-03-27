package com.databank.collector.presenters;

import android.util.Log;

import com.databank.collector.api.ApiFactory;
import com.databank.collector.pojos.Parameter;
import com.databank.collector.views.Presentable;
import com.databank.collector.views.ScreenView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements Presentable {

    private ScreenView viewActivity;

    public MainPresenter(ScreenView viewActivity) {
        this.viewActivity = viewActivity;
    }

    @Override
    public void loadData() {

        ApiFactory.getInstance().getApiService().getAllParams().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                List<Parameter> parameters = new ArrayList<>();

                if (response.body() != null) {
                    JsonArray jsonArray = response.body().getAsJsonArray("response");

                    for (JsonElement e : jsonArray) {
                        parameters.add(new Parameter(e.getAsJsonObject().get("type_id").getAsInt(),
                                e.getAsJsonObject().get("name").getAsString(),
                                e.getAsJsonObject().get("id").getAsLong()));

//                        Log.d("OUT: ", e.toString());
                    }
                }


                viewActivity.showData(parameters);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                viewActivity.showError("Ошибка: " + t.getMessage());
            }
        });


    }
}
