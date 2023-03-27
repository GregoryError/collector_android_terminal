package com.databank.collector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.databank.collector.adapters.FillingAdapter;
import com.databank.collector.api.ApiFactory;
import com.databank.collector.pojos.Parameter;
import com.databank.collector.views.FillingActivity;
import com.google.gson.JsonObject;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // make auth stuff here

        Intent intent = new Intent(this, FillingActivity.class);
        startActivity(intent);
    }
}