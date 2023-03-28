package com.databank.collector.adapters;

import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.databank.collector.R;
import com.databank.collector.pojos.Parameter;
import com.databank.collector.views.ScreenView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// types ids:
// 0 - integer
// 1 - double
// 2 - string
// 3 - enum
// 10 - service type

public class FillingAdapter extends RecyclerView.Adapter<FillingAdapter.FillingViewHolder> {

    public void setScreenView(ScreenView screenView) {
        this.screenView = screenView;
    }

    private ScreenView screenView;

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    private List<Parameter> parameters;

    public Map<Long, String> getParametersMap() {
        return parametersMap;
    }

    private Map<Long, String> parametersMap = new HashMap<>();

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
            default:
                break;
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

//            on edit end:
//            parameters.get(getAdapterPosition()).getId()
//                    +
//            editTextFilling.getText()
//            public Map<Long, String> getParametersMap() {
//            return parametersMap;
//    }


            editTextFilling.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                                                          @Override
                                                          public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                                              if (actionId == EditorInfo.IME_ACTION_NEXT
                                                                      || actionId == EditorInfo.IME_ACTION_DONE
                                                                      || actionId == EditorInfo.IME_ACTION_GO) {

                                                                  // the user is done typing.


                                                                  parametersMap.put(parameters.get(getAdapterPosition()).getId(), editTextFilling.getText().toString().trim());

                                                                  if (parametersMap.size() == parameters.size()) {
                                                                      Log.d("OUT:", parametersMap.toString());
                                                                      screenView.onDataReady();
                                                                  }


//                                                                  if (parametersMap.size() == parameters.size() - 1) {
//                                                                      editTextFilling.setImeOptions(EditorInfo.IME_ACTION_DONE);
//                                                                      return true;
//                                                                  }

                                                                  return false; // consume.

                                                              }
                                                              return false; // pass on to other listeners.
                                                          }
                                                      }
            );


        }
    }
}


















