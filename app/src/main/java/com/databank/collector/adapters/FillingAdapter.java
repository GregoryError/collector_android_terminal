package com.databank.collector.adapters;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.databank.collector.R;
import com.databank.collector.pojos.Parameter;

import java.util.List;

// types ids:
// 0 - integer
// 1 - double
// 2 - string
// 3 - enum

public class FillingAdapter extends RecyclerView.Adapter<FillingAdapter.FillingViewHolder> {

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    private List<Parameter> parameters;

    @NonNull
    @Override
    public FillingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.param_item, parent, false);
        return new FillingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FillingViewHolder holder, int position) {
        Parameter parameter = parameters.get(position);
        EditText editText = (EditText) holder.editTextFilling;
        editText.setHint(parameter.getName());

        switch (parameter.getType_id()) {
            case 0: {
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            }
            case 1: {
                editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                break;
            }
            case 2: {
                editText.setInputType(InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
                break;
            }

            default: break;
        }
    }

    @Override
    public int getItemCount() {
        return parameters.size();
    }

    public class FillingViewHolder extends RecyclerView.ViewHolder {

        public EditText editTextFilling;

        public FillingViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextFilling = itemView.findViewById(R.id.editTextFilling);
        }
    }
}
