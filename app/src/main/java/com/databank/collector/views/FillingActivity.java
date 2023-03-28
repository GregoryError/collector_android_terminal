package com.databank.collector.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.databank.collector.R;
import com.databank.collector.Report;
import com.databank.collector.adapters.FillingAdapter;
import com.databank.collector.api.ApiFactory;
import com.databank.collector.pojos.Parameter;
import com.databank.collector.presenters.MainPresenter;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.StreamHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FillingActivity extends AppCompatActivity implements ScreenView {

    private MainPresenter presenter;
    private RecyclerView recyclerViewMain;
    //    private List<Parameter> parameters;
    private FillingAdapter fillingAdapter;

    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filling);

        recyclerViewMain = findViewById(R.id.recyclerViewMain);
        sendButton = findViewById(R.id.buttonSend);

        presenter = new MainPresenter(this);
        fillingAdapter = new FillingAdapter();
        fillingAdapter.setScreenView(this);

        presenter.loadData();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fillingAdapter.getParametersMap().size() == fillingAdapter.getItemCount()) {
                    Report report = new Report();
                    report.setParameters(fillingAdapter.getParametersMap());
                    report.setApi_key("my_key");
                    report.setUserName("User");
                    report.setDateTime("28.03.2023 21:39");
                    report.setLat("23.3344");
                    report.setLon("54.4334");
                    ApiFactory.getInstance().getApiService().sendParams(report).enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }

    @Override
    public void showData(List<Parameter> parameters) {
        fillingAdapter.setParameters(parameters);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMain.setAdapter(fillingAdapter);
    }

    @Override
    public void showError(String msg) {
        Snackbar.make(recyclerViewMain, "sd", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onDataReady() {
        sendButton.setEnabled(true);
    }
}