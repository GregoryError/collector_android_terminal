package com.databank.collector.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.databank.collector.R;
import com.databank.collector.adapters.FillingAdapter;
import com.databank.collector.pojos.Parameter;
import com.databank.collector.presenters.MainPresenter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class FillingActivity extends AppCompatActivity implements ScreenView {

    private MainPresenter presenter;
    private RecyclerView recyclerViewMain;
    //    private List<Parameter> parameters;
    private FillingAdapter fillingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filling);

        presenter = new MainPresenter(this);
        recyclerViewMain = findViewById(R.id.recyclerViewMain);
        fillingAdapter = new FillingAdapter();

        presenter.loadData();
//        parameters = new ArrayList<>();
//        parameters.add(new Parameter("Температура воздуха", 1));
//        parameters.add(new Parameter("Температура воды", 1));
//        parameters.add(new Parameter("Скорость судна", 0));
//        parameters.add(new Parameter("Членов экипажа", 0));
//        parameters.add(new Parameter("Глубина", 1));
//        parameters.add(new Parameter("Скорость ветра", 1));
//        parameters.add(new Parameter("Замечания", 2));


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
}