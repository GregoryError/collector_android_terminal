package com.databank.collector.views;

import com.databank.collector.pojos.Parameter;

import java.util.List;

public interface ScreenView {
    void showData(List<Parameter> parameters);
    void showError(String msg);

    void onDataReady();
}
